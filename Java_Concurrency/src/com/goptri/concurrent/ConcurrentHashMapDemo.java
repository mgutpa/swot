package com.goptri.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
 * Friends Map before removal : {Mohan=7636575756, Prajof=874793856, Karan=8747575756, Ram=93458858457}
 * Friends Map after removal : {}
 */
public class ConcurrentHashMapDemo {

	public static void main(String[] args) {

		Map<String,Long> map = new ConcurrentHashMap<String, Long>();
		map.put("Karan", 8747575756L);
		map.put("Ram", 93458858457L);
		map.put("Mohan", 7636575756L);
		map.put("Prajof", 874793856L);
		map.putIfAbsent("Karan", 874793456L);
		map.putIfAbsent("Ram", 8747346756L);
		
		System.out.println("Friends Map before removal : " + map + "with size as " + map.size());
		
		int num=0;
		for (String friend : map.keySet()) {
			System.out.println(num++);
			map.put("Prajofffff"+num, 874793856L);
			map.put("Rohittttt"+num, 874793856L);
			map.remove(friend);	
		}
		
		System.out.println("Friends Map after removal : " + map);


	}

}
