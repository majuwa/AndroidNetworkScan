package com.majuwa.androidnetworkscan.app.com.majuwa.androidnetworkscan.model;

import java.util.ArrayList;

public class Calculate{
	private ArrayList<String> ips;

	public Calculate(String from, String to) {

	}

	private void calculateIPs(String from, String to) {
		int k, j, i;
		String[] fromArray = from.split(".");
		String[] toArray = to.split(".");
		i = 1;
		while (i < 4 && fromArray[i].equals(toArray[i++]))
			;
		switch (i) {
		case 0:

			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			k = Integer.parseInt(fromArray[3]);
			j = Integer.parseInt(toArray[3]);
			while (k < j) {
				AddressContainer.instance().insertAddress(
						new IPAddress(String.format("%s.%s.%s.%s",
								fromArray[0], fromArray[1], fromArray[2], ""
										+ k)));
				k++;

			}
			break;
		case 4:
			ips.add(from);
			break;
		default:
			break;
		}

	}

	private void range(String block, String ende) {
		int i = Integer.parseInt(block);
		int j = Integer.parseInt(ende);

	}
}
