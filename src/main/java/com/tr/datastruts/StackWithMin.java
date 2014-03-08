package com.tr.datastruts;

import java.util.Stack;

public class StackWithMin extends Stack<Integer> {
    private Stack<Integer> minStack;

    public StackWithMin() {
        minStack = new Stack<Integer>();
    }

    public int getMin() {
        if (minStack.empty()) {
            return Integer.MAX_VALUE;
        }
        return minStack.peek();
    }

    public void push(int value) {
        if (value < getMin()) {
            minStack.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();

        if (value == getMin()) {
            minStack.pop();
        }

        return value;
    }
}
