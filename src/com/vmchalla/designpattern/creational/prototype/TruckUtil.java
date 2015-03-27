package com.vmchalla.designpattern.creational.prototype;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * This class loads the truck data from one of the views of the database, at the
 * end of the day. It sends the retrieved truck data to different processors like
 * : dispatch processor which processes the dispatch for next day.
 * goodsProcessor which awaits the truck and takes over the truck from the
 * driver and helper to unload and clean the truck. These two require the exact
 * data retrieved from the database to run their processors for simplicity I am
 * taking only one truck in real time scenario there would be N trucks with N
 * routes.
 * 
 * @author vmohanchalla
 *
 */
public class TruckUtil {
	
	public static TruckData loadTruckData(){
		System.out.println("------Loading Truck Data from Database---------");
		
		//Assume all the below data comes from the Database.
		//building EmployeesData
		Employee driver = new Employee();
		driver.setFirstName("Jason");
		driver.setLastName("Akerman");
		List<String>assignedDriverRoutes = Arrays.asList("Bronx", "Brooklyn");
		driver.setRoutes(assignedDriverRoutes);
		
		Employee helper = new Employee();
		helper.setFirstName("Robert");
		helper.setLastName("Peter");
		List<String> assignedHelperRoutes =  Arrays.asList("Bronx", "Brooklyn");
		helper.setRoutes(assignedHelperRoutes);
		
		//Loading Truck Data
		Date arrival = new Date();
		String route = "Bronx";
		String truckNumber = "APJ1010";
		String truckSize ="Large";
		String truckType ="FrozenFoodCarrier";
		
		TruckData truck = new TruckData(driver, helper, arrival, route, truckNumber, truckSize, truckType);
		return truck;
	}
	
	public static boolean processTruckForPlant(TruckData truck){
		
		//Finds the personnel who are available when the truck is due for arrival
		Date arrivalTime = truck.getArrival(); 
		
		System.out.println("Find the personel to unload the truck and clean it at :"+arrivalTime.getTime());
		
		//Set the Arrival Date to actual arrival time 
		truck.setArrival(new Date());
		System.out.println("The truck Actually arrived at : "+new Date().getTime());
		
		//This truck info is sent again to payroll to calculate the employees pay.
		System.out.println("Send the truck data to payroll to calculate employee pay");
		
		//gets the truck driver and helper info and logs them out Once the truck arrives.
		System.out.println("Logged out :"+truck.getDriver().getFirstName()+" "+
		truck.getDriver().getLastName()+" and "+ truck.getHelper().getFirstName()+
		" "+ truck.getHelper().getLastName());
		
		Employee driverDeliveringTruckToDispatch = new Employee("Roshan", "Mahanama", Arrays.asList("DispatchArea"));
		
		truck.setDriver(driverDeliveringTruckToDispatch);
		truck.setHelper(null);
		truck.setRoute("DispatchArea");
		boolean isTruckSentToDispatch = notifyDispatch();
		return isTruckSentToDispatch;
		
	}
	
	public static boolean processTruckForDispatch(TruckData truck){
		//this gets the driver and helper information so that not to assign 
		//them work for next trip.. They will be exhausted need new drivers.
		System.out.println("get the Employees to asign from available pool other than"+
		truck.getDriver().getFirstName()+" "+ truck.getDriver().getLastName()+
		" and "+truck.getHelper().getFirstName()+ " " + truck.getHelper().getLastName());
		
		//Say they select two of the employees who offer to go to that route.
		truck.setDriver(new Employee("Brad", "Pitt", Arrays.asList("Queens","Long Island")));
		truck.setHelper(new Employee("Salman", "Khan", Arrays.asList("Queens","Long Island")));
		truck.setRoute("Queens");
		truck.setArrival(new Date());
		//After processing the dispatch send back if dispatch ready.
		boolean isDispatchReady =isTruckReadyForDispatch();
		//Send the truck info to be loaded in DB for next day processing
		return isDispatchReady;
	}
	
	private static boolean notifyDispatch(){
		return true;
	}
	
	private static boolean isTruckReadyForDispatch(){
		return true;
	}

}
