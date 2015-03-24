package com.vmchalla.designpattern.creational.singleton;
/**
 * This way of creating a singleton will keep you safe 
 * from reflection 
 * Downside : Less flexible what about our colors...
 * No Lazy Initialization
 * @author vmohanchalla
 *
 */
public enum SingletonEnum {
	
	SINGLETON;
	
	public static void doSomeStuff(){
		//Something like DB initialization maybe...
	}

}
