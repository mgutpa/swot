package com.goptri.concurrent;

import java.util.concurrent.BlockingQueue;

import com.goptri.pojo.JavaCandidate;

public class ShortListJavaCandidate implements Runnable {

	BlockingQueue<JavaCandidate> waitingArea;	
	
	public ShortListJavaCandidate(BlockingQueue<JavaCandidate> waitingArea) {
		this.waitingArea = waitingArea;
	}

	@Override
	public void run() {
		while(true) {
			int num=1;
			try {
				JavaCandidate shortListedCandidate = new JavaCandidate("Candidate No-"+num, 3+(float)(Math.random()*20), 3+(float)(Math.random()*40), new String[] {"java8","Struts2"});
				Thread.sleep(100);
				waitingArea.put(shortListedCandidate);
				System.out.println("ShortListed Candidate "+shortListedCandidate);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
