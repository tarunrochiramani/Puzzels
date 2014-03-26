/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.singleton;

public class SingleObject {

    private static SingleObject myObject = null;

    private SingleObject() {}

    public static SingleObject getMyObject() {
        if (myObject == null) {
            myObject = new SingleObject();
            System.out.println("Inside Constructor");
        }
        return myObject;
    }

    public void print() {
        System.out.println("SOmething");
    }


}
