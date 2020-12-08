package com.goptri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReferenceQueueSwot {
		
	public static void main(String[] args) throws IOException {
		Person2 person = new Person2();
		System.out.println(person);
		ReferenceQueue<Person2> referenceQueue = new ReferenceQueue<>();
		PersonCleanup cleaner = new PersonCleanup();
		System.out.println(cleaner);
		PersonWeakReference personWeakReference = new PersonWeakReference(person, cleaner, referenceQueue);
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(()->{
			try {
				PersonWeakReference wr = (PersonWeakReference) referenceQueue.remove();
				wr.clean();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		});
		
		person = null;
		System.gc();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Press any key to continue");
		br.readLine();
		executorService.shutdown();
		
	}

}


final class Person2{
	
}

class PersonCleanup{

	public void clean() {
		System.out.println("Cleaned");
	}	
	
}

class PersonWeakReference extends WeakReference<Person2> {

	private PersonCleanup cleaner;

	public PersonWeakReference(Person2 person,PersonCleanup personCleanup, ReferenceQueue<? super Person2> q) {
		super(person, q);
		this.cleaner= personCleanup;
	}
	
	public void clean() {
		cleaner.clean();
	}
}
