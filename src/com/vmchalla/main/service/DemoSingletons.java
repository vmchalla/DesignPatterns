package com.vmchalla.main.service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.vmchalla.designpattern.creational.singleton.SingletonLazy;
import com.vmchalla.designpattern.creational.singleton.StaticBlockSingleton;
import com.vmchalla.main.threads.BillPughSingletonThreads;
import com.vmchalla.main.threads.OverheadSingletonThreads;

/**
 * This service class holds the code for demonstrating all the singleton pattern
 * classes under com.vmchalla.designpattern.creational.singleton We will
 * implement Each class and use executorService/forkJoinPool to create number of
 * threads that will access each of the singleton class and demonstrate their
 * thread safety. This will also demonstrate how reflection can destroy the
 * singleton pattern. We will not call threads on static or lazy singletons as
 * they are thread unsafe.
 * 
 * @author vmohanchalla
 *
 */
public class DemoSingletons {

	public void staticSingletonDemo() {
		// Calling StaticBlockSingleton first time
		StaticBlockSingleton sbs1 = StaticBlockSingleton.getInstance();
		for (String color : sbs1.getColors()) {
			System.out.println("The color is : " + color);
		}

		// Trying to get another instance (we get the same instance)
		StaticBlockSingleton sbs2 = StaticBlockSingleton.getInstance();
		sbs2.isColorPresent("brown");

		// trying to fetch yet another instance (we get the same we created the
		// first time)
		StaticBlockSingleton sbs3 = StaticBlockSingleton.getInstance();
		sbs3.isColorPresent("teal");

		// Now checking if the instances of sbs1, sbs2 and sbs3 are same
		if (sbs1 == sbs2 && sbs1 == sbs3 && sbs2 == sbs3) {
			System.out.println("sbs1, sbs2 and sbs3 are same");

		} else {
			System.out.println("We failed");
		}
		
		//If you want to try threads 
		//testingWithThreads("threadUnsafe", 3);
	}

	public void lazySingletonDemo() {
		SingletonLazy lazy1 = SingletonLazy.getInstance();
		List<String> colors = Arrays.asList("red", "blue", "green", "megenta",
				"teal");
		lazy1.setColors(colors);
		for (String color : lazy1.getColors()) {
			System.out.println("The color is : " + color);
		}

		SingletonLazy lazy2 = SingletonLazy.getInstance();
		if (lazy2.getColors().equals(lazy1.getColors())) {
			System.out
					.println("lazy1 colors instance and lazy2 colors are same");
		}
		if (lazy1 == lazy2) {
			System.out
					.println("The two Objects lazy1 and lazy2 refer to one single instance");
		}
		//If you want to try threads 
		//testingWithThreads("threadUnsafe", 3);

	}

	public void synchronizedSingletonDemo() {
		
		//  testing with 4 threads
		testingWithThreads("SynchronizedSingleton", 4);

	}

	public void performanceThreadSafeSingletonDemo() {

		//  testing with 5 threads
		
		testingWithThreads("BetterThreadSafeSingleton",5);
	}

	public void threadSafeNoSynchronizationSingletonDemo() {
		// testing with 3 threads
		
		testingWithThreads("BillPughSingleton",3);
	}

	private void testingWithThreads(String classToTest, int noOfThreads) {
		switch (classToTest) {
		case "SynchronizedSingleton":
			ExecutorService executor =  Executors.newFixedThreadPool(noOfThreads);
			for (int i = 0; i < 10; i++) {
				Runnable worker = new OverheadSingletonThreads("overheadSingleton"+i);
				executor.execute(worker);
			}
			executor.shutdown();
			try {
				executor.awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				
			}
			System.out.println("Finished Executing threads for SynchronizedSingleton");
			break;
		
		case "BetterThreadSafeSingleton":
			//Implement similar logic as SynchronizedSingleton
			break;
			
		case "BillPughSingleton":
			//Checking is Bill Pughs strategy is in fact thread safe...
			ExecutorService executorForBill =  Executors.newFixedThreadPool(noOfThreads);
			for (int i = 0; i < 10; i++) {
				Runnable billsWorker = new BillPughSingletonThreads("BillPughSingleton"+i);
				executorForBill.execute(billsWorker);
			}
			executorForBill.shutdown();
			try {
				executorForBill.awaitTermination(60, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				
			}
			System.out.println("Finished Executing threads for BillPughSingleton");
			break;

		default:
			System.out.println("Warning : thread unsafe code ");
			//call a runnable at your own peril...
			break;
		}

	}




}
