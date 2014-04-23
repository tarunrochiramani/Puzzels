package com.tr.thread;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;


public class SemaphoreSample {
    private static Logger logger = Logger.getLogger(SemaphoreSample.class);

    private Semaphore semaphore1;
    private Semaphore semaphore2;
    private Semaphore semaphore3;

    public SemaphoreSample() {
        semaphore1 = new Semaphore(1);
        semaphore2 = new Semaphore(1);
        semaphore3 = new Semaphore(1);

        try {
            semaphore1.acquire();
            semaphore2.acquire();
            semaphore3.acquire();
        } catch (InterruptedException e) {
            logger.error(e);
        }
    }

    public void methodA() {
        logger.info("Method A.");

        semaphore1.release();
    }

    public void methodB() {
        try {
            logger.info("Method B.");
            semaphore1.acquire();
            semaphore1.release();

            semaphore2.release();

        } catch (InterruptedException e) {
            logger.error(e);
            return;
        }
    }

    public void methodC() {
        try {
            logger.info("Method C");
            semaphore2.acquire();
            semaphore2.release();

            semaphore3.release();

        } catch (InterruptedException e) {
            logger.error(e);
            return;
        }
    }
}

class ThreadARunnable implements Runnable {
    private SemaphoreSample semaphoreSample;

    ThreadARunnable(SemaphoreSample semaphoreSample) {
        this.semaphoreSample = semaphoreSample;
    }

    public void run() {
        semaphoreSample.methodA();
    }
}

class ThreadBRunnable implements Runnable {
    private SemaphoreSample semaphoreSample;

    ThreadBRunnable(SemaphoreSample semaphoreSample) {
        this.semaphoreSample = semaphoreSample;
    }

    public void run() {
        semaphoreSample.methodB();
    }
}

class ThreadCRunnable implements Runnable {
    private SemaphoreSample semaphoreSample;

    ThreadCRunnable(SemaphoreSample semaphoreSample) {
        this.semaphoreSample = semaphoreSample;
    }

    public void run() {
        semaphoreSample.methodC();
    }
}
