package org.tel.ran.homework06;

import java.util.Objects;

import static org.tel.ran.textFormatting.*;

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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        ListNode<?> listNode = (ListNode<?>) object;
        return Objects.equals(value, listNode.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(String.valueOf(value));
        if (previous == null) {
            output.append(": previous = null");
        }
        if (next == null) output.append(": next = null");
        return output.toString();
    }
}
