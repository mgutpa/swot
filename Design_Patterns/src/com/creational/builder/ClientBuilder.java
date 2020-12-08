package com.creational.builder;


/**
 * Creational design pattern because it is used for object creation
 * Used when we have too many arguments to be send to a constructor & it is hard to maintain(wheelNo, Chasis no, engine) .
 * When we don't want to send all parameters in object initialization( for optional we pass NULL )
 */
class Vehicle {
	private String engine;
	private int wheel;
	
	private int airBags;

	public String getEngine() {
		return engine;
	}

	public int getWheel() {
		return wheel;
	}

	public int getAirBags() {
		return airBags;
	}
	
	private Vehicle(BuilderPattern builderPattern) {
		this.engine=builderPattern.engine;
		this.airBags=builderPattern.airBags;
		this.wheel=builderPattern.wheel;
	}
	
	static class BuilderPattern {
		
		private String engine;
		private int wheel;
		
		private int airBags;
		
		public BuilderPattern(String engine, int wheel) {
			this.engine=engine;
			this.wheel=wheel;
		}
		
		public BuilderPattern setAirBags(int airbags) {
			 this.airBags=airbags;
			 return this;
		}
		
		public Vehicle build() {
			return new Vehicle(this);
		}
	}	
	
	@Override
	public String toString() {
		return "Vehicle [engine=" + engine + ", wheel=" + wheel + ", airBags=" + airBags + "]";
	}
}

public class ClientBuilder {
	
public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle.BuilderPattern("1500cc", 4).setAirBags(1).build();
		Vehicle vehicle2 = new Vehicle.BuilderPattern("500cc", 4).build();

		System.out.println("vehicle+ " + vehicle + "vehicle2: " + vehicle2);
		
	}

		
}