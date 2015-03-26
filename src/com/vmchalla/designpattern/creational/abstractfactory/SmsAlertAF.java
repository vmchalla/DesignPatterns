package com.vmchalla.designpattern.creational.abstractfactory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.designpattern.creational.factory.process.SmsAlert;

public class SmsAlertAF implements AlertAF{

	@Override
	public boolean sendAlert(AlertsData data) {
		return new SmsAlert().processAlert(data);
	}
	

}
