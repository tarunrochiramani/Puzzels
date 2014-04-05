package com.tr.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void canSearchStrings() {
        String[] strings = {"a", "b"};

        int found = Searching.searchWithInterspersedString(strings, "a");
        assertEquals(0, found);

        found = Searching.searchWithInterspersedString(strings, "b");
        assertEquals(1, found);

        found = Searching.searchWithInterspersedString(strings, "c");
        assertEquals(-1, found);
    }

    @Test
    public void canSearchStringsWithSpaces() {
        String[] strings = {"", "", "", "a", "", "", "", "b"};

        int found = Searching.searchWithInterspersedString(strings, "a");
        assertTrue(found > 0);
        assertEquals(3, found);

        found = Searching.searchWithInterspersedString(strings, "b");
        assertTrue(found > 0);
        assertEquals(7, found);

        found = Searching.searchWithInterspersedString(strings, "c");
        assertEquals(-1, found);
     }

    @Test
    public void cannotSearchPairsForInvalidValues() {
        List<String> result = Searching.getPairs(null, 0);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        result = Searching.getPairs(new ArrayList<Integer>(), 0);
        assertNotNull(result);
        assertTrue(result.isEmpty());

        result = Searching.getPairs(Arrays.asList(1, 2, 3), 8);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void canSearchForPairsInUniqueValidValues() {
        List<String> result = Searching.getPairs(Arrays.asList(1, 2, 2, 3), 4);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("1,3"));
        assertTrue(result.contains("2,2"));
    }

    @Test
    public void canSearchForPairsInDuplicateValidValues() {
        List<String> result = Searching.getPairs(Arrays.asList(1, 1, 3), 4);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("1,3"));

        result = Searching.getPairs(Arrays.asList(2, 2, 2), 4);

        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("2,2"));
    }



}
