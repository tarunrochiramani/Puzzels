package com.tr.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MergeSortTest {
    private MergeSort mergeSort = new MergeSort();

    @Test
    public void testInvalidInputs() {
        mergeSort.sort(null);

        Integer[] array = {};
        mergeSort.sort(array);

        String[] strArray = {};
        mergeSort.sort(strArray);
    }

    @Test
    public void testIntInput() {
        Integer[] array = {8, 3, 9, 2, 10, 0, -1};
        Integer[] clonedArray = array.clone();
        assertArrayEquals(array, clonedArray);
        assertTrue(Arrays.equals(array, clonedArray));

        Arrays.sort(clonedArray);
        assertFalse(Arrays.equals(array, clonedArray));

        mergeSort.sort(array);
        assertTrue(Arrays.equals(array, clonedArray));
    }

    @Test
    public void testStrInput() {
        String[] array = {"a", "b", "ab", "d", "ca"};
        String[] clonedArray = array.clone();
        assertArrayEquals(array, clonedArray);
        assertTrue(Arrays.equals(array, clonedArray));

        Arrays.sort(clonedArray);
        assertFalse(Arrays.equals(array, clonedArray));

        mergeSort.sort(array);
        assertTrue(Arrays.equals(array, clonedArray));
    }
}
