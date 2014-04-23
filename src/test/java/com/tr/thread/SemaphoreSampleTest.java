package com.tr.thread;

import org.junit.Test;

public class SemaphoreSampleTest {

    @Test
    public void canInvokeMethodsInOrder() {
        SemaphoreSample semaphoreSample = new SemaphoreSample();

        Thread threadA = new Thread(new ThreadARunnable(semaphoreSample));
        Thread threadB = new Thread(new ThreadBRunnable(semaphoreSample));
        Thread threadC = new Thread(new ThreadCRunnable(semaphoreSample));

        threadC.start();
        threadB.start();
        threadA.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
