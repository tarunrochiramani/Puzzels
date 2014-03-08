package com.tr.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InsertionSortTest {

    @Test
    public void testEmptyArray() {
        InsertionSort.sort(null);
        InsertionSort.sort(new int[]{});
    }

    @Test
    public void testSingleElementArray() {
        int[] array = {1};

        InsertionSort.sort(array);

        assertEquals(1, array.length);
        assertEquals(1, array[0]);
    }

    @Test
    public void testSorting() {
        int[] array = {2, 5, 8, 1};

        InsertionSort.sort(array);

        validatedSortedArray(array);
    }

    @Test
    public void testSortedArray() {
        int[] array = {1, 2, 4, 7, 8, 11, 16};

        InsertionSort.sort(array);

        validatedSortedArray(array);
    }

    @Test
    public void testNegativeNumbersInArray() {
        int[] array = {9 ,6, -10, 6, 34, 0};

        InsertionSort.sort(array);

        validatedSortedArray(array);

    }

    private void validatedSortedArray(int[] array) {
        for (int count =0; count < array.length -1; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }
}
