package com.vmchalla.designpattern.structural.adapter;

import java.util.List;

/**
 * Processes the list of order Objects received.
 * 
 * @author vmohanchalla
 *
 */
public class OrdersProcessorImpl {

	public boolean process(List<Order> orders) {
		boolean isProcessSuccessful = true;
		System.out.println("accepts a list of order objects - sent by Adapter");

		// Custom processing of orders based on locations
		System.out.println("Custom processing of orders based on locations");

		System.out.println("-------------------------------------------------------");
		for (Order order : orders) {
			System.out.println("OrderId: " + order.getOrderId()
					+ " processed for location: " + order.getLocation());
		}
		System.out.println("-------------------------------------------------------");

		return isProcessSuccessful;
	}

}
