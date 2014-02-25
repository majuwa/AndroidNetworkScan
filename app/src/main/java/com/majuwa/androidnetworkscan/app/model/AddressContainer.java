package com.majuwa.androidnetworkscan.app.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * All IP-Addresses
 * 
 * @author majuwa
 * 
 */
public class AddressContainer implements Iterable<IPAddress> {
	private ArrayList<IPAddress> list;
	private static AddressContainer uniquee = null;

	private AddressContainer() {
		list = new ArrayList<IPAddress>();
	}

	public static AddressContainer instance() {
		if (AddressContainer.uniquee == null)
			AddressContainer.uniquee = new AddressContainer();
		return AddressContainer.uniquee;
	}

	public void insertAddress(IPAddress address) {
		if (!list.contains(address)) {
			list.add(address);
		}
	}
	public void removeAddress(IPAddress address){
		if(list.contains(address)){
			list.remove(address);
		}
	}
	public IPAddress[] getAll(){
		return (IPAddress[]) list.toArray();
	}
	@Override
	public Iterator<IPAddress> iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}
}
