package com.vmchalla.main;

import com.vmchalla.designpattern.creational.abstractfactory.EmailAlertAF;
import com.vmchalla.designpattern.creational.abstractfactory.PaperAlertAF;
import com.vmchalla.designpattern.creational.abstractfactory.SmsAlertAF;
import com.vmchalla.designpattern.creational.builder.FoodProduct;
import com.vmchalla.designpattern.creational.builder.FoodProduct.FoodProductBuilder;
import com.vmchalla.designpattern.creational.factory.AlertsFactory;
import com.vmchalla.designpattern.creational.factory.data.AlertsData;
import com.vmchalla.designpattern.creational.prototype.TruckData;
import com.vmchalla.designpattern.creational.prototype.TruckUtil;
import com.vmchalla.main.service.BreakSingleton;
import com.vmchalla.main.service.DemoSingletons;


/**
 * This class demonstrates different design patterns - 
 * by calling the specific classes that showcase the pattern.
 * @author vmohanchalla
 *
 */
public class MainStub {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		//----------------------------------------Singleton DP-------------------------------------------------------------
		System.out.println("------------------SINGLETON PATTERN-----------------------------");
		System.out.println(" \n ");
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
		System.out.println(" \n ");
		System.out.println("------------------FACTORY PATTERN-----------------------------");
		System.out.println(" \n ");
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
		System.out.println(" \n ");
		System.out.println("------------------ABSTRACT FACTORY PATTERN-----------------------------");
		System.out.println(" \n ");
		//Here there is no if-else logic to decipher the implementation 
		//The client code specifies the factory name which in-turn calls the implementation code.
		
		//reusing the existing AlertsData - show do the same thing as factory ...
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(sms,new SmsAlertAF());
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(email, new EmailAlertAF());
		com.vmchalla.designpattern.creational.abstractfactory.AlertsFactory.sendAlert(paperMail, new PaperAlertAF());
		
		//----------------------------------------Builder DP--------------------------------------------------------
		System.out.println(" \n ");
		System.out.println("------------------BUILDER PATTERN-----------------------------");
		System.out.println(" \n ");
		//Say we need a food product called idly
		//Building the product
		
		//Say we get product id , type and name in a flat file.
		System.out.println("Recieved product Id, type and name from upstram in a flat file.");
		FoodProductBuilder idlyBuilder = new FoodProductBuilder("idly_023", "4 min Meal", "Make Idly in 4 minutes");
		
		//Now we query database with given Id to get the other details.
		System.out.println("queried database and got further information regarding the food product to build");
		idlyBuilder = idlyBuilder.category("IndianFood").department("Heat and Eat").isAvailable(true).isFrozen(true).isSeasonal(false);
		
		System.out.println("Now we make a web service call to third party to get more details");
		idlyBuilder = idlyBuilder.soldBy("MTR").saleUnit("EA").nutritionalFacts("Healthy");
		
		//I know you might be thinking of price ... Its free promotion!!!  :P
		
		//Here is the immutable product.
		final FoodProduct idly = idlyBuilder.buildFoodProduct();
		
		System.out.println("Heres our product: "+idly.getProductName());
		System.out.println("Here are the details :" +idly.toString());
		System.out.println("This object is immutable... :) ");
		
		//-------------------------------------Prototype Pattern--------------------------------------------
		System.out.println(" \n ");
		System.out.println("------------------PROTOTYPE PATTERN-----------------------------");
		System.out.println(" \n ");
		//Load the Truck Data from Database.
		TruckData truckFromDB = TruckUtil.loadTruckData();
		
		System.out.println(truckFromDB.toString());
		
		//Clone the truckFromDB 
		TruckData clonedTruck = (TruckData)truckFromDB.clone();
		System.out.println(clonedTruck.toString());
		//Send the original one to plant
		boolean isTruckSentToDispatch = TruckUtil.processTruckForPlant(truckFromDB);
		
		System.out.println("After Processing in plant ");
		System.out.println("Original truck from DB");
		System.out.println(truckFromDB.toString());
		System.out.println("cloned Truck From DB");
		System.out.println(clonedTruck.toString());
		
		
		if(isTruckSentToDispatch){
			TruckUtil.processTruckForDispatch(clonedTruck);
		}
		System.out.println("After Processing in dispatch ");
		System.out.println("cloned Truck From DB");
		System.out.println(clonedTruck.toString());

	}

}
