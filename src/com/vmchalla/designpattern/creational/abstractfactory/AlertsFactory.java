package com.vmchalla.designpattern.creational.abstractfactory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

public class AlertsFactory {
	
	public static boolean sendAlert(AlertsData data, AlertAF factory){
		System.out.println("Abstract Factory");
		return factory.sendAlert(data);
	}

}
