package com.tr.sorting;

import java.util.logging.Logger;

public class HeapSort {

    private static Logger logger = Logger.getLogger(HeapSort.class.getName());

    public static void maxHeapify(int[] array, int position, int heapSize) {
        if (array == null || position < 0 || heapSize < 0) {
            return;
        }

        int leftPosition = (2 * position) + 1;
        int rightPosition = leftPosition + 1;

        int largestPosition = position;
        if (leftPosition <= heapSize) {
            if (array[leftPosition] > array[position]) {
                largestPosition = leftPosition;
            }
        }

        if (rightPosition <= heapSize) {
            if (array[rightPosition] > array[largestPosition]) {
                largestPosition = rightPosition;
            }
        }

        // changed
        if (largestPosition != position) {
            int temp = array[position];
            array[position] = array[largestPosition];
            array[largestPosition] = temp;
            maxHeapify(array, largestPosition, heapSize);
        }
    }

    public static void buildHeap(int[] array) {
        printOutArray(array);
        if (array == null || array.length == 0) {
            return;
        }

        //build heap
        for (int count = (array.length -1)/2; count >= 0; count--) {
            HeapSort.maxHeapify(array, count, array.length-1);
        }
    }

    public static void sort(int[] array) {
        buildHeap(array);

        for (int heapSize = array.length-1; heapSize > 0; heapSize --) {
            // swap last element in heapsize with first element
            int temp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = temp;

            //build the heap again without the last element we just swapped.
            maxHeapify(array, 0, heapSize-1);
        }

        printOutArray(array);
    }

    private static void printOutArray(int[] array) {
        if (array == null || array.length == 0) {
            logger.info("Empty Array");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int arrayElement : array) {
            stringBuilder.append(arrayElement);
            stringBuilder.append(" ");
        }

        logger.info("Array :" + stringBuilder.toString());
    }
}
