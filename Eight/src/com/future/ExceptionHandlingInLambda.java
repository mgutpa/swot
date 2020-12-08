package com.future;

import java.util.function.BiConsumer;

public class ExceptionHandlingInLambda {

	public static void main(String[] args) {
		
		BiConsumer<Integer, Integer> math1 = (v,k)->System.out.println(v/k);
		BiConsumer<Integer, Integer> math3 = wrapBiConsumer(math1);
		process(new int[] {1, 3, 4,6}, 2 , math3);
	}
	
	/*
	 * we can write a lambda wrapper for the lambda function
	 */
	private static BiConsumer<Integer, Integer> wrapBiConsumer(BiConsumer<Integer, Integer> math1) {
		return (v,k)-> {
			try {
				math1.accept(v,k);
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			}			
		};		
		
	}

	public static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> maths) {		
		for(int i : someNumbers) {
			maths.accept(i, key);
		}
	}
	
	

}
