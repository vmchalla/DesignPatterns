package com.vmchalla.main.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.vmchalla.designpattern.creational.singleton.BillPughSingleton;

public class BillPughSingletonThreads implements Runnable{

	private final String threadName;
	public BillPughSingletonThreads(String threadName){
		this.threadName = threadName;
	}
	@Override
	public void run() {
		BillPughSingleton bps = BillPughSingleton.getInstance();
		synchronized (bps) {
			//Set the colors list - this is synchronized 
			if (bps.getColors() == null) {
				List<String> colors = generateRandomColors();
				bps.setColors(colors);
			}
		}
		//Uncomment the below code to see different threads printing
				// the strings in random order.
		/*for(String color : bps.getColors()){
			System.out.println(this.threadName+" : "+color);
		}*/
		List<String> setColors = bps.getColors();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
		}
		if(bps.getColors()==setColors){
			System.out.println("same Instance");
		} else {
			System.out.println("Different Instances Not singleton");
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
