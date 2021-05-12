package com.goptri.concurrent;

import java.util.HashMap;
import java.util.Map;


/*
 * Exception in thread "main" java.util.ConcurrentModificationException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1429)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at com.goptri.concurrent.NonConcurrentDemo.main(NonConcurrentDemo.java:18)
 */
public class NonConcurrentDemo {

	public static void main(String[] args) {

		Map<String,Long> map = new HashMap<String, Long>();
		map.put("Karan", 8747575756L);
		map.put("Ram", 93458858457L);
		map.put("Mohan", 7636575756L);
		map.put("Prajof", 874793856L);
		map.putIfAbsent("Karan", 874793456L);
		map.putIfAbsent("Ram", 8747346756L);
		
		for (String friend : map.keySet()) {
			map.remove(friend);			
		}

	}

}
