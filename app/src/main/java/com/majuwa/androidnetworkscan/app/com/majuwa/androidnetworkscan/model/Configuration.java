package com.majuwa.androidnetworkscan.app.com.majuwa.androidnetworkscan.model;

public class Configuration {
	private boolean showAllHosts = false;
	private static Configuration uniquee;
	public Configuration(){
		loadConfig();
	}
	private void loadConfig(){
		
	}
	public boolean getShowAllHosts(){
		return showAllHosts;
	}
	public static Configuration instance(){
		if(uniquee==null){
			uniquee = new Configuration();
		}
		return uniquee;
	}
}
