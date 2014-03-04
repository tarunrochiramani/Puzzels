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

public class DataStrutsTest {

    private DataStruts dataStruts = new DataStruts();

    @Test
    public void testCreateWithNoValues() {
        assertNull(dataStruts.createList());
    }

    @Test
    public void testCreateWithValues() {
        int[] values = new int[]{1, 2 ,3 };
        LinkedListNode head = dataStruts.createList(values);

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
        assertNull(dataStruts.spiltLinkedList(null, 0));
    }

    @Test
    public void testSplitWithNonExistentHigherValue () {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode splittedListHead = dataStruts.spiltLinkedList(head, 4);

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
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode splittedListHead = dataStruts.spiltLinkedList(head, 0);

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
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode splittedListHead = dataStruts.spiltLinkedList(head, 4);

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
        LinkedListNode head = dataStruts.createList(values);

        Assert.assertNull(dataStruts.getNthNodeToLast(head, values.length + 1));
    }

    @Test
    public void testGetNthNodeToLast() {
        int[] values = new int[] {1, 2, 3, 4, 5};
        LinkedListNode head = dataStruts.createList(values);

        int nthPositionToFind = 2;
        LinkedListNode current = dataStruts.getNthNodeToLast(head, nthPositionToFind);

        assertNotNull(current);
        assertEquals(values[values.length - nthPositionToFind - 1], current.getData());
    }

    @Test
    public void testAddListsWhenOneListIsNull() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode result1 = dataStruts.addLists(null, head);
        LinkedListNode result2 = dataStruts.addLists(head, null);

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
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode results = dataStruts.addLists(head, head);

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
        LinkedListNode list1 = dataStruts.createList(values);
        LinkedListNode list2 = dataStruts.createList(value2);

        LinkedListNode results = dataStruts.addLists(list1, list2);

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
        LinkedListNode list1 = dataStruts.createList(values);
        LinkedListNode list2 = dataStruts.createList(value2);

        LinkedListNode results = dataStruts.addLists(list1, list2);

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

        boolean circular = dataStruts.isCircular(head);
        assertFalse(circular);
    }

    @Test
    public void testIsCircular() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = dataStruts.createList(values);

        head = makeListCircular(head);

        boolean circular = dataStruts.isCircular(head);
        assertTrue(circular);
    }

    @Test
    public void testFindMidOfList() {
        assertNull(dataStruts.getMidOfLinkList(null));
    }

    @Test
    public void testFindMidOfCircularList() {
        int[] values = new int[] {1, 2};
        LinkedListNode head = dataStruts.createList(values);
        head = makeListCircular(head);

        assertNull(dataStruts.getMidOfLinkList(head));
    }

    @Test
    public void testFindMidOfValidOddSizedList() {
        int[] values = new int[] {1, 2, 3};
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode mid = dataStruts.getMidOfLinkList(head);
        assertEquals(values[(values.length / 2)], mid.getData());
    }

    @Test
    public void testFindMidOfValidEvenSizedList() {
        int[] values = new int[] {1, 2, 3, 4};
        LinkedListNode head = dataStruts.createList(values);

        LinkedListNode mid = dataStruts.getMidOfLinkList(head);
        assertEquals(values[(values.length / 2)], mid.getData());
    }

    @Test
    public void testListPalindromeForSingleValueList() {
        LinkedListNode head = dataStruts.createList(1);

        assertTrue(dataStruts.isListPalindrome(head));
    }

    @Test
    public void testListPalindromeForEmptyList() {
        assertFalse(dataStruts.isListPalindrome(null));
    }

    @Test
    public void testListPalindromeForEvenSizeList() {
        int[] values = new int[] {1, 2, 2, 1};
        LinkedListNode head = dataStruts.createList(values);

        assertTrue(dataStruts.isListPalindrome(head));

        values = new int[] {1, 2, 2, 3};
        head = dataStruts.createList(values);

        assertFalse(dataStruts.isListPalindrome(head));
    }


    @Test
    public void testListPalindromeForOddSizeList() {
        int[] values = new int[] {1, 2, 1};
        LinkedListNode head = dataStruts.createList(values);

        assertTrue(dataStruts.isListPalindrome(head));

        values = new int[] {1, 2, 2};
        head = dataStruts.createList(values);

        assertFalse(dataStruts.isListPalindrome(head));
    }

    @Test
    public void testCanSortStackWhenAlreadySorted() {
        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);
        originalStack.push(4);

        Stack<Integer> returnedStack = dataStruts.sortStack(originalStack);

        Assert.assertEquals(4, returnedStack.pop().intValue());
        Assert.assertEquals(2, returnedStack.pop().intValue());
    }

    @Test
    public void testCanSortStackWhenOnlyOneElement() {
        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);

        Stack<Integer> returnedStack = dataStruts.sortStack(originalStack);

        Assert.assertEquals(2, returnedStack.pop().intValue());
    }

    @Test
    public void testCanSortStackWhenStackNotSorted() {
        Stack<Integer> originalStack = new Stack<Integer>();
        originalStack.push(2);
        originalStack.push(1);
        originalStack.push(3);

        Stack<Integer> returnedStack = dataStruts.sortStack(originalStack);

        Assert.assertEquals(3, returnedStack.pop().intValue());
        Assert.assertEquals(2, returnedStack.pop().intValue());
        Assert.assertEquals(1, returnedStack.pop().intValue());
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
