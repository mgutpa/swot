
package com.creational.singleton;

public class SingletonEagar {
	
	private static SingletonEagar eagar = new SingletonEagar();
	
	private SingletonEagar() {}
	
	public static SingletonEagar getInstance() {		
		return eagar;
	}

}
