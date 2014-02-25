package com.majuwa.androidnetworkscan.app.com.majuwa.androidnetworkscan.model;
/**
 * A class for managing IP-Objects
 * @author majuwa
 *
 */
public class IPAddress {
	private String host;
	private boolean reachable;
	public IPAddress(String host){
		this.host = host;
	}
	/**
	 * Returns the Hostname
	 * @return String hostname/IP-Address
	 */
	public String getHost(){
		return this.host;
	}
	/**
	 * Set the Status of the IP-Address, if reachable or not
	 * @param reachable boolean true if reachable else false
	 */
	public void setStatus(boolean reachable){
		this.reachable = reachable;
	}
	/**
	 * Shows if IP-Adress is reachable in local Network
	 * @return true if reachable
	 */
	public boolean getStatus(){
		return this.reachable;
	}
	public boolean equals(Object o){
		if(o instanceof IPAddress){
			return getHost().equals(((IPAddress)o).getHost());
		}
		return false;
	}
	public String toString(){
		return this.getHost() + " is reachable: " + this.getStatus();
	}

}
