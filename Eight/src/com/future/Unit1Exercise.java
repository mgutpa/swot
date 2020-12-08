package com.future;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1Exercise {

	public static void main(String[] args) {
		
		List<Person> personList = Arrays.asList(
				new Person("a", "x"),
				new Person("b", "y"),
				new Person("c", "z")
				);
		
		Collections.sort(personList, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		
		printAll(personList);
		printConditionally(personList, new Condition() {			
			@Override
			public boolean test(Person person) {
				return person.getLastName().startsWith("z");				
			}
		});
		
		Collections.sort(personList,( o1,  o2) ->o1.getLastName().compareTo(o2.getLastName()));
	}

	private static void printConditionally(List<Person> personList, Condition condition) {
		for(Person person : personList) {
			if(condition.test(person)) {
			System.out.println(person);
			}
		}
	}

	private static void printAll(List<Person> personList) {
		for(Person person : personList) {
			System.out.println(person);
		}		
	}
}

interface Condition {
	boolean test(Person person);
}
