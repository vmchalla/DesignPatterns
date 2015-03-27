package com.vmchalla.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * This class is built using prototype design pattern.
 * The class implements the cloneable interface.
 * @author vmohanchalla
 *
 */
public class TruckData implements Cloneable {

	private Employee driver;
	private Employee helper;
	private Date arrival;
	private String route;

	private String truckNumber;
	private String truckSize;
	private String truckType;

	public TruckData(Employee driver, Employee helper, Date arrival,
			String route, String truckNumber, String truckSize, String truckType) {
		this.driver = driver;
		this.helper = helper;
		this.arrival = arrival;
		this.route = route;
		this.truckNumber = truckNumber;
		this.truckSize = truckSize;
		this.truckType = truckType;
	}

	public Employee getDriver() {
		return driver;
	}

	public void setDriver(Employee driver) {
		this.driver = driver;
	}

	public Employee getHelper() {
		return helper;
	}

	public void setHelper(Employee helper) {
		this.helper = helper;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getTruckNumber() {
		return truckNumber;
	}

	public void setTruckNumber(String truckNumber) {
		this.truckNumber = truckNumber;
	}

	public String getTruckSize() {
		return truckSize;
	}

	public void setTruckSize(String truckSize) {
		this.truckSize = truckSize;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		temp.addAll(this.getDriver().getRoutes());
		Employee tempDriver = new Employee(this.getDriver().getFirstName(),
				this.getDriver().getLastName(), temp);
		temp.clear();
		temp.addAll(this.getHelper().getRoutes());
		Employee tempHelper = new Employee(this.getHelper().getFirstName(),
				this.getHelper().getLastName(), temp);

		return new TruckData(tempDriver, tempHelper, (Date) this.getArrival()
				.clone(), route, truckNumber, truckSize, truckType);
	}

	@Override
	public String toString() {
		return "TruckData [driver=" + (driver != null ? driver.toString(): "No Driver") + ", helper=" 
						+ (helper != null ? helper.toString() : "No Helper") + ", arrival=" + arrival
						+ ", route=" + route + ", truckNumber=" + truckNumber
						+ ", truckSize=" + truckSize + ", truckType="
						+ truckType + "]";
	}

}
