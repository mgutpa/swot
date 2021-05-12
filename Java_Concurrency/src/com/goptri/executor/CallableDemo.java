package com.goptri.executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CallableDemo {

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			service = Executors.newSingleThreadExecutor();
			Future<Integer> future = service.submit(()->{
			int sum=0;
			for (int i = 0; i < 100000; i++) {
				sum=sum+i;
				Thread.sleep(100);
			}
			return sum;
		});
			System.out.println("Cancelling the task : "+ future.cancel(true));
			System.out.println("Is task cancelled : " + future.isCancelled());
			//Integer result = future.get();
			Integer result = future.get(10, TimeUnit.SECONDS);
			System.out.println("Callable Result : " + result );
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			e.printStackTrace();
		} finally {
			if(service!=null) {
				service.shutdown();
			}
	}

	}

}
