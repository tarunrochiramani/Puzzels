package com.tr.datastruts;

public class LinkedListNode {
    private int data;
    private LinkedListNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public boolean equals(Object o) {
        if (! (o instanceof LinkedListNode)) {
            return false;
        }

        if (this.data == ((LinkedListNode)o).getData()) {
            return true;
        }

        return false;
    }

    public int hashCode() {
        return data % 31;
    }
}
