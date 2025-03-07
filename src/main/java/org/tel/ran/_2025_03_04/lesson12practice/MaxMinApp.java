package org.tel.ran._2025_03_04.lesson12practice;

public class MaxMinApp {

    public static void main(String[] args) {
        ArrayFinder arrayFinder = new ArrayFinder();
        int[] array = {-4, 4, 2, 56, 42, 78, 33, 15, -1, -8, 15};
        System.out.println("Min = " + arrayFinder.getMin(array));
        System.out.println("Max = " + arrayFinder.getMax(array));
    }
}
