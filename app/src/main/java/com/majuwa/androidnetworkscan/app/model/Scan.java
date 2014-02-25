package com.majuwa.androidnetworkscan.app.model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Scan {
	AddressContainer container;

	public Scan() {
		container = AddressContainer.instance();
	}

	public void scan() throws UnknownHostException,IOException {
		for (IPAddress ip : container) {
			InetAddress inet = InetAddress.getByName(ip.getHost());
			if (inet.isReachable(500))
				ip.setStatus(true);
			else
				ip.setStatus(false);
		}
	}
}
