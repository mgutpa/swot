
package com.creational.singleton;

public class SingletonThreadBlock {
	
	private static SingletonThreadBlock eagar;
	
	private SingletonThreadBlock() {}
	
	public static synchronized SingletonThreadBlock getInstance() {	
		if(eagar==null) {
			eagar = new SingletonThreadBlock();
		}
		return eagar;
	}

}
