package com.majuwa.androidnetworkscan.app.view;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.majuwa.androidnetworkscan.app.R;
import com.majuwa.androidnetworkscan.app.model.AddressContainer;
import com.majuwa.androidnetworkscan.app.model.IPAddress;

import java.util.HashMap;
import java.util.List;

public class ListIPs extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ips);

        final ListView listview = (ListView) findViewById(R.id.list);
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, AddressContainer.instance().getAll());
        listview.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_ips, menu);
        return true;
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
        return super.onOptionsItemSelected(item);
    }
    private class StableArrayAdapter extends ArrayAdapter<IPAddress> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  IPAddress[] objects) {
            super(context, textViewResourceId,objects);
            for (int i = 0; i < objects.length; ++i) {
                mIdMap.put(objects[i].toString(), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position).toString();
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }

}
