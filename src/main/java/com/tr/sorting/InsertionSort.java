package com.tr.sorting;

public class InsertionSort {

    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int count = 1; count < array.length; count ++) {
            int currentElement = array[count];

            int previousCounter = count -1;
            while (previousCounter >=0 && array[previousCounter] > currentElement) {
                array[previousCounter + 1] = array[previousCounter];
                array[previousCounter] = currentElement;
                previousCounter--;
            }
        }
    }
}
