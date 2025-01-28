package org.tel.ran._2025_01_17.summary01;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {3, -7, 2, 0, 2, 5, -10, 8, -13, 27, 2, 5};
        System.out.println("testArray = " + Arrays.toString(testArray));

        System.out.println("Task.findSumOfEvenPositiveNumbers(testArray) = " + Task.findSumOfEvenPositiveNumbers(testArray));
        System.out.println("Task.findMaxOfEvenIndexes(array1) = " + Task.findMaxOfEvenIndexes(testArray));
        System.out.println("Task.findNumbersLessThanAverage(testArray) = " + Arrays.toString(Task.findNumbersLessThanAverage(testArray)));
        System.out.println("Task.findTwoMinimals(testArray) = " + Arrays.toString(Task.findTwoMinimals(testArray)));
        System.out.println("Task.deleteElementFromArray(testArray,3,6) = " + Arrays.toString(Task.deleteElementFromArray(testArray, 3, 6)));
        System.out.println("Task.sumAbsOfElementsAfterFirstNegative(testArray) = " + Task.sumAbsOfElementsAfterFirstNegative(testArray));
        System.out.println("Task.findIndexOfMinAbsoluteValue(testArray) = " + Task.findIndexOfMinAbsoluteValue(testArray));
        System.out.println("Task.calculateSumOfDigitsInArray(testArray) = " + Task.calculateSumOfDigitsInArray(testArray));
        System.out.println("Task.findSumBetweenMinAndMax(testArray) = " + Task.findSumBetweenMinAndMax(testArray));
        System.out.println("Task.calculateAverageOfPositiveElements(testArray) = " + Task.calculateAverageOfPositiveElements(testArray));
        System.out.println("Task.findIndexOfMinAbsoluteValue(testArray) = " + Task.findIndexOfMinAbsoluteValue(testArray));
        System.out.println("Task.findMaximalNegative(testArray) = " + Task.findMaximalNegative(testArray));
        System.out.println("Task.findMostFrequentNumber(testArray) = " + Task.findMostFrequentNumber(testArray));
        System.out.println("Task.switchMaxAndMin(testArray) = " + Arrays.toString(Task.switchMaxAndMin(testArray)));
    }
}
