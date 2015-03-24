package com.vmchalla.main;

import com.vmchalla.main.service.BreakSingleton;
import com.vmchalla.main.service.DemoSingletons;


/**
 * This class demonstrates different design patterns - 
 * by calling the specific classes that showcase the pattern.
 * @author vmohanchalla
 *
 */
public class MainStub {

	public static void main(String[] args) {
		
		//Initializing the service
		DemoSingletons demo = new DemoSingletons();
		//-------------------------Static Block Singleton -------------------------
		demo.staticSingletonDemo();
		
		//------------------------------LazyInitialization -------------------------
		demo.lazySingletonDemo();
		
		//------------------------------Synchronized Singleton----------------------
		demo.synchronizedSingletonDemo();
		
		//-----------------------------Bill pughs strategy--------------------------
		demo.threadSafeNoSynchronizationSingletonDemo();
		
		//----------Breaking the above created Singletons---------------------------
		BreakSingleton.notSingletonAnymoreDemo();

	}

}
