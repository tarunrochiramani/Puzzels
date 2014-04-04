package com.tr.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MySortTests {
    private MySort mySort = new MySort();

    @Test
    public void testSortByPosition() {
        List<Integer> listToSort = Arrays.asList(3, 6, 1, 8);
        List<Integer> listToRefer = Arrays.asList(1, 4, 3, 8, 9, 6);

        mySort.sortBasedOnPosition(listToSort, listToRefer);

        for (int count =0; count < listToSort.size()-1; count++) {
            Assert.assertTrue(listToRefer.indexOf(listToSort.get(count)) < listToRefer.indexOf(listToSort.get(count + 1)));
        }
    }
}
