package com.majuwa.androidnetworkscan.app.control;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observer;

import com.majuwa.androidnetworkscan.app.model.Calculate;
import com.majuwa.androidnetworkscan.app.model.IPException;
import com.majuwa.androidnetworkscan.app.model.Scan;

public class MainController {
	private Observer observerObject;
	public MainController(){
		//observerObject =
	}
	public void startScan(String from,String to) throws UnknownHostException, IOException, IPException {


		new Calculate(from, to, this);
		Scan s = new Scan();
		s.scan();
		
	}
	public Observer getObserver(){
		return this.observerObject;
	}
	

}
