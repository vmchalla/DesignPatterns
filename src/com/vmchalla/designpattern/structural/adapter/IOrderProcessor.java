package com.vmchalla.designpattern.structural.adapter;

import java.util.Map;

public interface IOrderProcessor {
	public  boolean processOrders(Map<String,String>orderIdsAndLocations);
}
