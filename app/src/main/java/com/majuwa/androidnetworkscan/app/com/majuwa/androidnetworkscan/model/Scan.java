package com.majuwa.androidnetworkscan.app.com.majuwa.androidnetworkscan.model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Scan {
	AddressContainer container;

	public Scan() {
		container = AddressContainer.instance();
	}

	public void scan() throws UnknownHostException,IOException {
		boolean hosts = Configuration.instance().getShowAllHosts();
		for (IPAddress ip : container) {
			InetAddress inet = InetAddress.getByName(ip.getHost());
			if (inet.isReachable(5000))
				ip.setStatus(true);
			else
				if(hosts)
					ip.setStatus(false);
				else
					container.removeAddress(ip);
			
			
		}
	}
}
