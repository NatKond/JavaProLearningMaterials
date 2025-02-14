package org.tel.ran._2025_02_11.lesson08;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    Object[] elementData;
    private int size;
    private int maxSize;

    public MyArrayList(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E o) {
        if (size == maxSize) {
            throw new IllegalArgumentException("List is full. The maximum capacity has been reached.");
        }
        if (size == elementData.length) {
            elementData = grow();

        }
        elementData[size++] = o;
        return true;
    }

    private Object[] grow() {
        /*Object[] newArr = new Object[elementData.length * 3 / 2];
        for (int i = 0; i < elementData.length; i++) {
            newArr[i] = elementData[i];
        }
        System.arraycopy(elementData, 0, newArr, 0, elementData.length);
         */
        return Arrays.copyOf(elementData, elementData.length * 3 / 2);
    }


    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    remove(i);
                    return true;
                }
            }
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
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        Object removedObject = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        return (E) removedObject;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i == size - 1) {
                break;
            }
            sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private class Itr implements Iterator<E> {

        private int current = -1;

        @Override
        public boolean hasNext() {
            return current + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException("Out of bounds.");
            return (E) elementData[++current];
        }

        @Override
        public void remove() {
            if (current < 0) {
                throw new IllegalArgumentException("Out of bounds.");
            }
            MyArrayList.this.remove(current);
            current--;
        }
    }
}
