package com.vmchalla.designpattern.creational.factory.process;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

/**
 * Subclass of Alert specific to SMS messages.
 * @author vmohanchalla
 *
 */
public class SmsAlert extends Alert {

	@Override
	public boolean processAlert(AlertsData alert) {
		//Each stage of processing might set this boolean to false.
		boolean isProcessedSucessfully = true;
		
		System.out.println("Processing SMS Alert");
		System.out.println("Message :" +alert.getMessage());
		System.out.println("PhoneNumber :"+ alert.getPhoneNumber());
		
		
		System.out.println("Stage 1: Scrubbing phone number to check its valid US phone number");
		
		System.out.println("Stage 2: Scrubbing Message to check against profanity");
		
		System.out.println("Stage 3: Send the Alert data via Rest Webservice to SMS Service Vendor");
		
		System.out.println("Stage 4: Save the response and the alert data to Database : call saveProcessedAlert()");
		isProcessedSucessfully = saveProcessedAlert();
		return isProcessedSucessfully;
	}

	

}
