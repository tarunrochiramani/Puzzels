package com.tr.datastruts;

import java.util.Stack;

public class QueueUsingStack<T> {

    private Stack<T> stackNew;
    private Stack<T> stackOld;

    public QueueUsingStack() {
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public int getSize() {
        return stackNew.size() + stackOld.size();
    }

    public T peek() {
        if (stackOld.isEmpty()) {
            shiftStackValues();
        }

        if (stackOld.isEmpty()) {
            return null;
        }

        return stackOld.peek();
    }

    public T remove() {
        if (stackOld.isEmpty()) {
            shiftStackValues();
        }

        if (stackOld.isEmpty()) {
            return null;
        }

        return stackOld.pop();
    }

    public void add(T value) {
        stackNew.push(value);
    }

    private void shiftStackValues() {
        if (stackOld.isEmpty()) {
            while (!stackNew.isEmpty()) {
                stackOld.push(stackNew.pop());
            }
        }
    }
}
