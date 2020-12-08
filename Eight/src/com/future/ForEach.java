package com.future;

import java.util.Arrays;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {

		List<Person> personList = Arrays.asList(
				new Person("a", "x"),
				new Person("b", "y"),
				new Person("c", "z")
				);
		
		personList.forEach(p-> System.out.println(p));
		personList.forEach(System.out::println); // We are telling java runtime to execute the lambda expression for each person in 
												 // list, so this can run in multi-threaded way
	}

}
