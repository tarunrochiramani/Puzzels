package com.tr.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchingTest {

    @Test
    public void canBinarySearch() {
        Integer[] elements = {1,2,3,4,5,6,8};

        int found = Searching.binarySearch(elements, 2);
        assertEquals(1, found);

        found = Searching.binarySearch(elements, 7);
        assertEquals((-1*elements.length), found);

        found = Searching.binarySearch(elements, -1);
        assertEquals(-1, found);
    }

    @Test
    public void canDoRotatedInputSearch() {
        Integer[] elements = {2, 2, 2, 3, 4, 5, 2};

        int found = Searching.rotatedInputSearch(elements, 4);
        assertEquals(4, found);

        found = Searching.rotatedInputSearch(elements, 3);
        assertEquals(3, found);

        found = Searching.rotatedInputSearch(elements, 5);
        assertEquals(5, found);
    }
}
