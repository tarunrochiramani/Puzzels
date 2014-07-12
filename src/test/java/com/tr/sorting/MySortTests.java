package com.tr.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MySortTests {
    private MySort mySort = new MySort();

    @Test
    public void testSortByPosition() {
        List<Integer> listToSort = Arrays.asList(3, 6, 1, 8);
        List<Integer> listToRefer = Arrays.asList(1, 4, 3, 8, 9, 6);

        mySort.sortBasedOnPosition(listToSort, listToRefer);

        for (int count =0; count < listToSort.size()-1; count++) {
            assertTrue(listToRefer.indexOf(listToSort.get(count)) < listToRefer.indexOf(listToSort.get(count + 1)));
        }
    }

    @Test
    public void testRearrange() {
        int[] array = {1,2,3,4,5,6};
        mySort.rearrangeElements(array);
        assertTrue(verifyResults(array));
    }

    @Test
    public void testRearrangeWithSameTypeOfElements() {
        int[] oddArray = {1,3,5,7};
        mySort.rearrangeElements(oddArray);
        assertTrue(verifyResults(oddArray));

        int[] evenArray = {2,4,6};
        mySort.rearrangeElements(evenArray);
        assertTrue(verifyResults(evenArray));
    }

    private boolean verifyResults(int[] array) {
        boolean evenFound = false;

        for (int element : array) {
            if (element %2 == 0) {
                evenFound = true;
                continue;
            }

            if (evenFound == true && element %2 != 0) {
                return false;
            }
        }
        return true;
    }
}
