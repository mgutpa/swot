package com.future;

public class JoinSwot {
	
	public static void main(String[] args) throws InterruptedException {		
	
	Thread t1 = new Thread(()-> {		
		for (int i = 0; i < 5; i++) {
			System.out.println("T1 Hi "+i);
		}		
	});
	
	t1.start();
	t1.join();
	
	Thread t2 = new Thread(()-> {			
			for (int i = 0; i < 5; i++) {
				System.out.println("T2 Hi "+i);
			}		
	 });
	
	t2.start();	
	t2.join();
	
	System.out.println("Outer Thread says bye t1 and t2");
	}
}
