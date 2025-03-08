package org.tel.ran.homework10;

import org.tel.ran.homework08.CharacterValidator;
import org.tel.ran.homework08.IntegerValidator;

import java.util.Map;

public class SortingContext{
    private Sorter sorter;

    public SortingContext(Sorter sorter) {
        this.sorter = sorter;
    }

    public void execute (int[] array){
        sorter.sort(array);
    }
}
