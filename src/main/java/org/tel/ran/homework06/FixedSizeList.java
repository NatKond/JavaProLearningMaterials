package org.tel.ran.homework06;

import org.tel.ran._2025_02_11.lesson08.MyArrayList;
import org.tel.ran.homework06.exceptions.ElementNotFoundException;
import org.tel.ran.homework06.exceptions.OutOfRangeException;
import org.tel.ran.homework06.exceptions.MaxSizeExceededException;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FixedSizeList<E> implements List<E> {
    private final int maxSize;
    private int size;
    private ListNode<E> first;
    private ListNode<E> last;

    public FixedSizeList(int maxSize) {
        this.maxSize = maxSize;
        size = 0;
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
        E value = (E) o;
        ListNode<E> currentNode = first;
        while (currentNode != null) {
            if (value.equals(currentNode.getValue())) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new FixedSizeList<E>.Itr();
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
    public boolean add(E element) {
        hasReachedMaxSize();
        ListNode<E> newNode = new ListNode<>(element);
        if (size == 0) {
            first = newNode;
        } else {
            newNode.setPrevious(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o)) {
            throw new ElementNotFoundException("This list does not contain \"" + o + "\".");
        }
        remove(findNodeByValue((E) o));
        return true;
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
        ListNode<E> currentNode = first;
        ListNode<E> nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setPrevious(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndexBounds(index);
        return findNodeByIndex(index).getValue();
    }

    @Override
    public E set(int index, E element) {
        checkIndexBounds(index);
        ListNode<E> currentNode = findNodeByIndex(index);
        E value = currentNode.getValue();
        currentNode.setValue(element);
        return value;
    }

    @Override
    public void add(int index, E element) {
        hasReachedMaxSize();
        checkIndexBounds(index);
        ListNode<E> newNode = new ListNode<>(element);
        ListNode<E> currentNode = findNodeByIndex(index);
        newNode.setNext(currentNode);
        if (index != 0) {
            newNode.setPrevious(currentNode.getPrevious());
            currentNode.getPrevious().setNext(newNode);
        }
        currentNode.setPrevious(newNode);
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndexBounds(index);
        ListNode<E> currentNode = findNodeByIndex(index);
        ListNode<E> nextNode = currentNode.getNext();
        ListNode<E> previousNode = currentNode.getPrevious();
        if (previousNode == null) {
            first = nextNode;
            nextNode.setPrevious(null);
        } else if (nextNode == null) {
            last = previousNode;
            previousNode.setNext(null);
        } else {
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
        }
        currentNode.setPrevious(null);
        currentNode.setNext(null);
        size--;
        return currentNode.getValue();
    }

    @Override
    public int indexOf(Object o) {
        return findNodeByValue((E) o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return findNodeByValueLast((E) o);
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

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("[");
        ListNode<E> currentNode = first;
        while (currentNode != null) {
            if (currentNode != last) {
                output.append(currentNode.getValue()).append(", ");
            }
            currentNode = currentNode.getNext();
        }
        if (last != null) output.append(last.getValue());
        return output.append("]").append(", size = ").append(size).toString();
    }

    private ListNode<E> findNodeByIndex(int index) {
        if (index == 0) return first;
        if (index == size - 1) return last;
        ListNode<E> currentNode;
        if (index <= size / 2) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.getPrevious();
            }
        }
        return currentNode;
    }

    private int findNodeByValue(E value) {
        if (value.equals(first.getValue())) return 0;
        ListNode<E> currentNode = first;
        for (int i = 1; i < size; i++) {
            currentNode = currentNode.getNext();
            if (value.equals(currentNode.getValue())) {
                return i;
            }
        }
        return -1;
    }

    private int findNodeByValueLast(E value) {
        if (value.equals(last.getValue())) return size - 1;
        ListNode<E> currentNode = last;
        for (int i = size - 2; i > 0; i--) {
            currentNode = currentNode.getPrevious();
            if (value.equals(currentNode.getValue())) {
                return i;
            }
        }
        return -1;
    }

    private void hasReachedMaxSize() {
        if (size == maxSize) {
            throw new MaxSizeExceededException("The maximum size " + maxSize + " has been reaches.");
        }
    }

    private void checkIndexBounds(int index) {
        if (index > size - 1 || index < 0) {
            throw new OutOfRangeException("Index " + index + " is out of bounds. The largest index of this list is " + (size - 1) + ".");
        }
    }

    private class Itr implements Iterator<E> {
        private int current = -1;

        @Override
        public boolean hasNext() {
            return current + 1 < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new OutOfRangeException("The last element has been reached.");
            }
            return findNodeByIndex(++current).getValue();
        }

        @Override
        public void remove() {
            if (!hasNext()) {
                throw new OutOfRangeException("The last element has been reached.");
            }
            FixedSizeList.this.remove(current);
            current--;
        }
    }

}
