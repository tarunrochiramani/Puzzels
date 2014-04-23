package com.tr.sorting;

import java.util.Comparator;
import java.util.Map;

public class MyMapDescendingValueComparator<K, V extends Comparable> implements Comparator<Map.Entry<K,V>> {

    @Override
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
