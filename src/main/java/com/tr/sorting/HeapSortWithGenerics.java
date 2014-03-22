package com.tr.sorting;

public class HeapSortWithGenerics<T extends Comparable> {
    public void sort(T[] elements) {
        if (elements == null || elements.length <= 1) {
            return;
        }

        buildHeap(elements);
        for (int count = elements.length -1; count > 0; count--) {
            T temp = elements[0];
            elements[0] = elements[count];
            elements[count] = temp;

            maxHeapify(0, elements, count - 1);
        }
    }

    void buildHeap(T[] elements) {
        for (int count = (elements.length/2) -1; count>=0; count--) {
            maxHeapify(count, elements, elements.length -1);
        }
    }

    void maxHeapify(int count, T[] elements, int heapSize) {
        int largestPosition = count;

        int leftPosition = getLeft(count);
        if (leftPosition <= heapSize) {
            if (elements[leftPosition].compareTo(elements[largestPosition]) > 0 ) {
                largestPosition = leftPosition;
            }
        }

        int rightPosition = getRight(count);
        if (rightPosition <= heapSize) {
            if (elements[rightPosition].compareTo(elements[largestPosition]) > 0) {
                largestPosition = rightPosition;
            }
        }

        if (largestPosition != count) {
            T temp = elements[count];
            elements[count] = elements[largestPosition];
            elements[largestPosition] = temp;

            maxHeapify(largestPosition, elements, heapSize);
        }
    }

    private int getLeft (int count) {
        return (count * 2) + 1;
    }

    private int getRight (int count) {
        return (count * 2) + 2;
    }
}
