package com.goptri;

import java.lang.ref.WeakReference;

public class WeakReferenceUages {
	
	public static void main(String[] args) {
		Person1 person = new Person1();
		WeakReference<Person1> weakReference = new WeakReference<Person1>(person);
		
		Person1 p1 = weakReference.get();
		
		if(p1==person) {
			System.out.println(person);
			System.out.println("We are equal " + p1);
		}
		
		person = null;
		p1= null;
		
		//System.gc();
		
		
		Person1 p2 = weakReference.get();
		
		if(p2==null) {
			System.out.println("p2 is null " );
		} else {
			System.out.println("p2 is NOT null " + p2);
		}
		
	}

}

class Person1{
	
}
