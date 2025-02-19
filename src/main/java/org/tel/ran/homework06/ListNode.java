package org.tel.ran.homework06;

public class ListNode<V> {
    private V value;
    private ListNode<V> previous;
    private ListNode<V> next;

    public ListNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public ListNode<V> getPrevious() {
        return previous;
    }

    public ListNode<V> getNext() {
        return next;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setPrevious(ListNode<V> previous) {
        this.previous = previous;
    }

    public void setNext(ListNode<V> next) {
        this.next = next;
    }
}
