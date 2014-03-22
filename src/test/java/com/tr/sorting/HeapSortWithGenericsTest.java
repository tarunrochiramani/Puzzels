package com.tr.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeapSortWithGenericsTest {

    @Test
    public void testBuildHeap() {
        HeapSortWithGenerics<Integer> heapSortWithGenerics = new HeapSortWithGenerics<>();
        Integer[] elements = {5, 3, 7, 8, 2};
        heapSortWithGenerics.buildHeap(elements);

        assertArrayEquals(new Integer[]{8, 5, 7, 3, 2}, elements);
    }

    @Test
    public void canSortArrayOfStrings() {
        // Prepare two strings and make sure they are different objects and not meaningfully equal
        String[] stringList = {"a", "ba", "abc", "c" };
        String[] expectedList = stringList.clone();
        assertFalse(expectedList == stringList);
        assertTrue(Arrays.equals(expectedList, stringList));

        // sort one of the list using Arrays.sort
        Arrays.sort(expectedList);
        assertFalse(Arrays.equals(expectedList, stringList));

        // Call implemented sort feature
        HeapSortWithGenerics<String> stringSort = new HeapSortWithGenerics<>();
        stringSort.sort(stringList);

        // make sure both are same now
        assertTrue(Arrays.equals(expectedList, stringList));
    }
}
