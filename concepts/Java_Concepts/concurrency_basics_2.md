## java Concurrency Basics :-

* Concurrency Evolution - done 
* What is Thread safety? - done 
* Object level locking and class level locking - done 
  
* Compare and swap[CAS] Algorithm
* wait(), notify(), and notifyAll() methods 

# 

- In java 5 was Atomic operations supported in classes such as AtomicInteger, AtomicLong etc. 
  These classes help you in minimizing the need of complex (un-necessary) multi-threading code for some basic operations 
  such as increment or decrement a value which is shared among multiple threads.
  
### Optimistic [positive attitude] and Pessimistic [opposite] Locking - 

- Traditional locking mechanisms, e.g. using synchronized keyword in java, 
  is said to be pessimistic technique of locking or multi-threading. 
  It asks you to first guarantee that no other thread will interfere in between certain operation 
  (i.e. lock the object), and then only allow you access to any instance/method.

- It’s much like saying “please close the door first; 
  otherwise some other crook will come in and rearrange your stuff”.

- Though above approach is safe and it does work, but it put 
  a significant penalty on your application in terms of performance.
  
  Reason is simple that waiting threads can not do anything unless they also get a chance and 
  perform the guarded operation.

- There exist one more approach which is more efficient in performance, and it optimistic in nature. 
  In this approach, you proceed with an update, being hopeful that you can complete it without interference. 
  This approach relies on collision detection to determine if there has been interference from other parties during the update, 
  in which case the operation fails and can be retried (or not).

- The optimistic approach is like the old saying, 
  “It is easier to obtain forgiveness than permission”, where “easier” here means “more efficient”.

- Compare and Swap is a good example of such optimistic approach,
    
#### Compare and swap[CAS] Algorithm
- V is a memory location where value “10” is stored.
- 1. hread 1 and 2 want to increment it, they both read the value and increment it to 11.  V = 10, A = 0, B = 0

- 2) Now thread 1 comes first and compare V with it’s last read value: V = 10, A = 10, B = 11
- if (A = V){
     V = B
  }else{
        operation failed 
  }
  return V 
- Clearly the value of V will be overwritten as 11, i.e. operation was successful.

3) Thread 2 comes and try the same operation as thread 1  : V = 11, A = 10, B = 11
- if (A = V){
  V = B
  }else{
  operation failed
  }
  return V
  
4) In this case, V is not equal to A, so value is not replaced and current value of V i.e. 11 is returned.
   Now thread 2, again retry this operation with values:

-V = 11, A = 11, B = 12
- And this time, condition is met and incremented value 12 is returned to thread 2.

- In summary, when multiple threads attempt to update the same variable simultaneously using CAS, 
  one wins and updates the variable’s value, and the rest lose. But the losers are not punished by suspension of thread.


#### wait(), notify(), and notifyAll() methods

- Java 5, introduced some classes like `BlockingQueue` and `Executors` which take away some of the complexity 
  by providing easy to use APIs.
  
- 1. Wait() :- 
    - It tells the calling thread to give up the lock and go to sleep until some other thread enters 
      the same monitor and calls notify()
    - The wait() method releases the lock prior to waiting and reacquires the lock prior to returning 
      from the wait() method. 
      The wait() method is actually tightly integrated with the synchronization lock, using a feature 
      not available directly from the synchronization mechanism.
    - synchronized( lockObject )
      {
         while( ! condition )
         {
            lockObject.wait();
         }
         //take the action here; 
      }

- 2. Notify() :-       
  