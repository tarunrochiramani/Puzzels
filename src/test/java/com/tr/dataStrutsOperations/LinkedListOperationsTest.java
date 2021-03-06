package com.tr.dataStrutsOperations;

import com.tr.datastruts.LinkedListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class LinkedListOperationsTest {

    private LinkedListOperations linkedListOperations = new LinkedListOperations();

    @Test
    public void testCreateWithNoValues() {
        assertNull(linkedListOperations.createList());
    }

    @Test
    public void testCreateWithValues() {
        int[] values = new int[]{1, 2 ,3 };
        LinkedListNode head = linkedListOperations.createList(values);

        assertNotNull(head);
        LinkedListNode current = head;
        for (int value : values) {
            assertEquals(value, current.getData());
            current = current.getNext();
        }

        assertNull(current);
    }

    @Test
    public void testSplitWithNull() {
        assertNull(linkedListOperations.spiltLinkedList(null, 0));
    }

    @Test
    public void testSplitWithNonExistentHigherValue () {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode splittedListHead = linkedListOperations.spiltLinkedList(head, 4);

        assertNotNull(splittedListHead);
        LinkedListNode current = splittedListHead;
        for (int value : values) {
            assertEquals(value, current.getData());
            current = current.getNext();
        }

        assertNull(current);
    }

    @Test
    public void testSplitWithNonExistentLowerValue () {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode splittedListHead = linkedListOperations.spiltLinkedList(head, 0);

        assertNotNull(splittedListHead);
        LinkedListNode current = splittedListHead;
        for (int value : values) {
            assertEquals(value, current.getData());
            current = current.getNext();
        }

        assertNull(current);
    }

    @Test
    public void testSplitWithValidValue() {
        int[] values = new int[] {1, 2, 4, 3, 4};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode splittedListHead = linkedListOperations.spiltLinkedList(head, 4);

        assertNotNull(splittedListHead);
        LinkedListNode current = splittedListHead;
        while (current != null) {
            if (current.getNext() != null) {
                assertTrue(current.getData() <= current.getNext().getData());
            }

            current = current.getNext();
        }
    }

    @Test
    public void testGetNthNodeToLastForNthOutside() {
        int[] values = new int[] {1, 2};
        LinkedListNode head = linkedListOperations.createList(values);

        Assert.assertNull(linkedListOperations.getNthNodeToLast(head, values.length + 1));
    }

    @Test
    public void testGetNthNodeToLast() {
        assertNull(linkedListOperations.getNthNodeToLast(null, 9));

        int[] values = new int[] {1, 2, 3, 4, 5};
        LinkedListNode head = linkedListOperations.createList(values);

        int nthPositionToFind = 2;
        LinkedListNode current = linkedListOperations.getNthNodeToLast(head, nthPositionToFind);

        assertNotNull(current);
        assertEquals(values[values.length - nthPositionToFind - 1], current.getData());
    }

    @Test
    public void testAddListsWhenOneListIsNull() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode result1 = linkedListOperations.addLists(null, head);
        LinkedListNode result2 = linkedListOperations.addLists(head, null);

        assertNotNull(result1);
        assertNotNull(result2);

        for (int value : values) {
            assertEquals(value, result1.getData());
            assertEquals(value, result2.getData());

            result1 = result1.getNext();
            result2 = result2.getNext();
        }

        assertNull(result1);
        assertNull(result2);
    }

    @Test
    public void testAddLists() {
        int[] values = new int[] {1, 2, 3};
        Integer[] sumInReversed = add(values, null);
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode results = linkedListOperations.addLists(head, head);

        assertNotNull(results);
        for (int count = 0; count < sumInReversed.length; count++) {
            assertEquals(sumInReversed[count].intValue(), results.getData());
            results = results.getNext();
        }
    }

    @Test
    public void testAddListsWithDiffSize() {
        int[] values = new int[] {1, 2, 3};
        int[] value2 = new int[] {9, 7, 6, 9};
        Integer[] sumInReversed = add(values, value2);
        LinkedListNode list1 = linkedListOperations.createList(values);
        LinkedListNode list2 = linkedListOperations.createList(value2);

        LinkedListNode results = linkedListOperations.addLists(list1, list2);

        assertNotNull(results);
        for (int count = 0; count < sumInReversed.length; count++) {
            assertEquals(sumInReversed[count].intValue(), results.getData());
            results = results.getNext();
        }
    }

    @Test
    public void testAddListsWithDiffSizes() {
        int[] values = new int[] {1};
        int[] value2 = new int[] {9, 7, 6, 9};
        Integer[] sumInReversed = add(values, value2);
        LinkedListNode list1 = linkedListOperations.createList(value2);
        LinkedListNode list2 = linkedListOperations.createList(values);

        LinkedListNode results = linkedListOperations.addLists(list1, list2);

        assertNotNull(results);
        for (int count = 0; count < sumInReversed.length; count++) {
            assertEquals(sumInReversed[count].intValue(), results.getData());
            results = results.getNext();
        }
    }

    private Integer[] add(int[] value1, int[] value2) {
        int sum = 0;
        if (value1 == null) {
            sum = intValue(value2) + intValue(value2);
        } else if (value2 == null) {
            sum = intValue(value1) + intValue(value1);
        } else {
            sum = intValue(value1) + intValue(value2);
        }

        List<Integer> retval = new ArrayList<Integer>();
        while (true) {
            if (sum == 0) break;
            retval.add(sum % 10);
            sum = sum / 10;
        }

        return retval.toArray(new Integer[]{});

    }

    private int intValue(int[] values) {
        int result = 0;
        for (int count = 0; count< values.length; count++) {
            result += (Math.pow(10, count) * values[count]);
        }
        return result;
    }

    @Test
    public void testIsCircularWithEmptyList() {
        LinkedListNode head = null;

        boolean circular = linkedListOperations.isCircular(head);
        assertFalse(circular);
    }

    @Test
    public void testIsCircular() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = linkedListOperations.createList(values);
        assertFalse(linkedListOperations.isCircular(head));

        head = makeListCircular(head);

        boolean circular = linkedListOperations.isCircular(head);
        assertTrue(circular);
    }

    @Test
    public void testFindMidOfList() {
        assertNull(linkedListOperations.getMidOfLinkList(null));
    }

    @Test
    public void testFindMidOfCircularList() {
        int[] values = new int[] {1, 2};
        LinkedListNode head = linkedListOperations.createList(values);
        head = makeListCircular(head);

        assertNull(linkedListOperations.getMidOfLinkList(head));
    }

    @Test
    public void testFindMidOfValidOddSizedList() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode mid = linkedListOperations.getMidOfLinkList(head);
        assertEquals(values[(values.length / 2)], mid.getData());
    }

    @Test
    public void testFindMidOfValidEvenSizedList() {
        int[] values = new int[] {1, 2, 3, 4};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode mid = linkedListOperations.getMidOfLinkList(head);
        assertEquals(values[(values.length / 2)], mid.getData());
    }

    @Test
    public void testListPalindromeForSingleValueList() {
        LinkedListNode head = linkedListOperations.createList(1);

        assertTrue(linkedListOperations.isListPalindrome(head));
    }

    @Test
    public void testListPalindromeForEmptyListAndCircular() {
        assertFalse(linkedListOperations.isListPalindrome(null));

        int[] values = new int[] {1, 2, 3, 4};
        LinkedListNode head = linkedListOperations.createList(values);
        head = makeListCircular(head);

        assertFalse(linkedListOperations.isListPalindrome(head));
    }

    @Test
    public void testListPalindromeForEvenSizeList() {
        int[] values = new int[] {1, 2, 2, 1};
        LinkedListNode head = linkedListOperations.createList(values);
        assertTrue(linkedListOperations.isListPalindrome(head));

        values = new int[] {2, 2};
        head = linkedListOperations.createList(values);
        assertTrue(linkedListOperations.isListPalindrome(head));

        values = new int[] {1, 2};
        head = linkedListOperations.createList(values);
        assertFalse(linkedListOperations.isListPalindrome(head));
    }

    @Test
    public void testListPalindromeForOddSizeList() {
        int[] values = new int[] {1, 2, 1};
        LinkedListNode head = linkedListOperations.createList(values);

        assertTrue(linkedListOperations.isListPalindrome(head));

        values = new int[] {1, 2, 2};
        head = linkedListOperations.createList(values);

        assertFalse(linkedListOperations.isListPalindrome(head));
    }

    @Test
    public void testCanSortStackWhenAlreadySorted() {
        assertNull(linkedListOperations.sortStack(null));

        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);
        originalStack.push(4);

        Stack<Integer> returnedStack = linkedListOperations.sortStack(originalStack);

        Assert.assertEquals(4, returnedStack.pop().intValue());
        Assert.assertEquals(2, returnedStack.pop().intValue());
    }

    @Test
    public void testCanSortStackWhenOnlyOneElement() {
        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);

        Stack<Integer> returnedStack = linkedListOperations.sortStack(originalStack);

        Assert.assertEquals(2, returnedStack.pop().intValue());
    }

    @Test
    public void testCanSortStackWhenStackNotSorted() {
        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);
        originalStack.push(1);
        originalStack.push(3);

        Stack<Integer> returnedStack = linkedListOperations.sortStack(originalStack);

        Assert.assertEquals(3, returnedStack.pop().intValue());
        Assert.assertEquals(2, returnedStack.pop().intValue());
        Assert.assertEquals(1, returnedStack.pop().intValue());
    }

    @Test
    public void testRemoveDuplicatesFromLinkedListWhenNull() {
        assertNull(linkedListOperations.removeDuplicatesWithoutAdditionalBuffer(null));
    }

    @Test
    public void testRemoveDuplicatedFromLinkedListWhenOnlyOneElement() {
        int[] values = new int[] {1};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode uniqueList = linkedListOperations.removeDuplicatesWithoutAdditionalBuffer(head);

        assertNotNull(uniqueList);
        validateUnique(uniqueList);
    }


    @Test
    public void testRemoveDuplicatedFromLinkedList() {
        int[] values = new int[] {1, 3, 4, 2, 1, 3, 4, 5};
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode uniqueList = linkedListOperations.removeDuplicatesWithoutAdditionalBuffer(head);

        assertNotNull(uniqueList);
        validateUnique(uniqueList);

        head = linkedListOperations.createList(values);
        uniqueList = linkedListOperations.removeDuplicatesWithBuffer(head);

        assertNotNull(uniqueList);
        validateUnique(uniqueList);
    }

    @Test
    public void testRemoveDuplicatedFromLinkedListWhenNoDuplicates() {
        int[] values = new int[] {1, 2, 4, 5, 6, 9 ,7 ,8 };
        LinkedListNode head = linkedListOperations.createList(values);

        LinkedListNode uniqueList = linkedListOperations.removeDuplicatesWithoutAdditionalBuffer(head);

        assertNotNull(uniqueList);
        validateUnique(uniqueList);

        head = linkedListOperations.createList(values);
        uniqueList = linkedListOperations.removeDuplicatesWithBuffer(head);
        assertNotNull(uniqueList);
        validateUnique(uniqueList);
    }

    private void validateUnique(LinkedListNode head) {
        LinkedListNode current = head;
        while (current != null) {
            int found = 0;

            LinkedListNode checker = head;
            while (checker != null) {
                if (checker.getData() == current.getData()) {
                    found ++;
                }
                checker = checker.getNext();
            }

            assertEquals(1, found);
            current = current.getNext();
        }
    }

    private LinkedListNode makeListCircular(LinkedListNode head) {
        if (head == null) {
            return null;
        }

        LinkedListNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(head);

        return head;
    }
}
