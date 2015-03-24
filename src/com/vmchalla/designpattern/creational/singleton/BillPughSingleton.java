package com.vmchalla.designpattern.creational.singleton;

import java.util.List;

/**
 * Singleton created using Bill Pughs Stratagy : <b>no synchronization</b> still thread
 * safe Amazing isn't it!! The idea is to have a private static final class that
 * provides the instance and this inner class is not loaded until someone calls
 * getInstance
 * 
 * @author vmohanchalla
 *
 */
public class BillPughSingleton {

	private BillPughSingleton() {}

	private List<String> colors;

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		synchronized (this) {
			this.colors = colors;
		}
	}

	public void isColorPresent(String color) {
		if (colors.contains(color)) {
			System.out.println("Color present");
		} else {
			System.out.println("color not present");
		}
	}

}
