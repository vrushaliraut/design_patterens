## Overall structure 

SOLID Design principles 
CQRS 
# Creational 
    - Builder
    - Factories 
        - Abstract Factory 
        - Factory Method 
    - Prototype 
    - Singleton 

* Often used in a place of direct instantiation with constructors 
* Help to make creation process more adaptable and dynamic 
* Provide flexibility about which object are created,how it is created and how are they initialized.

| Name       | Purpose                   |
|------------|--------------------------------------|
| Builder    |* Alternative way to construct complex object and should be used only when we want to build different types of immutable objects using same object building process. |
| Prototype  |* Used in scenarios where apps needs to create a large number of instances of a class, which have almost same state or differ very little |
| Factory    |* Suitable when complex object creation steps are involved |
| Abstract Factory| * Used whenever need another level of abstarction over a group of factories created using patteren 
| Singleton | Enables to have only one instance of class per JVM| 

# Structural
    - Adapter - mobile card to cardreader and then connect to laptop 
    - Bridge - prefer composition over inheritance. Shape - circle,square :color - blue,red
    - Composite - Computer/network monitoring applications, Menu items in GUI screens
    - Decorator -  
    - Facade   - 
    - Flyweight - When we need a large number of similar objects that are unique in terms of only a few parameters.
                  reuse image from cache
    - Proxy - suspecious requests block by proxy.

* Show us how to glue different pieces of a system together in a flexible and extensible fashion. 
* help us guarantee that when one of the parts changes, the entire application structure does not need to change.

| Name       | Purpose                   |
|------------|--------------------------------------|
|1. Adapter  |- An adapter converts interface of class into another interface of clients expect. It lets class work together that coulden't otherwise because of incompatible interface |
|2. Bridge   |- Used to decouple a class into 2 parts - abstraction and it's implementation. so that both can evolve in future without affecting each other. It increases the loose coupling.| 
|3. Composite|- Help to compose object into tree structures to represent whole-part hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.|
|4. Decorator|- Used to add additional feature or behaviours to a perticular instance of a class, while not modifying other instances of a class| 
|5. Facade   |- Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use| 
|6. Flyweight|- Enables use of sharing objects to support large numbers of fine grade objects efficiently. A shared object that can be used in multiple context simultaneously. | 
|7. Proxy    |- Proxy object provide a surrogate or a placeholder for another object to control aceess to it. Proxy is heavily used to implement lazy loading related usecases where we do not want to create full object until it is actually needed.| 

# Behavioural
    - Chain of responsibility (COR) : service request to call center. This request can be handled at front desk level, supervisor level or any higher level
    - Command : build a remote control for home automation system which shall control different lights/electrical units of the home. 
    - Interpreter 
    - Iterator  : ListIterator
    - Mediator
    - Memento
    - Null Object
    - Observer - publish/subsriber patteren
    - State 
    - Strategy
    - Template Method
    - Visitor

* Behavioral patterns abstract an action we want to take on the object or class that takes the action.
* By changing the object or class, we can change the algorithm used, the objects affected, or the behavior. 
* while still retaining the same basic interface for client classes.

| Name         | Purpose                              |
|--------------|--------------------------------------|
|1. COR        |* This design pattern gives more than one object an opportunity to handle a request by linking receiving objects together in form of a chain.|
|2. Command    |* useful to abstract the business logic into discrete actions which we call commands. These command objects help in loose coupling between two classes where one class (invoker) shall call a method on other class (receiver) to perform a business operation.                                     |
|3. Interpreter|* specifies how to evaluate sentences in a language, programmatically|
|4. Iterator   |* provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation|
|5. Mediator   |* Defines an object that encapsulate how a set of objects interact. Promotes loose coupling by keeping objects from referring to each other explicitly.                                      |
|6. Memento    |* Used to restore state of an object to a previous state. It is also known as a snapshot pattern.|
|7. Observer   |* Defines a one-to-many dependency between object so that when one object changes state all its dependents notified and updated auto.                                        |
|8. State      |* Allows an object to alter it's behaviour when internal state changes.                                       |
|9. Strategy   |* used where we choose a specific implementation of algorithm or task in run time – out of multiple other implementations for same task.                                      |
|10. Template  |* defines the sequential steps to execute a multi-step algorithm and optionally can provide a default implementation                                       |
|11. Visitor   |* used when we want a hierarchy of objects to modify their behavior but without modifying their source code.                                     |

            
## Topics 
- Sequence Processing (streams/Rx)
- Concurrency
- Dependency Injection

