package com.tr.sorting;


// You are given two sorted arrays, A and B, where A has a large enough buffer at the
// end to hold B. Write a method to merge B into A in sorted order
public class SortedArrayMerge {
    public static int[] sortedMerge(int[] arrayA, int[] arrayB) throws Exception {
        if (arrayA == null || arrayB == null) {
            throw new Exception("Bad Input");
        }

        if (arrayA.length <= arrayB.length) {
            throw new Exception("Bad Input");
        }

        int lastA = arrayA.length - arrayB.length - 1;
        int lastB = arrayB.length - 1;

        int insertPoint = arrayA.length - 1;
        while (lastA>=0 && lastB>=0) {
            if (arrayA[lastA] > arrayB[lastB]) {
                arrayA[insertPoint--] = arrayA[lastA--];
            } else {
                arrayA[insertPoint--] = arrayB[lastB--];
            }
        }

        while (lastB >= 0) {
            arrayA[insertPoint--] = arrayB[lastB--];
        }

        return arrayA;
    }
}
