/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.singleton;

import org.apache.log4j.Logger;

public class DoubleLockThreadSafeSingleton {

    private static DoubleLockThreadSafeSingleton instance = null;
    private static Logger log = Logger.getLogger(DoubleLockThreadSafeSingleton.class);

    // Private Constructor
    private DoubleLockThreadSafeSingleton() { }

    public static DoubleLockThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleLockThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLockThreadSafeSingleton();
                    log.info("Created instance");
                } else {
                    log.info("Thread Safety Provided..");
                }
            }
        }

        return instance;
    }
}
