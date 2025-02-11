package org.tel.ran._2025_02_11.lesson8;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList implements List {
    int size;
    private MyNode first;
    private MyNode last;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        if (size == 0) {
            MyNode myNode = new MyNode(o);
            first = myNode;
            last = myNode;
        } else {
            MyNode myNode = new MyNode(o);
            myNode.setPrevious(last);
            last.setNext(myNode);
            last = myNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        MyNode currentNode = first;
        for (int i = 0; i < size - 1; i++) {
            if (o == currentNode.getValue()) {
                remove(i);
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        MyNode currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getValue();
    }

    @Override
    public Object set(int index, Object element) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        MyNode currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setValue(element);
        return currentNode;
    }

    @Override
    public void add(int index, Object element) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        MyNode currentNode = first;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
        }
        MyNode next = currentNode.getNext();
        MyNode newNode = new MyNode(element);
        newNode.setNext(next);
        next.setPrevious(newNode);
        newNode.setPrevious(currentNode);
        currentNode.setNext(newNode);
        size++;
    }

    @Override
    public Object remove(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (index == 0) {
            MyNode old = first;
            first = old.getNext();
            old.setNext(null);
            size--;
            return old;
        }
        if (index == size - 1) {
            MyNode old = last;
            last = old.getPrevious();
            old.setPrevious(null);
            size--;
            return old;
        }
        MyNode currentNode = first;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.getPrevious().setNext(currentNode.getNext());
        currentNode.getNext().setPrevious(currentNode.getPrevious());
        currentNode.setNext(null);
        currentNode.setPrevious(null);
        size--;
        return currentNode;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return List.of();
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        MyNode current = first;
        for (int i = 0; i < size; i++) {
            sb.append(current.getValue());
            if (i == size - 1) {
                break;
            }
            current = current.getNext();
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public String toStringWhile() {
        StringBuilder sb = new StringBuilder("[");
        MyNode current = first;
        while (current != null) {
            if (current != first) {
                sb.append(", ");
            }
            sb.append(current.getValue());
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
