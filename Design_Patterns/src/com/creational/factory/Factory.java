package com.creational.factory;


/**
 * Creational Design pattern
 * Used when we have multiple sub class of a super class and based on the input we want to return one of the class instance
 * It provides implementation and client code
 * Remove the instantiation of new sub class from the client class
 * 
 */

abstract class Vehicle{
	
	public abstract int getWheel();
	
	public String toString() {
		return "Wheel " + this.getWheel();
	}
}

class Car extends Vehicle {
	@Override
	public int getWheel() {
		return 4;
	}
	
}

class Bike extends Vehicle {
	@Override
	public int getWheel() {
		return 2;
	}
	
}

public class Factory {
	
	public static Vehicle getInstance(String type) {
		
		Vehicle vehicle = null;
		
		if(type.equalsIgnoreCase("Car"))
			vehicle= new Car();
		
		if(type.equalsIgnoreCase("Bike"))
			vehicle= new Bike();
		
		return vehicle;
	}

}
