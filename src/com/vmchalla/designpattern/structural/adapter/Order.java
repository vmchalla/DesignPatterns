package com.vmchalla.designpattern.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class Order {
	
	//Assume this locations is set from valid locations in Database
	private static volatile List<String>locations;
	private String orderId;
	private String location;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getLocation() {
		return this.location;
	}
	public void setLocation(String location) throws IllegalArgumentException{
		if(locations.contains(location)){
		this.location = location;
		} else {
			throw new IllegalArgumentException();
		}
	}
	public List<String> getLocations() {
		return locations;
	}
	public static void loadLocations() {
		//This should from a database. And there should be some caching mechanism implemented
		if(locations==null){
			synchronized (Order.class) {
				if(locations==null){
					locations =  Arrays.asList("Manhatten", "Bronx", "Brooklyn", "Queens");
				}
			}
			
		} 
	}
	
	
	
	

}
