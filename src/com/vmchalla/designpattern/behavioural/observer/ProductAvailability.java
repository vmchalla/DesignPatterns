package com.vmchalla.designpattern.behavioural.observer;

import java.util.Observable;

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
