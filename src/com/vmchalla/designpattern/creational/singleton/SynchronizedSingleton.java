package com.vmchalla.designpattern.creational.singleton;

import java.util.List;

/**
 * This singleton class is thread safe.(instance Creation only) what about
 * setColors ??? we need to synchronize that as well What about performance 
 * POOR !!!!
 * 
 * @author vmohanchalla
 *
 */
public class SynchronizedSingleton {

	private static SynchronizedSingleton ss;
	private List<String> colors;

	private SynchronizedSingleton() {
	}

	// Extra overhead - every time we need an instance we perform
	// synchronization
	// Is there a better way : SURE!!! -- check @BetterThreadSafeSingleton
	public static synchronized SynchronizedSingleton getInstance() {
		if (ss == null) {
			ss = new SynchronizedSingleton();
		}
		return ss;
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
