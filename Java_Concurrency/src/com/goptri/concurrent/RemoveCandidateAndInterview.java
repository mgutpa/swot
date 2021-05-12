package com.goptri.concurrent;

import java.util.concurrent.BlockingQueue;

import com.goptri.pojo.JavaCandidate;

public class RemoveCandidateAndInterview implements Runnable {

	BlockingQueue<JavaCandidate> waitingArea;	
	
	public RemoveCandidateAndInterview(BlockingQueue<JavaCandidate> waitingArea) {
		this.waitingArea = waitingArea;
	}

	@Override
	public void run() {
		while(true) {
		try {
			JavaCandidate waitingCandidate = waitingArea.take();
			System.out.println("Called the Candidate " + waitingCandidate +" from waiting Area");
			Thread.sleep(100);
			System.out.println("Interviewed " + waitingCandidate.getFullName());
			System.out.println("Shared the interview feedback to the " + waitingCandidate.getFullName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	  }	
	}

}
