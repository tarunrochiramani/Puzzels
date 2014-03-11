package com.tr.datastruts;

import java.util.LinkedList;

//  An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
//  out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
//  at the shelter, or they can select whether they would prefer a dog or a cat (and will
//  receive the oldest animal of that type). They cannot select which specific animal they
//  would like. Create the data structures to maintain this system and implement operations
//  such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
//  use the built-in L inkedL ist data structure.


abstract class Animal {
    private String name;
    private int order;

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

class Cat extends Animal {
    Cat(String name) {

        super(name);
    }
}


public class AnimalShelter {
    private LinkedList<Dog> dogList;
    private LinkedList<Cat> catList;
    private int counter = 0;

    public AnimalShelter() {
        dogList = new LinkedList<Dog>();
        catList = new LinkedList<Cat>();
    }

    public void enqueue(Animal animal) {
        animal.setOrder(counter++);
        if (animal instanceof Dog) {
            dogList.add((Dog)animal);
        } else {
            catList.add((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogList.isEmpty() && catList.isEmpty()) {
            return null;
        }

        if (dogList.isEmpty()) {
            return catList.remove();
        }

        if (catList.isEmpty()) {
            return dogList.remove();
        }

        if (dogList.peek().getOrder() < catList.peek().getOrder()) {
            return dogList.remove();
        }

        return catList.remove();
    }

    public Dog dequeueDog() {
        if (dogList.isEmpty()) {
            return null;
        }
        return dogList.remove();
    }

    public Cat dequeueCat() {
        if (catList.isEmpty()) {
            return null;
        }

        return catList.remove();
    }

    public int getSize() {
       return dogList.size() + catList.size();
    }
}
