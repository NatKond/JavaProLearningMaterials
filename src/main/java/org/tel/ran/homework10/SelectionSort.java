package org.tel.ran.homework10;

public class SelectionSort implements Sorter {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int indexMin = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    indexMin = j;
                }
            }
            if (indexMin != i){
                int temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
            }
        }
    }
}
