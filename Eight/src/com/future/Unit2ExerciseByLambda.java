package com.future;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit2ExerciseByLambda {

	public static void main(String[] args) {

		List<Person> pList = Arrays.asList(
					new Person("Mantu", "Gupta"),
					new Person("Rohit", "Singh"),
					new Person("Punit", "Rajgarria")				
				);
		
		Collections.sort(pList, (p1,p2)-> p1.getLastName().compareTo(p2.getLastName()));		
		pList.forEach((p)->System.out.println(p));
		printWithCondition(pList, (p)->p.getFirstName().startsWith("M"));		
	}
	
	
	public static void printWithCondition(List<Person> pList, Predicate<Person> condition) {
		pList.forEach((p)-> {
			if(condition.test(p)) {
				System.out.println(p);
			}
		});
		
		
	}

}
