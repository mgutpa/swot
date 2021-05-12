package com.goptri.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewSingleThreadedExecutor {

	public static void main(String[] args) {
		ExecutorService service =null;
		try {
			service = Executors.newSingleThreadExecutor();
			service.execute(() -> System.out.println("Execute my first task"));
			service.execute(() -> {
				for (int i = 2; i < 10; i++) {
					System.out.println("Execute my " + i + " task");
				}
			});
			service.execute(() -> System.out.println("Executes my last task"));
		} finally {
			if(service!=null) {
				service.shutdown();
			}
		}
		
		

	}

}
