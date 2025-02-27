package org.tel.ran.homework06;

import org.tel.ran._2025_02_11.lesson08.MyArrayList;
import org.tel.ran.homework06.exceptions.MaxSizeExceededException;
import org.tel.ran.homework06.exceptions.OutOfRangeException;

import java.util.*;

public class FixedSizeArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    Object[] elementData;
    private int size;
    private int maxSize;

    public FixedSizeArrayList(int maxSize) {
        this.maxSize = maxSize;
        elementData = new Object[Math.min(DEFAULT_CAPACITY, maxSize)];
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
        return indexOf(o) >= 0;
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
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        hasReachedMaxSize();
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size++] = e;
        return true;
    }

    private Object[] grow() {
        return Arrays.copyOf(elementData, Math.min(elementData.length * 3 / 2, maxSize));
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elementData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(elementData, null);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E old = (E) elementData[index];
        elementData[index] = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        hasReachedMaxSize();
        if (size == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        checkIndex(index);
        Object removedObject = elementData[index];
        if (index < size - 1) {
            System.arraycopy(elementData, index + 1, elementData, index, size - 1 - index);
        }
        elementData[--size] = null;
        return (E) removedObject;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    private void hasReachedMaxSize() {
        if (size == maxSize) {
            throw new MaxSizeExceededException("List is full. The maximum size " + maxSize + " has been reaches.");
        }
    }

    private void checkIndex(int index) {
        if (!(index >= 0 && index < size)) {
            throw new OutOfRangeException("Index " + index + " is out of bounds. The largest index of this list is " + (size - 1) + ".");
        }
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
            FixedSizeArrayList.this.remove(current);
            current--;
        }
    }

}
