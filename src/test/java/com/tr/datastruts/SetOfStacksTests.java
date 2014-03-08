package com.tr.datastruts;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SetOfStacksTests {
    private SetOfStacks setOfStacks;

    @Before
    public void setUp() {
        setOfStacks = new SetOfStacks();
    }

    @Test
    public void testAddGetRemoveLastUsedStack() {
        assertNull(setOfStacks.getLastUsedStack());
        System.out.println(setOfStacks);

        setOfStacks.addInternalStack();
        assertNotNull(setOfStacks.getLastUsedStack());
        assertTrue(setOfStacks.getLastUsedStack().isEmpty());
        System.out.println(setOfStacks);

        setOfStacks.removeLastStack();
        assertNull(setOfStacks.getLastUsedStack());

        assertNull(setOfStacks.peek());
        assertNull(setOfStacks.pop());
        System.out.println(setOfStacks);
    }

    @Test
    public void testPushPopAndPeek() {
        int[] values = {1, 2, 3, 4, 5, 6 ,7};
        assertNull(setOfStacks.getLastUsedStack());
        assertEquals(0, setOfStacks.size().intValue());

        for (int value : values) {
            setOfStacks.push(value);
        }

        assertNotNull(setOfStacks.getLastUsedStack());
        assertEquals(values.length, setOfStacks.size().intValue());
        System.out.print(setOfStacks);

        assertEquals(values[values.length-1], setOfStacks.peek().intValue());

        for (int count = (values.length -1); count>=0; count--) {
            assertEquals(values[count], setOfStacks.pop().intValue());
        }

        assertNull(setOfStacks.getLastUsedStack());
        assertEquals(0, setOfStacks.size().intValue());
    }

    @Test
    public void testPopAtWithOnlyOneStack() {
        assertNull(setOfStacks.popAt(-1));
        assertNull(setOfStacks.popAt(0));

        int[] values = {1, 2, 3, 4};

        for (int value : values) {
            setOfStacks.push(value);
        }

        assertEquals(values[values.length - 1], setOfStacks.popAt(0).intValue());
        assertNull(setOfStacks.popAt(-1));
        assertNull(setOfStacks.popAt(2));
    }

    @Test
    public void testPopAtWithMultipleStacksButNoShifting() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        Integer currentStackIndex = setOfStacks.getLastUsedStackNumber();
        assertNull(currentStackIndex);

        for (int value : values) {
            setOfStacks.push(value);
        }
        currentStackIndex = setOfStacks.getLastUsedStackNumber();
        assertNotNull(currentStackIndex);

        assertEquals(values[values.length -1], setOfStacks.popAt(1).intValue());
        assertEquals(currentStackIndex, setOfStacks.getLastUsedStackNumber());
    }

    @Test
    public void testPopAtWithMultipleStacksAndShifting() {
        int[] values = {1, 2, 3, 4, 5, 6, 7};
        Stack<Integer> currentStack = setOfStacks.getLastUsedStack();
        assertNull(currentStack);

        for (int value : values) {
            setOfStacks.push(value);
        }
        currentStack = setOfStacks.getLastUsedStack();
        assertNotNull(currentStack);
        int stackSizeWithoutShift = currentStack.size();

        assertEquals(values[3], setOfStacks.popAt(0).intValue());
        assertEquals(stackSizeWithoutShift - 1, setOfStacks.getLastUsedStack().size());
        assertEquals(values[values.length - 1], setOfStacks.peek().intValue());
        System.out.println(setOfStacks);
    }

    @Test
    public void testPopAtWithMultipleStacksAndShiftingAndRemovingTheLastStack() {
        int[] values = {1, 2, 3, 4, 5};
        Stack<Integer> currentStack = setOfStacks.getLastUsedStack();
        assertNull(currentStack);

        for (int value : values) {
            setOfStacks.push(value);
        }

        currentStack = setOfStacks.getLastUsedStack();
        assertNotNull(currentStack);
        Integer currentStackIndex = setOfStacks.getLastUsedStackNumber();


        assertEquals(values[3], setOfStacks.popAt(0).intValue());
        assertEquals(currentStackIndex -1, setOfStacks.getLastUsedStackNumber().intValue());
        assertEquals(values[values.length - 1], setOfStacks.peek().intValue());
        System.out.println(setOfStacks);
    }

    @Test
    public void testPopAtWithIndexAtLastStackIndex() {
        int[] values = {1, 2, 3, 4, 5};
        Stack<Integer> currentStack = setOfStacks.getLastUsedStack();
        assertNull(currentStack);

        for (int value : values) {
            setOfStacks.push(value);
        }

        currentStack = setOfStacks.getLastUsedStack();
        assertNotNull(currentStack);
        Integer currentStackIndex = setOfStacks.getLastUsedStackNumber();
        assertTrue(currentStackIndex > 0);


        assertEquals(values[values.length -1], setOfStacks.popAt(1).intValue());
        assertEquals(currentStackIndex -1, setOfStacks.getLastUsedStackNumber().intValue());
        assertEquals(values[values.length - 2], setOfStacks.peek().intValue());
        System.out.println(setOfStacks);
    }
}
