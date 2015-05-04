package com.vmchalla.designpattern.behavioural.observer;

public class AvailabilityService {
	
	private ProductAvailability productAvailability;
	private StoreFrontAvailabilityPopulator observer;
	public AvailabilityService(int availability){
		this.productAvailability = new ProductAvailability(availability);
		this.observer = new StoreFrontAvailabilityPopulator(productAvailability);
		this.productAvailability.addObserver(observer);
		
	}
	
	public int getCurrentAvailability(){
		return this.productAvailability.getAvailability();
	}
	
	public void notifyAvailabilityChange(int newAvailability){
		productAvailability.setAvailability(newAvailability);
	}

}
