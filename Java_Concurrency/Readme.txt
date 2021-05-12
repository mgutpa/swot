Executor framework is introduced in Java 5.0
Creates and manages threads for you
Includes features such as Thread pool and scheduling
Recommended to use this to create and execute a seperate thread, even a single thread

Executor is an interface in package java.util.concurrent
An object which executes submitted Runnable tasks using a method --> void execute(Runnable command)

2 Sub interfaces are:
--------------------
1. ExecutorService : Has 2 methods and are 
					 1. void execute(Runnable command)
					 2. Future<?> submit(Runnable task) : returns a Future representing pending completion of the task. Once task is 
					 completed, Future get() call will return NULL
					 3. It is obtained using the Executers factory class
2. ScheduledExecutorService


ExecutorService important methods
---------------------------------
void shutdown() : Initiates orderly shutdown in which all the previously submitted tasks are executed but no new task will be accepted
				  Invocation has no effect if already shut down.
				  
List<Runnable> shutdownNow() : Attempts to stop all the actively executing tasks, halts the processing of waiting tasks and returns a
							   list of the task that were awaiting execution.

boolean awaitTermination(long timeout, TimeUnit unit) throws interuuptedExection : Blocks until all tasks have completed execution,
								after a shutdown request, or timeout occurs, or current thread is interrupted, whichever happens first.
								Returns true if this executor terminated and false if the timeout elasped before termination.

boolean isShutdown() : checks whether the executor has been shutdown or not
boolean isTerminated() : Returns true if all tasks have completed following shut down

<T> Future<T> submit( Callable<T> task ) : takes task which can return a Future representing the pending results of the task.
<T> List<Future<T>> invokeAll(Collection<? extends Callable<T> tasks) : executes all the tasks
<T> T invokeAny(Collection<? extends Callable<T> tasks) : returns the result of any one completed task.
 
							   
ThreadPool
----------
It is a group of pre-instantiated reusable threads that are available to perform a set of arbitary tasks. 
It contains a work queue which holds tasks waiting to get executed.
Threads in pool are constantly running and are checking the work queue for new task
If there is new task available the they execute this Runnable  


Future<V>
---------
A generic interface representing pending task/s to  be completed in sometime in future.

Methods: Read from the note book


   Callable<V>   		vs 		Runnable
------------------------------------------------------
1. has Call method          Has run method
2. return V                 Does not return any value
3. Throws exception         Does not throw any exception


ScheduledExecutorService : useful methods
------------------------
scheduleAtFixedRate         vs         ScheduleAtFixedDelay
-----------------------------------------------------------
Creates and executes a                Creates and executes a Runnable task after the given initial delay
runnable task after the               and subsequently with the given delay between the termination of one
given initial delay, creating         execution and the commencement of the next
a new task every period values
passed


Note: Since these tasks are scheduled  to run infinitely, as long as the ScheduledExecutorService is still alive, they would generate 
an endless series of future objects, hence above both methods do not take Callable as a parameter.


Atomic access:
-------------
Atomic means indivisible. So lets say we have an operation which has 3 tasks then all the 3 tasks should be executed by 1 thread.
Any thread which is trying to access an atomic variable while some atomic operation is in process will have to wait until the atomic
operation is completed on the atomic variable.

Atomic operation is a single unit of execution without any interference by another Thread.
Atomic vs Synchronized


Synchronized block     		Synchronized Method
-----------------------------------------------
We can have multiple 
locks within 1 method
and also other lines of
code can be accessed by
other threads concurrently.

Concurrent collection : Helps programmer not to take efforts in creating her own custom collections which contains Synchronized methods
						Main purpose is to solve memory consistency errors
						A memory consistency error occurs when 2 threads have inconsistent views of what should be the same data.
						At any given instance, all threads should have the same consistency view of the structure of the collection.

Volatile keyword is used to solve the visibility problem. --> use volatile keyword to fix the visibility problem

Because of CPU has multiple core or because we can never be sure about the JVM scheduling our threads so it quite possible that the instructions of these two
threads can interleaved. So the read operation of Thread 1 can be followed by Read operation of Thread2 --> use synchronized and Atomic for compound operation

List of concurrent collections and their interfaces : 1.5
---------------------------------------------------
Class							Interface
=================				=============
ConcurrentHashMap				ConcurrentMap
ConcurrentLinkedQueue			Queue
ConcurrentLinkedDeque			Deque
ConcurrentSkipListMap			ConcurrentMap, SortedMap
ConcurrentSkipListSet			SortedSet
CopyOnWriteArrayList			List
CopyOnWriteArraySet				Set
LinkedBlockingQueue				BlockingQueue
LinkedBlockingDeque				BlockingDeque

ConcurrentHashMap : A map which provides thread safety and atomicity

Blocking Queue : It is thread safe. Both put and take waits endlessly based on
===============
put(E e)							Vs         offer(E e, long timeout, TimeUnit unit) throws InterruptedException
---------------								   -------------------------------------------------------------------
Inserts the specified						   Adds item to the queue waiting the specified time, returning false if time
element into this queue,					   elapses before space is available.
awaiting if necessary space
to become available.



take()								Vs         poll(long timeout, TimeUnit unit) throws InterruptedException
---------------								   -------------------------------------------------------------
Retrieves and removes the head					Retrieves and removes an item from queue, waiting the specified time, returning
of this, waiting if necessary 					null if the time elapses before the item is available.
until an element becomes
available.


CopyOnWriteArrayList: They copy all of their elements to a new underlying structure anytime an element is added, modified, or removed from the collection.
					  By a modified element, we mean that the reference in the collection is changed. Modifying the actual contents
					  of the collection will not cause a new structure to be allocated.
					  
public boolean add(E e) {
final ReentrantLock lock = this.lock;
	lock.lock();
	try{
		Object[] elements = getArray();
		int len = elements.length;
		Object[] newElements = Arrays.copyof(elements, len+1);
		newElements[len]=e;
		setArray(newElements);
		return true;
		}finally {
		lock.unlock();
		}
	}
	

Collections.sunchronizedList				vs		CopyOnWriteArrayList
1. Throw ConcurrentModificationException
   during element addition while iteration.

2. synchronized iterator code does not 
   prevent ConcurrentModificationException
   
 
Spring framework is non-invasive --< does not force programmer  to implement or extends 
Beanfactory : It is actual container which instantiates, configure and manages a no of beans

Create Maven project :
1. Add Spring context jar and doc type
2. classPathResource, FileSystemResource




Throwable ( It is a class )
    |
-------------------------------------
	|								|
Exception						Error


Exception is caused by programer and in most case it is recoverable.

try{
	 Read data from a file at given location 
 } catch ( if FileNotFoundException ) { 
 	 Use local file and continue rest
 }	

While on the other hand, ERROR are mostly caused due to lack of system resouces

1. OutOfMemmoryError
2. 