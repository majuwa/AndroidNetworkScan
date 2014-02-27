package com.majuwa.androidnetworkscan.app.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.majuwa.androidnetworkscan.app.R;
import com.majuwa.androidnetworkscan.app.control.MainController;

public class MainScreen extends Activity {
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }
    public void clear(View view){
        ((EditText)findViewById(R.id.txtFrom)).setText("");
        ((EditText)findViewById(R.id.txtTo)).setText("");
    }
    public void scanIPs(View view){
        progress = ProgressDialog.show(this,"Wait","Please wait while scanning",true,false);
        new ScanIPs().execute();
    }
    public void startNextView(){
        progress.dismiss();
        Intent intent = new Intent(this,ListIPs.class);
        startActivity(intent);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.about_menu:
                String licence = "This program is free software: you can redistribute it and/or modify \n"
                        + "it under the terms of the GNU General Public License as published by \n"
                        + "the Free Software Foundation, either version 3 of the License. \n"
                        + "\n"
                        + "This program is distributed in the hope that it will be useful, \n"
                        + "but WITHOUT ANY WARRANTY; without even the implied warranty of \n"
                        + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the \n"
                        + "GNU General Public License for more details. \n"
                        + " \n"
                        + "You should have received a copy of the GNU General Public License\n"
                        + "along with this program.  If not, see http://www.gnu.org/licenses/.\n";
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(this.getResources().getString(R.string.app_name) + "\n(C) 2014 majuwa\n" + licence)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        }).setTitle(this.getResources().getString(R.string.mnAbout)).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void showException(String message){
        progress.dismiss();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Error" + message)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).setTitle("Error").show();
    }
    private class ScanIPs extends AsyncTask<Void, Void, Void> {
        protected boolean failure = true;
        @Override
        protected Void doInBackground(Void ... voids) {
            try{
            MainController control = new MainController();
            String from = ((EditText)findViewById(R.id.txtFrom)).getText().toString();
            String to = ((EditText)findViewById(R.id.txtTo)).getText().toString();
            control.startScan(from, to);
                failure=false;
            }
            catch (Exception e){
                final String message = e.getMessage();
                runOnUiThread(new Runnable() {
                    public void run() {
                        showException(message);
                    }
                });

            }
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(Void result) {
            if(!failure)
                startNextView();
        }
    }


}
