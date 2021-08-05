* When to use volatile, and when to use Atomic counterparts like AtomicInteger? 
* What are the advantages and use cases of each?


* Volatile :- Flags - you run a while loop with value true and want to update value to false after 10 mintutes in a threadpool. 
  

* Automic Integer :- Counters :-  used to update cache, lot of JDK's use automic integers.


* AutomicReference :- Caches 
    -(building a new cache in background and replacing it automatically)
    - used by some internal classes 
    - Non blocking algorithms. 
    

* Concurrency :-
-  ability to run several programs or several parts of a program in parallel.
- Concurrency enable a program to achieve high performance and throughput by utilizing the untapped capabilities
  of underlying operating system and machine hardware. 
  
  e.g. modern computers has several CPU’s or several cores within one CPU, program can utilize all cores for some part of processing;
  thus completing task much before in time in comparison to sequential processing.
  
*  The backbone of java concurrency are threads. A thread is a lightweight process which has its own call stack, 
  but can access shared data of other threads in the same process. 
  A Java application runs by default in one process. Within a Java application you can work with many threads
  to achieve parallel processing or concurrency.   

* What makes java application concurrent?
- java.lang.Thread - this call basis of all concurrency.
- java.lang.Runnable - interface to abstract the thread behaviour out of thread class.

* is java concurrency really that simple?
- Concurrent applications usually have more complex design in comparison to single threaded application.
- Code executed by multiple threads accessing shared data need special attention. 
- Errors arising from incorrect thread synchronization are very hard to detect, reproduce and fix. 
- They usually shows up in higher environments like production, and replicating the error is sometimes not possible in lower environments.

* Apart from complex defects, concurrency requires more resources to run the application. 
 So make sure, you have sufficient resources in your kitty.
  

## java Concurrency Basics :- 

* Concurrency Evolution
* What is Thread safety? 
* Object level locking and class level locking
* Compare and swap[CAS] Algorithm
* wait(), notify(), and notifyAll() methods 

## Difference between
Difference between “implements Runnable” and “extends Thread”
Difference between lock and monitor
Difference between yield() and join()
Difference between sleep() and wait()?

## Executor Framework
Executor framework tutorial
ScheduledThreadPoolExecutor Example
FixedSizeThreadPoolExecutor Example
ThreadPoolExecutor Example
ThreadPoolExecutor + Callable + Future Example
Throttling task submission rate using ThreadPoolExecutor and Semaphore
BlockingQueue Example
UncaughtExceptionHandler Example

## Advance Concurrency
ForkJoinPool Example
CountDownLatch Example
Control concurrent access using semaphore
BinarySemaphore
java.util.concurrent.locks.Lock
java.util.concurrent.ThreadFactory
ThreadLocal Variables
Inter-thread communication

Concurrent Collections
ConcurrentHashMap Example
ConcurrentLinkedDeque Example

## Miscellaneous
Creating and resolving Deadlock