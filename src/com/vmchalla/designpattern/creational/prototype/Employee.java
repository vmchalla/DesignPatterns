package com.vmchalla.designpattern.creational.prototype;

import java.util.List;

public class Employee {
	private String firstName;
	private String lastName;
	private List<String> routes;
	
	public Employee(){}
	
	public Employee(String firstName, String lastName, List<String> routes) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.routes = routes;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getRoutes() {
		return routes;
	}
	public void setRoutes(List<String> routes) {
		this.routes = routes;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName
				+ ", routes=" + routes.toString() + "]";
	}
	
	
	
	
	

}
