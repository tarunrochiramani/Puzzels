/*
 * Project Horizon
 * (c) 2013-2014 VMware, Inc. All rights reserved.
 * VMware Confidential.
 */
package com.tr.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MySort {

    public <T> void sortBasedOnPosition(List<T> listToSort, final List<T> listToRefer) {
        class MyComparator implements Comparator<T> {
            @Override
            public int compare(T o1, T o2) {

                Integer pos1 = listToRefer.indexOf(o1);
                Integer pos2 = listToRefer.indexOf(o2);
                return pos1.compareTo(pos2);
            }
        }
        Collections.sort(listToSort, new MyComparator());
    }
}
