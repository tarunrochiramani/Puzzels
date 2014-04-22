package com.tr.sorting;

import java.util.Comparator;

public class DescendingOrderComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer object1, Integer object2) {
        return object2.compareTo(object1);
    }
}
