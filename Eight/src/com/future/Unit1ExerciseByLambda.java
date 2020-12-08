package com.future;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseByLambda {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person("a", "y"),
				new Person("b", "x"),
				new Person("c", "z")
				);		
		
		Collections.sort(personList,( o1,  o2) ->o1.getLastName().compareTo(o2.getLastName()));
		printConditionally(personList,(person)->true);
		printConditionally(personList, (person) -> person.getLastName().startsWith("z"));
		printConditionally(personList, (person) -> person.getFirstName().startsWith("b"));
		
	}

	private static void printConditionally(List<Person> personList, Predicate<Person> condition) {
		for(Person person : personList) {
			if(condition.test(person)) {
			System.out.println(person);
			}
		}
	}	
}
