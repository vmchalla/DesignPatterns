package com.vmchalla.designpattern.creational.singleton;

import java.util.Arrays;
import java.util.List;

/**
 * This class is a singleton demonstrating static block initialization Is this
 * Thread Safe : NO!!!!
 * 
 * @author vmohanchalla
 *
 */
public class StaticBlockSingleton {
	// Here goes the variable which holds the only instance of the class
	private static StaticBlockSingleton sbs;
	private List<String> colors;

	// Here is the private constructor called from a static block

	private StaticBlockSingleton() {
		colors = Arrays.asList("red", "blue", "green", "megenta", "teal");
	}

	// Here is the static block that does the initialization
	// This will be called once when the class is initialized
	static {

		try {
			System.out.println("This will be printed only once");
			sbs = new StaticBlockSingleton();

		} catch (Exception e) {
			throw new RuntimeException("Exception while creating the instance");
		}

	}

	public static StaticBlockSingleton getInstance() {
		return sbs;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public void isColorPresent(String color) {
		if (colors.contains(color)) {
			System.out.println("Color present");
		} else {
			System.out.println("color not present");
		}
	}

}
