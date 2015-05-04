package com.vmchalla.designpattern.behavioural.observer;

import java.util.Observable;
import java.util.Observer;
/**
 * This class is an observer for ProductAvailability and updates the 
 * store-front properties
 * @author vmohanchalla
 *
 */
public class StoreFrontAvailabilityPopulator implements Observer{
	
	private ProductAvailability availabilityReport=null;
	
	public StoreFrontAvailabilityPopulator(ProductAvailability availabilityObj){
		this.availabilityReport=availabilityObj;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		if(o==this.availabilityReport){
			System.out.println("Change in availability - No. of products now available:"+((ProductAvailability)o).getAvailability());
			notifyStoreFrontForAvailabily(((ProductAvailability)o).getAvailability());
		} else {
			System.out.println("this Object is not being observed");
		}
		
	}
	
	private void notifyStoreFrontForAvailabily(int newAvailability){
		System.out.println("notification sent to storefront about change in availability with no> of products available :"+newAvailability);
	}

}
