/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.factoryPattern;

public class ShapeFactory {

    public Shape getShape(String style) {
        if (style.equals("Square")) {
            return new Square();
        } else {
            return new Triangle();
        }
    }
}
