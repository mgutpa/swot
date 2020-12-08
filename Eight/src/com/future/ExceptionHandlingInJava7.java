package com.future;

import java.util.function.BiConsumer;

public class ExceptionHandlingInJava7 {

	public static void main(String[] args) {
		
		BiConsumers<Integer, Integer> math1 = new BiConsumers<Integer, Integer>() {			
			@Override
			public void accept(int i, int key) {
				 System.out.println(i/key);
				
			}
		};
		BiConsumers<Integer, Integer> math3 = wrapBiConsumer(math1);
		process(new int[] {1, 3, 4,6}, 0 , math3);
	}
	
	private static BiConsumers<Integer, Integer> wrapBiConsumer(BiConsumers<Integer, Integer> math1) {
		BiConsumers<Integer, Integer> math3 = new BiConsumers<Integer, Integer>() {			
			@Override
			public void accept(int i, int key) {
				System.out.println("Inside wrapper start");
				math1.accept(i, key);
				System.out.println("Inside wrapper end");
			}
		};
		return math3;
	}

	public static void process(int[] someNumbers, int key, BiConsumers<Integer, Integer> maths) {		
		for(int i : someNumbers) {
			maths.accept(i, key);
		}
	}
	
	

}
