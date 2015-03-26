package com.vmchalla.designpattern.creational.factory.process;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;

/**
 * Subclass of Alert specific to paper mail send using USPS.
 * @author vmohanchalla
 *
 */
public class PaperAlert extends Alert {

	@Override
	public boolean processAlert(AlertsData alert) {
		//Each stage of processing might set this boolean to false.
				boolean isProcessedSucessfully = true;
				System.out.println("Processing Address Alert");
				System.out.println("Message :" +alert.getMessage());
				System.out.println("Address :"+ alert.getAddress());
				
				System.out.println("Stage 1: Scrubbing  address to check its valid and exists.");
				
				System.out.println("Stage 2: Scrubbing Message to check against profanity.");
				
				System.out.println("Stage 3: Send the Alert data to usps dispatch department");
				
				System.out.println("Stage 4: Save  the alert data to Database : call saveProcessedAlert()");
				isProcessedSucessfully = saveProcessedAlert();
				return isProcessedSucessfully;
	}

	

}
