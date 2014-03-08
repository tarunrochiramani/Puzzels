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


public class SetOfStacks {
    private List<Stack<Integer>> stackList = new ArrayList<Stack<Integer>>();
    private int internalStackSize = 4;

    public SetOfStacks() {}

    public SetOfStacks(int internalStackSize) {
        this.internalStackSize = internalStackSize;
    }

    public void push(Integer value) {
        Stack<Integer> currentStack = getLastUsedStack();
        if (currentStack == null || currentStack.size() == internalStackSize) {
            addInternalStack();
            currentStack = getLastUsedStack();
        }

        currentStack.push(value);
    }

    public Integer pop() {
        Stack<Integer> currentStack = getLastUsedStack();
        if (currentStack == null) {
            return null;
        }

        int retVal = currentStack.pop();
        if (currentStack.isEmpty()) {
            removeLastStack();
        }

        return retVal;
    }

    public Integer peek() {
        Stack<Integer> currentStack = getLastUsedStack();
        if (currentStack == null) {
            return null;
        }

        return currentStack.peek();
    }

    Stack<Integer> getLastUsedStack() {
        if (stackList.isEmpty()) {
            return null;
        }
        return stackList.get(stackList.size() - 1);
    }

    void addInternalStack() {
        stackList.add(new Stack<Integer>());
    }

    void removeLastStack() {
        Stack<Integer> currentStack = getLastUsedStack();
        if (currentStack != null) {
            stackList.remove(currentStack);
        }
    }

    public Integer size() {
        int size = 0;
        for (Stack<Integer> stack : stackList) {
            size += stack.size();
        }

        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (Stack<Integer> stack : stackList) {
            count++;
            stringBuilder.append("Stack :" + count + " with size: " + stack.size() + " :");
            stringBuilder.append(stack.toString());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    public Integer popAt(int index) {
        if (index < 0 || stackList.isEmpty() || index >= stackList.size()) {
            return null;
        }

        if (index == (stackList.size() - 1)) {
            return pop();
        }

        Stack<Integer> currentStack = stackList.get(index);
        int retVal = currentStack.pop();

        shiftStackElements(currentStack);

        return retVal;
    }

    private void shiftStackElements(Stack<Integer> fromStack) {
        if (fromStack == null || stackList.isEmpty()) {
            return;
        }

        int index = stackList.indexOf(fromStack);
        if (index < 0 || (index + 1) >= stackList.size()) {
            return;
        }

        Stack<Integer> toStack = stackList.get(index + 1);

        // invert elements into a buffer stack
        Stack<Integer> buffer = new Stack<Integer>();
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
        Stack<Integer> lastUsedStack = getLastUsedStack();
        if (lastUsedStack == null) {
            return null;
        }

        return stackList.indexOf(lastUsedStack);
    }
}
