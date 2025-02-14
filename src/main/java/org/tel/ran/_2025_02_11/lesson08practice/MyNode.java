package org.tel.ran._2025_02_11.lesson08practice;

public class MyNode {
    private int value;

    private MyNode next;

    public MyNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }
}
