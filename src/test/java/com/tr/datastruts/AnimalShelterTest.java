package com.tr.datastruts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AnimalShelterTest {

    private AnimalShelter animalShelter;

    @Before
    public void setUp() {
        animalShelter = new AnimalShelter();
    }

    @Test
    public void testDequeueWhenShelterEmpty() {
        assertNull(animalShelter.dequeueAny());
        assertNull(animalShelter.dequeueCat());
        assertNull(animalShelter.dequeueDog());
    }

    @Test
    public void testEnqueue() {
        assertEquals(0, animalShelter.getSize());

        Cat cat = new Cat("cat1");
        Dog dog = new Dog("dog1");

        animalShelter.enqueue(cat);
        animalShelter.enqueue(dog);

        assertEquals(2, animalShelter.getSize());
    }


    @Test
    public void testDequeueAny() {
        animalShelter.enqueue(new Cat("cat1"));
        animalShelter.enqueue(new Dog("dog1"));
        animalShelter.enqueue(new Cat("cat2"));

        Animal animal = animalShelter.dequeueAny();
        assertFalse(animal instanceof Dog);
        assertTrue(animal instanceof Cat);
        assertEquals("cat1", animal.getName());
    }

    @Test
    public void testDequeueAnyWhenOnlyCatOrDogExists() {
        animalShelter.enqueue(new Cat("cat1"));

        assertEquals("cat1", animalShelter.dequeueAny().getName());
        assertEquals(0, animalShelter.getSize());

        animalShelter.enqueue(new Dog("dog1"));

        assertEquals("dog1", animalShelter.dequeueAny().getName());
        assertEquals(0, animalShelter.getSize());
    }

    @Test
    public void testDequeueCat() {
        animalShelter.enqueue(new Dog("dog1"));
        animalShelter.enqueue(new Cat("cat1"));
        animalShelter.enqueue(new Cat("cat2"));

        Animal animal = animalShelter.dequeueCat();
        assertFalse(animal instanceof Dog);
        assertTrue(animal instanceof Cat);
        assertEquals("cat1", animal.getName());
        assertEquals("dog1", animalShelter.dequeueAny().getName());
        assertEquals("cat2", animalShelter.dequeueAny().getName());
        assertEquals(0, animalShelter.getSize());
    }

    @Test
    public void testDequeueDog() {
        animalShelter.enqueue(new Dog("dog1"));
        animalShelter.enqueue(new Cat("cat1"));
        animalShelter.enqueue(new Cat("cat2"));
        animalShelter.enqueue(new Dog("dog2"));


        Animal animal = animalShelter.dequeueDog();
        assertTrue(animal instanceof Dog);
        assertFalse(animal instanceof Cat);
        assertEquals("dog1", animal.getName());
        assertEquals("dog2", animalShelter.dequeueDog().getName());
        assertEquals("cat1", animalShelter.dequeueAny().getName());
        assertEquals("cat2", animalShelter.dequeueAny().getName());
        assertEquals(0, animalShelter.getSize());
    }
}
