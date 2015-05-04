package com.vmchalla.designpattern.behavioural.observer;

import java.util.Observable;
/**
 * This is the subject whenever the availability changes the observers added to this class are notified
 * which do some custom tasks like updating the store-front properties so that the customer 
 * is not left in dark about the availability of the item.
 * @author vmohanchalla
 *
 */
public class ProductAvailability extends Observable{
	
	private int availability;

	public int getAvailability() {
		return availability;
	}


	public void setAvailability(int availability) {
		this.availability = availability;
		setChanged();
		notifyObservers();
	}



	public ProductAvailability(int availability){
		this.availability=availability;
	}

}
