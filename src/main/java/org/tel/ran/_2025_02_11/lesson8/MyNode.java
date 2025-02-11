package org.tel.ran._2025_02_11.lesson8;

public class MyNode {
    Object value;
    private MyNode next;
    private MyNode previous;

    public MyNode(Object o) {
        value = o;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    public void setPrevious(MyNode previous){
        this.previous = previous;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public MyNode getNext() {
        return next;
    }

    public MyNode getPrevious() {
        return previous;
    }
}
