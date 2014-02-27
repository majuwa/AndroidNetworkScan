package com.majuwa.androidnetworkscan.app.model;

import java.util.ArrayList;
import com.majuwa.androidnetworkscan.app.control.MainController;

public class Calculate {
	private MainController control;

	public Calculate(String from, String to, MainController controll) throws IPException {
		this.control = controll;
        this.testString(from);
        this.testString(to);
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
				AddressContainer.instance().insertAddress(tmp);
				k++;

			}
			break;
		case 5:
			break;
		default:
			break;
		}

	}
    private void testString(String test)throws IPException{
        if(!test.matches("\\d\\d\\d\\.\\d\\d\\d.\\d\\d\\d.\\d\\d\\d"))
            throw new IPException("String is not a valid IP-Address");
    }
}
