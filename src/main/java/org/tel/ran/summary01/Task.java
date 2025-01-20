package org.tel.ran.summary01;

import java.util.ArrayList;
import java.util.Arrays;

public class Task {

    public static int findSumOfEvenPositiveNumbers(int[] array){
        if (!checkArray(array)) return 0;

        int sum = 0;
        for (int j : array) {
            if (j > 0 && j % 2 == 0) {
                sum += j;
            }
        }
        return sum;
    }

    public static int findMaxOfEvenIndexes(int[] array){
        if (!checkArray(array)) return 0;

        int max = array[0];
        for (int i = 2; i < array.length; i+=2) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;
    }

    public static int[] findNumbersLessThanAverage(int[] array){
        if (!checkArray(array)) return new int[0];

        int average;
        int sum = 0;
        for (int num:array){
            sum += num;
        }
        average = sum / array.length;


        ArrayList <Integer> numbersLessThanAverageList = new ArrayList<>();
        for (int num: array){
            if (num > average) numbersLessThanAverageList.add(num);
        }

        int[] numbersLessThanAverage = new int[numbersLessThanAverageList.size()];
        for (int i = 0; i < numbersLessThanAverage.length; i++) {
            numbersLessThanAverage[i] = numbersLessThanAverageList.get(i);
        }
        return numbersLessThanAverage;
    }

    public static int[] findTwoMinimals(int[] array){
        if (!checkArray(array)) return new int[0];

        int[] twoMinimals = new int[2];
        int[] arraySorted = array.clone();
        Arrays.sort(arraySorted);
        for (int i = 0; i < twoMinimals.length; i++) {
            twoMinimals[i] = arraySorted[i];
        }
        return twoMinimals;
    }

    public static int[] deleteElementFromArray(int[] array, int lowerBound, int upperBound){
        if (!checkArray(array)) return new int[0];

        int[] compressedArray = new int[array.length];
        int compressedIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < lowerBound || i > upperBound){
                compressedArray[compressedIndex++] = array[i];
            }
        }

        for (int i = compressedIndex; i < compressedArray.length; i++) {
            compressedArray[i] = 0;
        }
        return compressedArray;
    }

    public static int sumElementsAfterFirstNegative(int[] array){
        if (!checkArray(array)) return 0;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0){
                for (int j = i; j < array.length; j++) {
                    sum += Math.abs(array[i]);
                }
                break;
            }
        }
        return sum;
    }

    public static int findIndexOfMinAbsoluteValue(int[] array){
        if (!checkArray(array)) return 0;

        int indexMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) < Math.abs(array[indexMin])){
                indexMin = i;
            }
        }
        return indexMin;
    }

    public static int findSumOfAllElement(int[] array){
        if (!checkArray(array)) return 0;

        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int findSumBetweenMinAndMax(int[] array){
        if (!checkArray(array)) return 0;

        int maxIndex = 0;
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if(array[i] > array[maxIndex]){
                maxIndex = i;
            }
            if (array[i] < array[minIndex]){
                minIndex = i;
            }
        }

        int startIndex = Math.min(minIndex, maxIndex);
        int endIndex = Math.max(minIndex, maxIndex);

        int sum = 0;
        for (int i = startIndex; i < endIndex; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static double calculateAverageOfPositiveElements (int[] array){
        if (!checkArray(array)) return 0;

        int sum = 0;
        int count = 0;

        for (int n: array){
            if (n > 0) {
                sum += n;
                count++;
            }
        }

        if (count == 0) {
            System.err.println("No positive elements in the array");
        }

        return (double) sum / count;
    }

    public static int findMaximalNegative (int[] array){
        if (!checkArray(array)) return 0;

        int maxNegative = -1;
        boolean withoutNegatives = true;
        for (int n:array){
            if (n < 0) {
                maxNegative = n;
                withoutNegatives = false;
                break;
            }
        }
        if (withoutNegatives) {
            System.err.println("There is no negatives values in the array");
            return 0;
        }

        for (int n : array) {
            if (n < 0 && n > maxNegative) maxNegative = n;
        }

        return maxNegative;
    }




    private static boolean checkArray(int[] array){
        if (array == null || array.length == 0) {
            System.err.println("Array must not be null or empty");
            return false;
        }
        return true;
    }

}
