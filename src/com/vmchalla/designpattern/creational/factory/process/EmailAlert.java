package com.vmchalla.designpattern.creational.factory.process;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

/**
 * Subclass of Alert specific to email messages.
 * @author vmohanchalla
 *
 */
public class EmailAlert extends Alert {

	@Override
	public boolean processAlert(AlertsData alert) {
		//Each stage of processing might set this boolean to false.
		boolean isProcessedSucessfully = true;
		System.out.println("Processing Email Alert");
		System.out.println("Message :" +alert.getMessage());
		System.out.println("EmailAddress :"+ alert.getEmail());
		
		System.out.println("Stage 1: Scrubbing email address to check its valid.");
		
		System.out.println("Stage 2: Scrubbing Message to check against profanity.");
		
		System.out.println("Stage 3: Send the Alert data to sendEmailService");
		
		System.out.println("Stage 4: Save  the alert data to Database : call saveProcessedAlert()");
		isProcessedSucessfully = saveProcessedAlert();
		return isProcessedSucessfully;
	}

	

}
