package com.tr.sorting;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HeapSortTest {

    @Test
    public void testBuildHeapWithNullArraySimplyReturns() {
        HeapSort.maxHeapify(null, 0, 0);
    }

    @Test
    public void testBuildHeap() {
        int[] array = {3, 7, 2, 10, 11, 14};

        HeapSort.buildHeap(array);

        // Checking
        for(int count =0; count<array.length; count++) {
            int left = (count * 2) +1;
            int right = left + 1;

            if (left <= array.length -1) {
                assertTrue(array[count] >= array[left]);
            }

            if (right <= array.length -1) {
                assertTrue(array[count] >= array[right]);
            }
        }
    }

    @Test
    public void testHeapSort() {
        int[] array = {3, 7, 2, 10, 11, 14};

        HeapSort.sort(array);

        for (int count =0; count < array.length -2; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }

    @Test
    public void testHeapSortForEmptyArray() {
        int[] array = {};

        HeapSort.sort(array);

        for (int count =0; count < array.length -2; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }

    @Test
    public void testHeapSortForSingleElement() {
        int[] array = {3};

        HeapSort.sort(array);

        for (int count =0; count < array.length -2; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }


    @Test
    public void testHeapSortForAlreadySortedArray() {
        int[] array = {1, 2, 3};

        HeapSort.sort(array);

        for (int count =0; count < array.length -2; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }

    @Test
    public void testHeapSortWithNegativeNumbers() {
        int[] array = {1, -2, 3};

        HeapSort.sort(array);

        for (int count =0; count < array.length -2; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }
}
