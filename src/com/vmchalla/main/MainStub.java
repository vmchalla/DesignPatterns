package com.vmchalla.main;

import com.vmchalla.designpattern.creational.abstractfactory.EmailAlertAF;
import com.vmchalla.designpattern.creational.abstractfactory.PaperAlertAF;
import com.vmchalla.designpattern.creational.abstractfactory.SmsAlertAF;
import com.vmchalla.designpattern.creational.factory.AlertsFactory;
import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.main.service.BreakSingleton;
import com.vmchalla.main.service.DemoSingletons;


/**
 * This class demonstrates different design patterns - 
 * by calling the specific classes that showcase the pattern.
 * @author vmohanchalla
 *
 */
public class MainStub {

	public static void main(String[] args) {
		
		//----------------------------------------Singleton DP-------------------------------------------------------------
		
		//Initializing the service
		DemoSingletons demo = new DemoSingletons();
		//-------------------------Static Block Singleton -------------------------
		demo.staticSingletonDemo();
		
		//------------------------------LazyInitialization -------------------------
		demo.lazySingletonDemo();
		
		//------------------------------Synchronized Singleton----------------------
		demo.synchronizedSingletonDemo();
		
		//-----------------------------Bill pughs strategy--------------------------
		demo.threadSafeNoSynchronizationSingletonDemo();
		
		//----------Breaking the above created Singletons---------------------------
		BreakSingleton.notSingletonAnymoreDemo();
		
		//------------------------------------------Factory DP --------------------------------------------------------------
		
		//Create 3 different alerts data
		
		AlertsData sms = new AlertsData();
		sms.setType("sms");
		sms.setMessage("Hi, This is a wakeup message : Please Code");
		sms.setPhoneNumber("(321) 213-3321");
		
		AlertsData email = new AlertsData();
		email.setType("email");
		email.setMessage("Hi, This is your coffee email: Please turn this coffee to code");
		email.setEmail("bogus@nolocalhost.com");
		
		AlertsData paperMail = new AlertsData();
		paperMail.setType("usps");
		paperMail.setMessage("Hi, Just validating you live here");
		paperMail.setAddress("11 Bogus St. Apt#11 New York NY 11101");
		
		//Call the factory to process these three alerts.
		//As you can notice the client code does not know the implementation details it has one factory to code for.
		boolean isSmsAlertSuccess = AlertsFactory.getInstance().sendAlert(sms);
		System.out.println("Was the SMS sent :"+isSmsAlertSuccess);
		
		boolean isEmailSent = AlertsFactory.getInstance().sendAlert(email);
		System.out.println("Was email sent :"+ isEmailSent);
		
		boolean didWeWastePaper = AlertsFactory.getInstance().sendAlert(paperMail);
		System.out.println("Were trees destroyed because of our foolishness: " + didWeWastePaper);
		
		//-----------------------------------Abstract Factory DP ---------------------------------------------------
		
		//Here there is no if-else logic to decipher the implementation 
		//The client code specifies the factory name which in-turn calls the implementation code.
		
		//reusing the existing AlertsData - show do the same thing as factory ...
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(sms,new SmsAlertAF());
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(email, new EmailAlertAF());
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(paperMail, new PaperAlertAF());
		
		
		

	}

}
