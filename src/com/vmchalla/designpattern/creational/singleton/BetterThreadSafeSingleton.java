package com.vmchalla.designpattern.creational.singleton;

import java.util.List;

/**
 * This is a better performing singleton Synchronization is done only for
 * creation and not every time an instance is requested. This Way of Creating
 * Singleton is called : double Checked Locking Thread Safety : YES!!
 * Performance : GOOD!!! Is there a better way Still : YES see @BillPughSingleton
 * If your class is heavy-weight do not use this strategy. You might get
 * half-baked cookies!!!(worthless & breaking your code)
 * This can be countered by declaring the instance as volatile.
 * 
 * @author vmohanchalla
 *
 */
public class BetterThreadSafeSingleton {

	//Using this you will never get half-baked cookies!! :)
	private static volatile BetterThreadSafeSingleton btss;
	private List<String> colors;

	private BetterThreadSafeSingleton() {
	}

	public static BetterThreadSafeSingleton getInstance() {
		if (btss == null) {
			synchronized (BetterThreadSafeSingleton.class) {
				if (btss == null) {
					btss = new BetterThreadSafeSingleton();
				}
			}
		}

		return btss;
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
