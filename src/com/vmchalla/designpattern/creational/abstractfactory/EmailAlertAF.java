package com.vmchalla.designpattern.creational.abstractfactory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.designpattern.creational.factory.process.EmailAlert;

public class EmailAlertAF implements AlertAF {

	@Override
	public boolean sendAlert(AlertsData data) {
		return new EmailAlert().processAlert(data);
	}

}
