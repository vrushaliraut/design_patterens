package Java_Concepts;

/*
If a class inherits a method from its superclass, then there is a chance to override the method provided
that it is not marked final.

The benefit of overriding is: ability to define a behavior that's specific to the subclass type,
which means a subclass can implement a parent class method based on its requirement.

In object-oriented terms, overriding means to override the functionality of an existing method.
* */

class Animal {
    public void move() {
        System.out.println("Animals can move");
    }
}

class Dog extends Animal {
    public void move() {
        System.out.println("Dogs can walk and run");
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.move();
    }
}
