/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.factoryPattern;

import org.junit.Test;

public class ShapeFactoryTest {

    @Test
    public void canGetShapeAndDraw() {
        ShapeFactory factory = new ShapeFactory();
        factory.getShape("Square").draw();
        factory.getShape("Triangle").draw();
    }
}
