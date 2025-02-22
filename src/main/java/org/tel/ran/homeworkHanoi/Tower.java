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
            this.RINGS.add(i + 1);
        }
    }

    public void moveRing(Tower target) {
        target.RINGS.addFirst(this.RINGS.getFirst());
        this.RINGS.removeFirst();
    }

    public boolean isMoveAllowed(Tower target) {
        return !RINGS.isEmpty()&&(target.RINGS.isEmpty() || this.RINGS.getFirst() < target.RINGS.getFirst());
    }

    public Integer getSize() {
        return RINGS.size();
    }

    public Iterator<Integer> getIterator() {
        return RINGS.iterator();
    }

    @Override
    public String toString() {
        return RINGS.toString();
    }
}