package com.vmchalla.designpattern.creational.factory;

import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.designpattern.creational.factory.process.Alert;
import com.vmchalla.designpattern.creational.factory.process.EmailAlert;
import com.vmchalla.designpattern.creational.factory.process.PaperAlert;
import com.vmchalla.designpattern.creational.factory.process.SmsAlert;

/**
 * This class will be called with the AlertsData as input to process.
 * The call could be from different systems thats integrating with the alerts system
 * like the financial department or HR department or any other department within your 
 * company that want an alert sent to a customer or an employee or another company.
 * This code might be  specific to alerts department that objectively sees the message and the
 * mode of sending the alert and also asking downstream department SMSHandler, EmailHandler 
 * or Paper Mail handler to send the alert.
 * @author vmohanchalla
 *
 */
public class AlertsFactory {
	
	private static final String SMS_MESSAGE_TYPE = "sms";
	private static final String EMAIL_MESSAGE_TYPE = "email";
	private static final String MAIL_MESSAGE_TYPE = "usps";
	
	private transient Alert alertToProcess;
	
	private AlertsFactory(){}
	
	private static class SingletonHelper {
		private static final AlertsFactory INSTANCE = new AlertsFactory();
	}
	public static AlertsFactory getInstance(){
		return SingletonHelper.INSTANCE;
	}
	
	public  boolean sendAlert(AlertsData data){
		boolean isSuccessfullyProcessed = true;
		switch (data.getType()) {
		case SMS_MESSAGE_TYPE:
			alertToProcess = new SmsAlert();
			isSuccessfullyProcessed=alertToProcess.processAlert(data);
			break;
			
		case EMAIL_MESSAGE_TYPE:
			alertToProcess = new EmailAlert();
			isSuccessfullyProcessed=alertToProcess.processAlert(data);
			break;
			
		case MAIL_MESSAGE_TYPE:
			alertToProcess = new PaperAlert();
			isSuccessfullyProcessed=alertToProcess.processAlert(data);
			break;

		default:
			System.out.println("Alert Type not recognized cannot be processed.");
			isSuccessfullyProcessed=false;
			break;
		}
		
		return isSuccessfullyProcessed;
	}

}
