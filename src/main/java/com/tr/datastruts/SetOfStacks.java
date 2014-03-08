package com.tr.datastruts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore,
//  in real life, we would likely start a new stack when the previous stack exceeds some
//  threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
//  Stacks should be composed of several stacks and should create a new stack once
//  the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
//  pop () should behave identically to a single stack (that is, pop () should return the
//  same values as it would if there were just a single stack).
//  FOLLOW UP
//  Implement a function popAt(int index) which performs a pop operation on a
//  specific sub-stack


public class SetOfStacks<T> {
    private List<Stack<T>> stackList = new ArrayList<Stack<T>>();
    private int internalStackSize = 4;

    public SetOfStacks() {}

    public SetOfStacks(int internalStackSize) {
        this.internalStackSize = internalStackSize;
    }

    public void push(T value) {
        Stack<T> currentStack = getLastUsedStack();
        if (currentStack == null || currentStack.size() == internalStackSize) {
            addInternalStack();
            currentStack = getLastUsedStack();
        }

        currentStack.push(value);
    }

    public T pop() {
        Stack<T> currentStack = getLastUsedStack();
        if (currentStack == null) {
            return null;
        }

        T retVal = currentStack.pop();
        if (currentStack.isEmpty()) {
            removeLastStack();
        }

        return retVal;
    }

    public T peek() {
        Stack<T> currentStack = getLastUsedStack();
        if (currentStack == null) {
            return null;
        }

        return currentStack.peek();
    }

    Stack<T> getLastUsedStack() {
        if (stackList.isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    void addInternalStack() {
        stackList.add(new Stack<T>());
    }

    void removeLastStack() {
        Stack<T> currentStack = getLastUsedStack();
        if (currentStack != null) {
            stackList.remove(currentStack);
        }
    }

    public Integer size() {
        int size = 0;
        for (Stack<T> stack : stackList) {
            size += stack.size();
        }

        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Stack<T> stack : stackList) {
            count++;
            stringBuilder.append("Stack :" + count + " with size: " + stack.size() + " :");
            stringBuilder.append(stack.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public T popAt(int index) {
        if (index < 0 || stackList.isEmpty() || index >= stackList.size()) {
            return null;
        }

        if (index == (stackList.size() - 1)) {
            return pop();
        }

        Stack<T> currentStack = stackList.get(index);
        T retVal = currentStack.pop();

        shiftStackElements(currentStack);

        return retVal;
    }

    private void shiftStackElements(Stack<T> fromStack) {
        if (fromStack == null || stackList.isEmpty()) {
            return;
        }

        int index = stackList.indexOf(fromStack);
        if (index < 0 || (index + 1) >= stackList.size()) {
            return;
        }

        Stack<T> toStack = stackList.get(index + 1);

        // invert elements into a buffer stack
        Stack<T> buffer = new Stack<T>();
        while (!toStack.isEmpty()){
            buffer.push(toStack.pop());
        }
        fromStack.push(buffer.pop());

        while (!buffer.isEmpty()) {
            toStack.push(buffer.pop());
        }

        if (toStack.isEmpty()) {
            stackList.remove(toStack);
        } else {
            shiftStackElements(toStack);
        }
    }


    Integer getLastUsedStackNumber() {
        Stack<T> lastUsedStack = getLastUsedStack();
        if (lastUsedStack == null) {
            return null;
        }

        return stackList.indexOf(lastUsedStack);
    }
}
