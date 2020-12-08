package com.future;

public class MethodReference {

	public static void main(String[] args) {

		Thread t = new Thread(()->printMsg());
		t.start();
		
		Thread t1 = new Thread(MethodReference:: printMsg); // This is called Method reference
		t1.start();
		
	}
	
	public static void printMsg() {
		System.out.println("Hello world");
	}

}
