package com.tr.sorting;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    private static final Logger logger = Logger.getLogger(MergeSort.class);

   public <T extends Comparable> void sort(T[] elements) {
       if (elements == null || elements.length == 0) {
           return;
       }
       sort(elements, 0, elements.length-1);
       printOutArray(elements);
   }

   private <T extends Comparable> void sort(T[] elements, int start, int end) {
       if (start < end) {
           int mid = (start + end) / 2;
           sort(elements, start, mid);
           sort(elements, mid + 1, end);
           mergeResults(elements, start, mid, end);
       }
   }

    private <T extends Comparable> void mergeResults(T[] elements, int start, int mid, int end) {
        List<T> leftList = new ArrayList<>();
        for (int count = start; count <=mid; count ++) {
            leftList.add(elements[count]);
        }

        List<T> rightList = new ArrayList<>();
        for (int count= mid+1; count<=end; count++) {
            rightList.add(elements[count]);
        }

        int leftCount = 0;
        int rightCount = 0;
        for (int count =start; count<=end; count++) {
            if (leftCount < leftList.size() && rightCount < rightList.size()) {
                if (leftList.get(leftCount).compareTo(rightList.get(rightCount)) < 0) {
                    elements[count] = leftList.get(leftCount);
                    leftCount++;
                } else {
                    elements[count] = rightList.get(rightCount);
                    rightCount++;
                }
            } else if (leftCount < leftList.size()) {
                elements[count] = leftList.get(leftCount);
                leftCount++;
            } else if (rightCount < rightList.size()) {
                elements[count] = rightList.get(rightCount);
                rightCount++;
            }
        }
    }

    private <T extends Comparable> void printOutArray(T[] array) {
        if (array == null || array.length == 0) {
            logger.info("Empty Array");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (T arrayElement : array) {
            stringBuilder.append(arrayElement);
            stringBuilder.append(" ");
        }

        logger.info("Array :" + stringBuilder.toString());
    }

}
