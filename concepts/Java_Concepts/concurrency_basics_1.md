## java Concurrency Basics :-

* Concurrency Evolution
* What is Thread safety?
* Object level locking and class level locking
* Compare and swap[CAS] Algorithm
* wait(), notify(), and notifyAll() methods 

### Evolution :- 
* As per JDK 1.x release, there were only few classes present in this initial release.
  To be very specific, there classes/interfaces were:
  
 -java.lang.Thread 
 -java.lang.ThreadGroup 
 -java.lang.Runnable 
 -java.lang.Process 
 -java.lang.ThreadDeath 
 -and some exception classes 
 -e.g
 - 
 -java.lang.IllegalMonitorStateException 
 -java.lang.IllegalStateException 
 -java.lang.IllegalThreadStateException. 
 -It also had few synchronized collections e.g. java.util.Hashtable.
 
* JDK 1.5 :- 
- it had included multiple concurrency utilities.
- Executor, semaphore, mutex, barrier, latches, concurrent collections and blocking queues.
- The biggest change in java multi-threading applications cloud happened in this release.

* JDK 1.7 :- 
- Support for ForkJoinPool. which implemented work-stealing technique to maximize the throughput.

* JDK 1.8 :-
- known for Lambda changes, but it also had few concurrency changes as well. Two new interfaces and 
  four new classes were added in java.util.concurrent package e.g. CompletableFuture and CompletionException.

### What is Thread safety?
- A class is thread-safe if it behaves correctly when accessed from multiple threads,
  regardless of the scheduling or interleaving of the execution of those threads by the runtime environment,
  and with no additional synchronization or other coordination on the part of the calling code.
  
- java servlets which have no fields and references, no fields from other classes etc. They are stateless.

### Object level locking and class level locking

- a synchronized block of code can only be executed by one thread at a time.
-  java supports multiple threads to be executed concurrently. 
   This may cause two or more threads to access the same fields or objects at same time.
   
- Synchronization is the process which keeps all concurrent threads in execution to be in sync. 
  Synchronization avoids memory consistence errors caused due to inconsistent view of shared memory.
 
- When a method is declared as synchronized; 
   * the thread holds the monitor or lock object for that method’s object.
   * If another thread is executing the synchronized method, your thread is blocked until that thread releases the monitor.
 
- we can use synchronized keyword in the `class on defined methods or blocks`.
  - `can not be used` with variables or attributes in class definition.

#### Object level lock in Java :- 
- Object level lock is mechanism- when we want to synchronize a non-static method or non-static code block 
  such that only one thread will be able to execute the code block on given instance of the class.
  This should always be done to make instance level data thread safe.
  
- public class DemoClass
  {
    public synchronized void demoMethod(){}
  }
// or 
- public class DemoClass
  {
     public void demoMethod(){
         synchronized (this)
         {
              //other thread safe code
         }
     }
  }

#### Class level lock in Java :-

- Class level lock prevents multiple threads to enter in synchronized block in any of all available instances of the class on runtime.
  This means if in runtime there are 100 instances of DemoClass, then only one thread will be able to execute demoMethod()
  in any one of instance at a time, and all other instances will be locked for other threads.

- Class level locking should always be done to make static data thread safe. 
  As we know that static keyword associate data of methods to class level, so use locking at static fields or methods to make it on class level.

- public class DemoClass
  {
        //Method is static
        public synchronized static void demoMethod(){
        }
  }

- public class DemoClass
  {
        public void demoMethod()
        {
            //Acquire lock on .class reference
            synchronized (DemoClass.class)
            {
                //other thread safe code
            }
        }
  }

#### Object level lock vs class level lock

-  Synchronization in Java guarantees that no two threads can execute a synchronized method,
   which requires same lock, simultaneously or concurrently.

- synchronized keyword can be used only with methods and code blocks. These methods or blocks can be static or non-static both.

- When ever a thread enters into Java synchronized method or block it acquires a lock and whenever it leaves synchronized method 
  or block it releases the lock. Lock is released even if thread leaves synchronized method after completion or
  due to any Error or Exception.
  
- java synchronized keyword is re-entrant in nature it means if a synchronized method calls another synchronized method
  which requires same lock then current thread which is holding lock can enter into that method without acquiring lock.
  
- Java synchronization will throw NullPointerException

- Synchronized methods in Java put a performance cost on your application

- It’s possible that both static synchronized and non static synchronized method can run simultaneously or concurrently 
  because they lock on different object.

- Java language specification you can not use synchronized keyword with constructor.
  It is illegal and result in compilation error.
  
- Do not synchronize on non final field on synchronized block in Java. because reference of non final field may change 
  any time and then different thread might synchronizing on different objects i.e. no synchronization at all.
  
- Do not use String literals because they might be referenced else where in the application and can cause deadlock.
  String objects created with new keyword can be used safely
  
