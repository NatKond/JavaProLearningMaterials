package org.tel.ran._2025_03_04.lesson12practice;

public class ArrayFinder {

    public int getMax(int[] array) {
        if (array == null || array.length == 0){
           throw new IllegalArgumentException("Array can not be empty or null.");
        }
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public int getMin(int[] array) {
        if (array == null || array.length == 0){
            throw new IllegalArgumentException("Array can not be empty or null.");
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }
}
