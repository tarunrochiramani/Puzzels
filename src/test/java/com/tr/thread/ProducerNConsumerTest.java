package com.tr.thread;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerNConsumerTest {


    @Test
    public void testConsumerWithNoProduce() {
        Queue<String> stringQueue = new LinkedList<String>();
        Consumer<String> consumer = new Consumer<String>(stringQueue);

        Thread consumerThread1 = new Thread(consumer, "consumer1");
        Thread consumerThread2 = new Thread(consumer, "consumer2");

        consumerThread1.start();
        consumerThread2.start();


        Producer<String> stringProducer = new Producer<String>(stringQueue);
        stringProducer.addEntries("A", "B", "C");
        stringProducer.addEntries("D", "E", "F");
        stringProducer.addEntries("G");
        stringProducer.addEntries("H");
    }
}
