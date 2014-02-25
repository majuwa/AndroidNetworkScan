package com.majuwa.androidnetworkscan.app.model;

public class Configuration {
	private boolean showAllHosts = false;
	private String programmName = "Java-Network-Scan";
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
	public String getAppName(){
		return this.programmName;
	}
}
