package com.goptri.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadedExecutor {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(10);
			for (int i = 0; i < 100; i++) {
				service.execute(() -> System.out.println("Running a task by " + Thread.currentThread().getName()));
			} 
		} finally {
			if (service!=null) {
				service.shutdown();
			try {
				System.out.println("Finished all threads: " + service.awaitTermination(1, TimeUnit.MILLISECONDS));
				if(service.isTerminated()) {
					System.out.println("Finished executing all tasks");
				} else {
					System.out.println("Executing atleast one task");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
}

}
