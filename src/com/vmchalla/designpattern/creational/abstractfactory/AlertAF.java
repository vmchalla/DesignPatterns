package com.vmchalla.designpattern.creational.abstractfactory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

public interface AlertAF {
	public boolean sendAlert(AlertsData data);

}
