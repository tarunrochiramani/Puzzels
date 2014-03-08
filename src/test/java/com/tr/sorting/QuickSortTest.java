package com.tr.sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QuickSortTest {

    @Test
    public void canSortEmptyOrOneElementArray() {
        int[] array = null;
        QuickSort.sort(array);

        array = new int[] {1};
        QuickSort.sort(array);

        assertEquals(1, array[0]);
    }

    @Test
    public void canSortValidArray() {
        int[] array = {3, 7, 1, 10, 5};

        QuickSort.sort(array);

        validateSortedArray(array);
    }

    @Test
    public void canSortValidArrayWithNegativeNumbers() {
        int[] array = {3, 7, 1, 10, 5, -10, -2, 40};

        QuickSort.sort(array);

        validateSortedArray(array);
    }

    @Test
    public void canSortAlreadySortedArray() {
        int[] array = {-1, 0, 1, 2, 3, 4, 5};

        QuickSort.sort(array);

        validateSortedArray(array);

    }

    private void validateSortedArray(int[] array) {
        for (int count =0; count < array.length -1; count ++) {
            assertTrue(array[count] <= array[count+1]);
        }
    }
}
