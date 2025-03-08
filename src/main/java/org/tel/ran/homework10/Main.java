package org.tel.ran.homework10;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {53, -3, 21, -7, 12, 5, 0};
        Sorter sorterBubble = Sorter.chooseSorter("selection");
        SortingContext sortingContext = new SortingContext(sorterBubble);
        sortingContext.execute(array);
        System.out.println("array = " + Arrays.toString(array));

    }
}
