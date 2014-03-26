/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design.singleton;

import org.junit.Test;

public class SingleObjectTest {

    @Test
    public void testSingleTon() {
        SingleObject object = SingleObject.getMyObject();
        object.print();

        object = SingleObject.getMyObject();
        object.print();
    }
}
