Why Lambdas?
-----------
1. enables functional programing
2. readable and concise code
3. Easier to use APIs and libraries
4. Enable support for parallel processing

Like inline values, can we assign a method or a piece of code as value to a variable? Yes this is possible using lambdas.

aBlockOfCode = public void perform(){
					System.out.println("Hello world!!");				
			   }
			   
1. In above example public does not makes any sense. It makes sense when we define the method inside a class
2. Name of the method is also not needed, since we will use the variable "aBlockOfCode" for further access
3. Return type is not needed

aBlockOfCode = ()--> {
					System.out.println("Hello world!!");				
			   }

Lambda expression can be passed a value to a method like inline string.
If there is 1 line in lambda body then writing return type is not valid.
		doubleNoFunction = (int a ) --> a*2;


Lambda expression can be assign to a functional interface.

public interface HellowWorldGreetings {

	public void perform();
}

Greetings greet = new HellowWorldGreetings(); // greet is instance of class HellowWorldGreetings which implement Greetings

Greeting lambda = () --> System.out.print("Hello world"); // lambda is a lambda expression of type Greetings

call lambda like this lambda.perform();

Lambda expression can be think as a fancy way of creating anonymous class.


Effectively final variables. A variable which is not declared as final but whose value is never changed after initialization is effectively final.
Java 8 compiler can detect that the variable counter remains unchanged and we can use a non-final local variable inside a lambda expression

It is freedom given to developers in which what the system is telling that if you have a local variable and as long as it is not being used in Lambda expression, then
the value of this variable can be changed but if we try to use this variable inside a Lambda expression, then we should consider it as maintaining final variable. No need to physically
put final.

This reference in anonymous class override the this reference and belongs to anonymous class, while in case of Lambda expression this reference belongs to instance outside the
lambda.

Method Reference
----------------
If we are calling some method which takes no arg or only takes all arguments being passed in Lambda expression then in such case
these codes can be replaced by Method reference which is nothing but Class: Method name


ELK
---
Elastic search act as DB component where all the logs will be streamed via logstash on elastic search instance and it is distributed
instance and will have multiple nodes configured under it. Logstash can push streams of data, can push files and will transform the data
to data which can be queried from kubana.

Logstash will transform the data and push it elastic search and using khubana we can query the elastic search index.


docker container ( with apps )
      |
docker engine
      |
   host OS
      |  
  hardware

  
K8s
---
group containers into logical unit called pods. pods can have single or multiple containers

1. Horizontal scaling --> 
2. Self healing  as part of heath check, it kill the containers which do not respond to user's query and launch a new one
3. Load balancing and Service discovery --> K8s gives there containers their own IPs and single DNS name set up
   container and do load balancing
4. storage orchestration --> Automatically mount storage system based on our choice. local system, AWS s3

BDD ( cucumbur )
Behaviour is the selling point between the developer and the customer
So Cucumber is open source which use kirtin language  to write BDD


Java Code To Byte Code
----------------------
The numbers that precede each instruction (or opcode) in the byte code indicates the byte position. For example an instruction 
such a 1: iconst_1 is only one byte in length, as there is no operand, so the following byte code would be at 2. An instruction 
such as 1: bipush 5 would take two bytes, one byte for the opcode bipush and one byte for the operand 5. In this case the following
byte code would be at 3 as the operand occupied the byte at position 2.


Local Variables
The Java Virtual Machine (JVM) has a stack based architecture. When each method is executed including the initial main method a frame 
is created on the stack which has a set of local variables. The array of local variables contains all the variables used during the 
execution of the method, including a reference to this, all method parameters, and other locally defined variables. For class methods
(i.e. static methods) the method parameters start from zero, however, for instance methods the zero slot is reserved for this.

1. Every object has a lock. Only one lock per object
2. Every class has a lock. Only one lock per loaded class file.
3. synchronization can only be applied to a method and block of code not on instance or class level
4. synchronize(this-> object from which the lock needs to be acquired becoz the block of code can use many objects) {...}
5. When a thread holds lock of an object for accessing it's synchronized method, any other thread trying to access other synchronized
   methods should wait for the lock to get released
   
 Why one single lock?
 The really reason. consider the example of ticket booking and cancelling which effects the total no of tickets, so if 2 locks where provided then there is high
 of creating inconsistency data.
 
 Sleep 
 This method is used to tell the current thread to sleep for certain time.
 Accepts time in milliseconds
 can throw InterruptedException
 Can't guarantee that Thread will go into sleep once this method is called and also for the specified time.
 Once sleep is over, it will go to Runnable and running state
 
 All threads are created in Java carry normal priority i.e 5 on the priority scale from 1 to 10. 10 is the highest.
 t.setPriority() should be called before starting the thread i.e. t.start();
 
 
 Yield() : 
 It is static method which tell the current executing thread to give a chance to other thread with equal priority.
 It can at MAX enforce the thread to go to runnable state from running but not to blocked/waiting state.
 Should be defined inside the run method.
 
 ThreadGroup allTHreads = new ThreadGroup("All Threads")
 Thread t1 = new Thread(allTHreads, new Runnable(){}, "t1");
 	while(true){ 
		 State st1 = t1.getState();
		 int active = allTHreads.activeCounts();
		 if(active==0){
		   break;
		 }
  }
  
  Join()
  This tell the current executing thread to resume it's task once the thread which calls the join has finishes execution.
  
  public void run(){
  	if(Thread.currentThread().getName().equals("First thread"){
  		JoinDemo.secondThread.start();
  		JoinDemo.secondThread.join();
  	}  
  }
  
  Notify() and notifyAll()
  I think it depends on how resources are produced and consumed. If 5 work objects are available at once and you have 5 consumer 
  objects, it would make sense to wake up all threads using notifyAll() so each one can process 1 work object.
  
  Use notify() if all your waiting threads are interchangeable (the order they wake up doesn't matter), or if you only ever have one
  waiting thread. A common example is a thread pool used to execute jobs from a queue--when a job is added, one of threads is 
  notified to wake up, execute the next job and go back to sleep.

Use notifyAll() for other cases where the waiting threads may have different purposes and should be able to run concurrently. An example is a maintenance operation on a shared resource, where multiple threads are waiting for the operation to complete before accessing the resource

 
WeakHashMap and SoftHashMap
---------------------------

Elements in a weekHashMap can be reclaimed by Garbage collector if there is no strong reference to the object 
Keys inserted is wrapped inside weekReference.
useful only when the desired lifetime of cache entries is determined by external reference to the key and 
not the value.

Collections.synchronizedMap(aMap)


