package com.tr.sorting;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortedArrayMergeTest {


    @Test (expected = Exception.class)
    public void cannotSortMergeForBadInput() throws Exception {
        SortedArrayMerge.sortedMerge(null, null);
    }

    @Test (expected = Exception.class)
    public void cannotSortMergeForArrayABadInput()  throws Exception {
        SortedArrayMerge.sortedMerge(null, new int[]{});
    }

    @Test (expected = Exception.class)
    public void cannotSortMergeForArrayBBadInput()  throws Exception {
        SortedArrayMerge.sortedMerge(new int[]{}, null);
    }

    @Test (expected = Exception.class)
    public void cannotSortMergeForArraysOfSameSize() throws Exception {
        SortedArrayMerge.sortedMerge(new int[]{}, new int[]{});
    }

    @Test
    public void canSortMergeWhenArrayBElementsAreLargest() throws Exception {
        int[] arrayA = new int[4];
        arrayA[0] = 1;

        int[] arrayB = new int[3];
        arrayB[0] = 2;
        arrayB[1] = 4;
        arrayB[2] = 8;

        SortedArrayMerge.sortedMerge(arrayA, arrayB);
        assertTrue(isArraySorted(arrayA));
    }

    @Test
    public void canSortMergeWhenArrayBElementsAreSmallest() throws Exception {
        int[] arrayA = new int[4];
        arrayA[0] = 10;

        int[] arrayB = new int[3];
        arrayB[0] = 2;
        arrayB[1] = 4;
        arrayB[2] = 8;

        SortedArrayMerge.sortedMerge(arrayA, arrayB);
        assertTrue(isArraySorted(arrayA));
    }

    @Test
    public void canSortMergeWhenArrayBHasSomeLargeElements() throws Exception {
        int[] arrayA = new int[4];
        arrayA[0] = 1;
        arrayA[1] = 3;

        int[] arrayB = new int[2];
        arrayB[0] = 2;
        arrayB[1] = 8;

        SortedArrayMerge.sortedMerge(arrayA, arrayB);
        assertTrue(isArraySorted(arrayA));
    }

    @Test
    public void canSortMergeWhenArrayAHasZero() throws Exception {
        int[] arrayA = new int[4];
        arrayA[0] = 0;
        arrayA[1] = 4;

        int[] arrayB = new int[2];
        arrayB[0] = 6;
        arrayB[1] = 8;

        SortedArrayMerge.sortedMerge(arrayA, arrayB);
        assertTrue(isArraySorted(arrayA));

    }


    private boolean isArraySorted(int[] array) {
        if (array == null) {
            return false;
        }

        for (int count=0; count<array.length-1; count++) {
            if (array[count] > array[count + 1]) {
                return false;
            }
        }

        return true;
    }

}
