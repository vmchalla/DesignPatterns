package com.vmchalla.designpattern.creational.factory.data;

public class AlertsData {
	/**Type of Alert either SMS, email or paper
	 * 
	 */
	private String type;
	
	/**Message to be sent to the customer
	 * 
	 */
	private String message;
	
	/**
	 * Field specific to SMS Alerts
	 */
	private String phoneNumber;
	
	/**
	 * field specific to Email Alerts
	 */
	private String address;
	
	/**
	 * Field specific to Paper Alerts
	 */
	private String email;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "Type : "+ this.type + " Message : "+this.message;
	}
	
	

}
