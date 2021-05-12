package com.goptri.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class NewSingleThreadedScheduleExecutor {

	public static void main(String[] args) {
		ScheduledExecutorService service =null;
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			ScheduledFuture<?> future = service.schedule(()->System.out.println("Scheduling task"), 10, TimeUnit.SECONDS);
			System.out.println("Callable result  : " + future.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			if(service!=null) {
				service.shutdown();
			}
		}
		
		

	}

}
