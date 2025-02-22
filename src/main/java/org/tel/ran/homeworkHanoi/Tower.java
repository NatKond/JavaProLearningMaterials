package org.tel.ran.homeworkHanoi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Tower {
    private final ArrayList<Integer> RINGS = new ArrayList<>();

    public Tower() {
    }

    public Tower(int n) {
        for (int i = 0; i < n; i++) {
            this.RINGS.addFirst(i + 1);
        }
    }

    public void moveRing(Tower target) {
        target.RINGS.add(this.RINGS.getLast());
        this.RINGS.removeLast();
    }

    public boolean isMoveAllowed(Tower target) {
        return (target.RINGS.isEmpty()&&!RINGS.isEmpty()) || (!RINGS.isEmpty()) && this.RINGS.getLast() < target.RINGS.getLast();
    }

    public Integer getSize() {
        return RINGS.size();
    }

    public Iterator<Integer> getIterator() {
        return new Itr();
    }

    @Override
    public String toString() {
        return RINGS.toString();
    }

    private class Itr implements Iterator<Integer> {

        private int current = RINGS.size();

        @Override
        public boolean hasNext() {
            return current - 1 >= 0;
        }

        @Override
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException("Out of bounds.");
            return RINGS.get(--current);
        }

        @Override
        public void remove() {
            if (current < 0) {
                throw new IllegalArgumentException("Out of bounds.");
            }
            Tower.this.RINGS.remove(current);
            current++;
        }
    }
}