package com.vmchalla.main.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vmchalla.designpattern.creational.singleton.SynchronizedSingleton;

/**
 * This class creates threads for @SynchronizedSingleton You can also
 * create threads for non-threadsafe singleton implementations. Try that as an exercise ...
 * 
 * @author vmohanchalla
 *
 */
public class OverheadSingletonThreads implements Runnable {

	private String threadName;
	public OverheadSingletonThreads(String threadName){
		this.threadName = threadName;
	}
	@Override
	public void run() {
		//Multiple threads will get same instance
		SynchronizedSingleton synchronizedSingleton = SynchronizedSingleton.getInstance();
		
		//Set the colors list - this is synchronized as well.
		
		synchronized (synchronizedSingleton) {
			if (synchronizedSingleton.getColors() == null) {

				synchronizedSingleton.setColors(generateRandomColors());
			}
		}
		//Uncomment the below code to see different threads printing
		// the strings in random order.
		/*for(String color : synchronizedSingleton.getColors()){
			System.out.println(this.threadName+" : "+color);
		}*/
		List<String> setColors = synchronizedSingleton.getColors();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		if(setColors==synchronizedSingleton.getColors()){
			System.out.println("same Instance");
		} else {
			System.out.println("Different Instances No singleton Anymore");
		}
		
	}
	
	private List<String> generateRandomColors(){
		List<String> colors = new ArrayList<>();
		String charecters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		//Let us do 5 random string (These may not be colors)
		for(int j=0;j<5;j++){
			StringBuilder sb = new StringBuilder();
			for(int i=0; i <5;i++){
				sb.append(charecters.charAt(rnd.nextInt(charecters.length())));
			}
			colors.add(sb.toString());
		}
		return colors;
	}

}
