package com.tr.sorting;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

public class MyMapDescendingValueComparatorTest {

    @Test
    public void testSortByValueOnMap() {
        Map<String, Integer> myMap = new HashMap<>();

        myMap.put("a", 5);
        myMap.put("b", 8);
        myMap.put("c", 2);

        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(new MyMapDescendingValueComparator<String, Integer>());
        sortedSet.addAll(myMap.entrySet());

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : sortedSet) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        Integer temp = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            assertTrue(temp > entry.getValue());
            temp = entry.getValue();
        }
    }
}
