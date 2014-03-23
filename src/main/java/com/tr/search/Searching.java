package com.tr.search;

public class Searching {

    public static <T extends Comparable> int binarySearch(T[] elements, T searchElement) {
        return binarySearch(elements, searchElement, 0, elements.length -1);
    }

    private static <T extends Comparable> int binarySearch(T[] elements, T searchElement, int start, int end) {
        if (elements == null || elements.length == 0) {
            return -1;
        }

        while (start <= end) {
            int mid = (start + end) /2;
            if (elements[mid].compareTo(searchElement) == 0) {
                return mid;
            }

            if (searchElement.compareTo(elements[mid]) < 0) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return -(start + 1);
    }


    public static <T extends Comparable> int rotatedInputSearch(T[] elements, T searchElement) {
        return rotatedInputSearch(elements, searchElement, 0, elements.length-1);
    }

    private static <T extends Comparable> int rotatedInputSearch(T[] elements, T searchElement, int start, int end) {
        if (elements == null || elements.length == 0) {
            return -1;
        }

        while (start <= end) {
            int mid = (start + end) /2;

            if (elements[mid].compareTo(searchElement) == 0) {
                return mid;
            }

            if (elements[start].compareTo(elements[mid]) != 0) {
                if (elements[start].compareTo(searchElement) <= 0 && searchElement.compareTo(elements[mid]) < 0) {
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
