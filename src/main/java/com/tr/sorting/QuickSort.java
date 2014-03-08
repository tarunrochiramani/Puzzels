package com.tr.sorting;

public class QuickSort {

    public static void sort(int[] array) {
        if (array == null || array.length <=1) {
            return;
        }

        doSort(array, 0, array.length-1);
    }

    private static void doSort(int[] array, int start, int end) {
        if (start < end) {
            int partition = findPartition(array, start, end);
            if (partition > 0) {
                doSort(array, start, partition - 1);
                doSort(array, partition + 1, end);
            }
        }
    }

    private static int findPartition(int[] array, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int pivot = array[end];
        int minElementRunner = start -1;
        int maxElementRunner = start;
        while (maxElementRunner < end) {
            if (array[maxElementRunner] <= pivot) {
                minElementRunner ++;
                int temp = array[minElementRunner];
                array[minElementRunner] = array[maxElementRunner];
                array[maxElementRunner] = temp;
            }
            maxElementRunner++;
        }

        minElementRunner ++;
        array[end] = array[minElementRunner];
        array[minElementRunner] = pivot;

        return minElementRunner;
    }
}
