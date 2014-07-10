/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.singleton;

import org.junit.Test;

public class DoubleLockThreadSafeSingletonTest {

    @Test
    public void canProvideThreadSafety() throws Exception {
        Thread t1 = new Thread(new ThreadHelper(), "Thread1");
        Thread t2 = new Thread(new ThreadHelper(), "Thread2");

        t2.start();
        t1.start();

        t2.join();
        t1.join();
    }
}


class ThreadHelper implements Runnable {
    @Override
    public void run() {
        DoubleLockThreadSafeSingleton.getInstance();
    }
}
