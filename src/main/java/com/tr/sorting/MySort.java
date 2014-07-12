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

    /**
     * Rearrange the array elements such that all odd numbers are on the left and even on the right.
     */
    public int[] rearrangeElements(int[] array){
        if (array == null || array.length <= 1) {
            return array;
        }

        int start = 0;
        int end = array.length -1;
        while (start < end) {
            if (array[start] %2 !=0) {
                start++;
                continue;
            }

            if (array[end] %2 == 0) {
                end--;
                continue;
            }

            int temp=array[start];
            array[start] = array[end];
            array[end] = temp;
        }
        return array;
    }
}
