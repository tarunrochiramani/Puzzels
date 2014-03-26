/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.factoryPattern;

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println(this.getClass().getName());
    }
}
