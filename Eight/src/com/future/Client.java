package com.future;

public class Client {

	public static void main(String[] args) {
		printStringLength((s)->{			
			int leng = s.length();
			return leng;
			});
	}
	
	public static void printStringLength(StringLengthInterface stringLen) {
		System.out.println(stringLen.getLength("Hello World"));
	}

}

