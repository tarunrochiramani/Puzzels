package com.tr.thread;

import org.apache.log4j.Logger;

import java.util.Queue;


public class Consumer<E> implements Runnable {
    private static final Logger logger = Logger.getLogger(Consumer.class.getName());

    private Queue<E> source;

    public Consumer(Queue<E> source) {
        this.source = source;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (source) {
                while (source.isEmpty()) {
                    logger.info("Source is empty. Going to sleep");
                    try {
                        source.wait(5000);
                    } catch (InterruptedException e) {
                        logger.info("Interrupted while waiting for source to be filled.");
                    }
                }

                logger.info("Consumed the first value : " + source.poll());
            }
        }
    }
}
