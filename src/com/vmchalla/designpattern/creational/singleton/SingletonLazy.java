package com.vmchalla.designpattern.creational.singleton;

import java.util.List;

/**
 * This class demonstrates lazy initialization of a singleton Class
 * The instance is not created is the constructor or static block
 * but in the getInstace method (thats the only difference)
 * Is this Thread Safe : NO!!!!
 * @author vmohanchalla
 *
 */
public class SingletonLazy {
	
	private static SingletonLazy sl;
	private List<String> colors;
	private SingletonLazy(){}
	
	public static SingletonLazy getInstance(){
		if(sl==null){
			sl=new SingletonLazy();
		}
		
		return sl;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}
	
	public void isColorPresent(String color){
		if(colors.contains(color)){
			System.out.println("Color present");
		} else {
			System.out.println("color not present");
		}
	}

}
