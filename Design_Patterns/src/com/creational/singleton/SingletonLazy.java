
package com.creational.singleton;

public class SingletonLazy {
	
	private static SingletonLazy eagar;
	
	private SingletonLazy() {}
	
	public static SingletonLazy getInstance() {	
		if(eagar==null) {
			eagar = new SingletonLazy();
		}
		return eagar;
	}

}
