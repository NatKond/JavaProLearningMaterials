package org.tel.ran.homework10;

import org.tel.ran._2025_03_06.lesson13practice.InvalidAmountException;

public interface Sorter {
    void sort(int[] array);

    static Sorter chooseSorter(String sorterName){
        return switch (sorterName){
            case "selection" -> new SelectionSort();
            case "bubble" -> new BubbleSort();
            default -> throw new InvalidAmountException(sorterName + "is invalid sort name.");
        };
    }
}
