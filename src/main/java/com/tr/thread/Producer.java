package com.tr.thread;

import org.apache.log4j.Logger;
import java.util.Queue;

public class Producer<E> {
    private static final Logger logger = Logger.getLogger(Producer.class.getName());

    private Queue<E> destination;

    public Producer(Queue<E> destination) {
        this.destination = destination;
    }

    public void addEntries(E... elements) {
        synchronized (destination) {
            while (!destination.isEmpty()) {
                logger.info("Destination is not empty. Going to sleep/wait");

                try {
                    destination.wait(5000);
                } catch (InterruptedException e) {
                    logger.info("Interrupted while waiting for destination to be empty");
                }
            }

            for (E element : elements) {
                logger.info("Adding " + element + " to the queue.");
                destination.add(element);
            }

            destination.notifyAll();
        }
    }
}
