package com.vmchalla.designpattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class transforms the hashmap sent from client to list of orderObjects to
 * work with (say) newly upgraded orderProcessor which accepted a hasmap now
 * accepts a list of OrderObjects.
 * 
 * @author vmohanchalla
 *
 */
public class OrderProcessorAdapter implements IOrderProcessor{
	
	@Override
	public  boolean processOrders(Map<String,String>orderIdsAndLocations){
		boolean isProcessSuccessful = false;
		System.out.println("Adapter converting the hashmap to list of Order Objects");
		isProcessSuccessful = new OrdersProcessorImpl().process(adapterToConverMapToList(orderIdsAndLocations));
		return isProcessSuccessful;
	}
	
	private  List<Order> adapterToConverMapToList(Map<String,String>orderAndLocationMap){
		List<Order> orders = new ArrayList<Order>();
		Order.loadLocations();
		for(Map.Entry<String,String> entry:orderAndLocationMap.entrySet()){
			Order temp = new Order();
			temp.setOrderId(entry.getKey());
			try {
				temp.setLocation(entry.getValue());
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Location not recognized by Order System");
			}
			orders.add(temp);
		}
		
		return orders;
		
	}

}
