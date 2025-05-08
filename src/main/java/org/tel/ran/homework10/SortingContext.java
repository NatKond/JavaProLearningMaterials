package org.tel.ran.homework10;

public class SortingContext{

    private Sorter sorter;

    public SortingContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public void execute (int[] array){
        sorter.sort(array);
    }
}
