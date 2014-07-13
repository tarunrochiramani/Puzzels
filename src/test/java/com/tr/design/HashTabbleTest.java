/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.design;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashTabbleTest {

    @Test
    public void testHashTable() {
        HashTabble<String, Integer> myTable = new HashTabble<>();
        myTable.put("abc", 1);
        myTable.put("def", 2);
        myTable.put("cab", 3);

        assertEquals(Integer.valueOf(1), myTable.get("abc"));
        assertEquals(Integer.valueOf(2), myTable.get("def"));
        assertEquals(Integer.valueOf(3), myTable.get("cab"));

    }
}
