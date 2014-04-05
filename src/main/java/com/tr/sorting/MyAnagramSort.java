package com.tr.sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MyAnagramSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        Integer o1BitVector1 = bitVector(o1);
        Integer o1BitVector2 = bitVector(o2);

        return o1BitVector1.compareTo(o1BitVector2);

    }

    private Integer bitVector(String o1) {
        int result = 0;
        for (char c : o1.toCharArray()) {
            result |= (1 << (c - 'a'));
        }
        return result;
    }
//    private String sort(String input) {
//        char[] chars = input.toCharArray();
//        Arrays.sort(chars);
//        return new String(chars);
//    }
//
//    @Override
//    public int compare (String object1, String object2) {
//        String sortedObject1 = sort(object1);
//        String sortedObject2 = sort(object2);
//
//        System.out.println("Sorted Object1: " + sortedObject1);
//
//        return sortedObject1.compareTo(sortedObject2);
//    }



}
