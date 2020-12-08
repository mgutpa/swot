package com.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Creational design pattern
 * It is used when we want to avoid creation of multiple object of same type. Instead we can copy the available object to new 
 * object and modify it accordingly
 * 
 * Implementation
 * Object whose multiple creation needs to avoid should provide the cloneable feature i.e. it should implements Cloneable interface
 * we need to override the clone method as per our need
 * 
 * It is used to provide and preserve the necessary settings or variable and respective users can manipulate according to their
 * needs with some preset values 
 * 
 * busy--> occupied ( Sumeet is occupied in some other YTL project these days )
 * busy--> engaged ( I keep myself engaged in reading books )
 * busy--> toiling away ( I have been toiling away since morning, so I will take rest today )
 * busy--> Pre-occupied ( I am sorry, I couldn't hear you. I was pre-occupied with some other thoughts )
 * busy--> Tirelessly ( My father worked tirelessly for today's success.
 * busy--> hectic ( This week was very hectic for me )
 * busy--> bustling ( Quiet!this office is bustling like a fish market )
 * Sorry no meeting today, my hands are already fulled
 * busy like a beaver(beaver is hard working animal)
 * 
 * Good clothes/Places --> That dress is looking classy./You are looking classy in that dress
 * Surprise/takes away our breath --> This brownie is breathtaking/This view is breathtaking
 * Impresses you --> Marvellous: How did you come up with such an marvellous idea
 * Bad behaviour --> Vyom your behaviour was unacceptable/ Your attitude towards life is lousy(poor)
 * 					 First time I baked a cake it was awful/The pasta we ate yesterday was awful (very bad or unpleasant).
 *					 Our flight experience was rotten
 *					 The character in the movie was appalling(very bad) 
 *	Happy --> elated( Simply elated to see your progress
 *  Happy --> Delighted ( I am delighted to meet you )
 *  Sudden happy --> trilled ( His surprise trilled me) 
 *  
 *  Sad -> Gloomy (whether is gloomy today)
 *  Sad ( when feeling sad due to unknown reason) use melancholy --> 
 *  Sad --> Blue/woeful
 * 
 * 
 */
public class PrototypeExample {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Vehicle vehicle = new Vehicle();
		vehicle.insertData();
		
		Vehicle moreThanThreeWheelerVehicle = (Vehicle) vehicle.clone();
		moreThanThreeWheelerVehicle.getVehicleList().remove("Bike");
		
		Vehicle moreThanFourWheelerVehicle = (Vehicle) vehicle.clone();
		moreThanFourWheelerVehicle.getVehicleList().remove("Bike");
		moreThanFourWheelerVehicle.getVehicleList().remove("Rickshaw");
		
		vehicle.getVehicleList().forEach((String veh)-> System.out.println(veh));
		System.out.println("===========================================");
		moreThanThreeWheelerVehicle.getVehicleList().forEach((String veh)-> System.out.println(veh));
		System.out.println("===========================================");
		moreThanFourWheelerVehicle.getVehicleList().forEach((String veh)-> System.out.println(veh));		
	}

}

class Vehicle implements Cloneable {
	
	private List<String> vehicleList;
	
	public Vehicle() {
		this.vehicleList = new ArrayList<String>();
	}

	public Vehicle(List<String> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	public void insertData() {
		vehicleList.add("CAR");
		vehicleList.add("Bike");
		vehicleList.add("Audi");
		vehicleList.add("Rickshaw");
		vehicleList.add("Bus");
	}
	
	public List<String> getVehicleList(){
		return this.vehicleList;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<String>();
		this.vehicleList.forEach((String vehicle)->temp.add(vehicle));		
		return new Vehicle(temp);
	}
	
}