
package com.creational.singleton;

public class SingletonThreadMethod {
	
	private static SingletonThreadMethod eagar;
	
	private SingletonThreadMethod() {}
	
	public static synchronized SingletonThreadMethod getInstance() {	
		if(eagar==null) {
			synchronized(SingletonThreadMethod.class) {
				if(eagar==null) {
					eagar = new SingletonThreadMethod();
				}
			}
		}
		return eagar;
	}

}
