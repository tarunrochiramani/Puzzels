package com.tr.datastruts;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class QueueUsingStackTest {

    QueueUsingStack<Integer> myQueue;

    @Before
    public void setUp() {
        myQueue = new QueueUsingStack<Integer>();
    }

    @Test
    public void testRemoveWhenQueueIsEmpty() {
        assertNull(myQueue.remove());
    }

    @Test
    public void testPeekWhenQueueIsEmpty() {
        assertNull(myQueue.peek());
    }

    @Test
    public void testOperationsOnQueue() {
        assertTrue(myQueue.getSize() == 0);

        int[] values = {1 ,2 ,3};

        for (int value : values) {
            myQueue.add(value);
        }

        assertEquals(values.length, myQueue.getSize());
        assertEquals(values[0], myQueue.peek().intValue());

        for (int value : values) {
            assertEquals(value, myQueue.remove().intValue());
        }

        assertNull(myQueue.peek());
        assertNull(myQueue.remove());
    }


    @Test
    public void testMixedOperations() {
        assertTrue(myQueue.getSize() == 0);

        int[] values = {1 ,2 ,3};

        for (int value : values) {
            myQueue.add(value);
        }

        assertEquals(values[0], myQueue.remove().intValue());
        assertEquals(values[1], myQueue.peek().intValue());

        myQueue.add(4);
        assertEquals(values[1], myQueue.remove().intValue());
        assertEquals(values[2], myQueue.remove().intValue());
        assertEquals(4, myQueue.remove().intValue());

    }

}
