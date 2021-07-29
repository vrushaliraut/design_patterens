* When to use volatile, and when to use Atomic counterparts like AtomicInteger? 
* What are the advantages and use cases of each?


* Volatile :- Flags - you run a while loop with value true and want to update value to false after 10 mintutes in a threadpool. 
  

* Automic Integer :- Counters :-  used to update cache, lot of JDK's use automic integers.


* AutomicReference :- Caches 
    -(building a new cache in background and replacing it automatically)
    - used by some internal classes 
    - Non blocking algorithms. 
    

    
