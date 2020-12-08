package com.goptri;

import java.util.Date;
import java.util.WeakHashMap;

public class WeakHashMapSwot {

	public static void main(String[] args) {
		
		WeakHashMap<Person, PersonMetadata> weakHashMap = new WeakHashMap<Person, PersonMetadata>();
		Person kevin = new Person();
		weakHashMap.put(kevin, new PersonMetadata());
		
		PersonMetadata kevinMetadata = weakHashMap.get(kevin);
		System.out.println(kevinMetadata);
		
		kevin = null;
		System.gc();
		
		if (weakHashMap.containsValue(kevinMetadata)) {
			System.out.println("Key is still avaible");
		} else {
			System.out.println("Key is gone");
		}
	}
}

final class Person{
	
}

class PersonMetadata{	
	Date date;
	
	public PersonMetadata() {
		date = new Date();
	}

	@Override
	public String toString() {
		return "PersonMetadata [date=" + date + "]";
	}
}
