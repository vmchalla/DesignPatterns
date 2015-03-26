package com.vmchalla.designpattern.creational.abstractfactory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.designpattern.creational.factory.process.PaperAlert;

public class PaperAlertAF implements AlertAF{

	@Override
	public boolean sendAlert(AlertsData data) {
		return new PaperAlert().processAlert(data);
	}

}
