package com.goptri.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.goptri.pojo.JavaCandidate;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		
		BlockingQueue<JavaCandidate> waitingArea = new LinkedBlockingQueue<>(10);
		
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(new ShortListJavaCandidate(waitingArea));
		service.execute(new RemoveCandidateAndInterview(waitingArea));
		service.execute(new RemoveCandidateAndInterview(waitingArea));
	}

}
