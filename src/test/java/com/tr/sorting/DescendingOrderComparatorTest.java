package com.tr.sorting;

import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DescendingOrderComparatorTest {

    @Test
    public void testDescendingOrderSort() {
        List<Integer> elements = Arrays.asList(1, 2, 3, 4, 5);

        Collections.sort(elements, new DescendingOrderComparator());
        for (int count =0; count<elements.size()-1; count++) {
            Assert.assertTrue(elements.get(count) > elements.get(count+1));
        }
    }
}
