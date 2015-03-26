package com.vmchalla.designpattern.creational.factory.process;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

/**
 * This is the base class that defined the common data and methods for
 * subclasses extending it.
 * 
 * @author vmohanchalla
 *
 */
public abstract class Alert {
	public abstract boolean processAlert(AlertsData alert);

	/**
	 * This is called by processAlert() of subclasses to store the 
	 * processed data in the database.
	 */
	protected boolean saveProcessedAlert(){
		boolean isSavedSuccessfully=true;
		
		// calling the DAO with the provided bean to store in Database.
		System.out.println("Stage 5: DAO call to store the alert in database of your choice.");
		
		return isSavedSuccessfully;
	}

}
