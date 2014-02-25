package com.majuwa.androidnetworkscan.app.model;

import java.util.ArrayList;
import com.majuwa.androidnetworkscan.app.control.MainController;

public class Calculate {
	private ArrayList<String> ips;
	private MainController controll;

	public Calculate(String from, String to, MainController control) {
		this.controll = control;
		calculateIPs(from, to);
	}

	private void calculateIPs(String from, String to) {
		int k, j, i;
		String[] fromArray = from.split("\\.");
		String[] toArray = to.split("\\.");
		i = 1;
		while (i < 5 && fromArray[i].equals(toArray[i++]))
			;
		switch (i) {
		case 0:

			break;
		case 1:
			break;
		case 4:
			k = Integer.parseInt(fromArray[3]);
			j = Integer.parseInt(toArray[3]);
			while (k <= j) {
				IPAddress tmp = new IPAddress(String.format("%s.%s.%s.%s",
						fromArray[0], fromArray[1], fromArray[2], "" + k));
				tmp.addObserver(controll.getObserver());
				AddressContainer.instance().insertAddress(tmp);
				k++;

			}
			break;
		case 5:
			ips.add(from);
			break;
		default:
			break;
		}

	}
}
