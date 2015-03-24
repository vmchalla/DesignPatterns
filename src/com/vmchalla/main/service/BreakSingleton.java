package com.vmchalla.main.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import com.vmchalla.designpattern.creational.singleton.BillPughSingleton;
import com.vmchalla.designpattern.creational.singleton.SingletonLazy;
import com.vmchalla.designpattern.creational.singleton.StaticBlockSingleton;
import com.vmchalla.designpattern.creational.singleton.SynchronizedSingleton;

/**
 * This class shows how reflection can break Singleton Pattern
 * @author vmohanchalla
 *
 */
public class BreakSingleton {
	/**
	 * Assuming you did not mess up the code!!! :)
	 * By now we already have singleton for 
	 * @StaticBlockSingleton
	 * @SingletonLazy
	 * @SynchronizedSingleton
	 * @BillPughSingleton
	 * Lets Break them
	 */
	public static void notSingletonAnymoreDemo(){
		//-------------Break @StaticBlockSingleton --------------------------------
		StaticBlockSingleton sbs1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton sbs2 = null;
		
		try {
			Constructor[] constructors = StaticBlockSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors){
				constructor.setAccessible(true);
				sbs2 = (StaticBlockSingleton)constructor.newInstance(new Object[0]);
				break;
			}
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		System.out.println("StaticBlockSingleton instance 1 HashCode :"+sbs1.hashCode());
		System.out.println("StaticBlockSingleton instance 2 HashCode :"+sbs2.hashCode());
		System.out.println("sbs1==sbs2 i.e. Same Instance :"+ (sbs1==sbs2));
		if(sbs1==sbs2){
			System.out.println("We were not able to break this");
		} else {
			System.out.println("We broke the Singleton Design");
			
		}
		
		//-----------------Break @SingletonLazy ----------------------------
		
		SingletonLazy sl1 = SingletonLazy.getInstance();
		SingletonLazy sl2 = null;
		
		try {
			Constructor[] constructors = SingletonLazy.class.getDeclaredConstructors();
			for(Constructor constructor: constructors){
				constructor.setAccessible(true);
				sl2 = (SingletonLazy)constructor.newInstance(new Object[0]);
				break;
			}
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("SingletonLazy instance 1 HashCode :"+sl1.hashCode());
		System.out.println("SingletonLazy instance 2 HashCode :"+sl2.hashCode());
		System.out.println("is sl1==sl2 is same Instance: "+ (sl1==sl2));
		if(sl1==sl2){
			System.out.println("We were not able to break this");
		} else {
			System.out.println("We broke the Singleton Design");
			
		}
		
		//-------------------Breaking @SynchronizedSingleton ---------------------
		SynchronizedSingleton ss1 = SynchronizedSingleton.getInstance();
		SynchronizedSingleton ss2 = null;
		
		try {
			Constructor[] constructors = SynchronizedSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors){
				constructor.setAccessible(true);
				ss2 = (SynchronizedSingleton)constructor.newInstance(new Object[0]);
				break;
			}
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("SynchronizedSingleton instance 1 HashCode :"+ss1.hashCode());
		System.out.println("SynchronizedSingleton instance 2 HashCode :"+ss2.hashCode());
		System.out.println("is ss1==ss2 is same Instance: "+ (ss1==ss2));
		if(ss1==ss2){
			System.out.println("We were not able to break this");
		} else {
			System.out.println("We broke the Singleton Design");
			
		}
		
		//------------Breaking @BillPughSingleton ------------------------------
		BillPughSingleton bps1 = BillPughSingleton.getInstance();
		BillPughSingleton bps2 = null;
		
		try {
			Constructor[] constructors = BillPughSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors){
				constructor.setAccessible(true);
				Parameter[] parameters = constructor.getParameters();
				System.out.println(parameters.length);
				System.out.println(parameters[0].getType());

				bps2 = (BillPughSingleton)constructor.newInstance(bps1);
				break;
			}
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			System.out.println("Not able to Break BIllpugh Singleton"+e.getMessage());
			
		} 
		System.out.println("BillPughSingleton instance 1 HashCode :"+bps1.hashCode());
		System.out.println("BillPughSingleton instance 2 HashCode :"+bps2.hashCode());
		System.out.println("is bps1==bps2 is same Instance: "+ (bps1==bps2));
		if(bps1==bps2){
			System.out.println("We were not able to break this");
		} else {
			System.out.println("We broke the Singleton Design");
			
		}
		
		
	}

}
