package org.tel.ran.summary01;

public class Main {
    public static void main(String[] args) {
        // Пример 1: Обычный массив с положительными и отрицательными числами
        int[] array1 = {3, -7, 2, -1, 5, -10};

        // Пример 2: Массив с одинаковыми элементами
        int[] array2 = {5, 5, 5, 5, 5};

        // Пример 3: Массив с отрицательными числами
        int[] array3 = {-3, -7, -2, -1, -5, -10};

        // Пример 4: Массив с нулем и положительными числами
        int[] array4 = {0, 7, 2, 1, 5, 10};

        // Пример 5: Массив с одним элементом
        int[] array5 = {-42};

        // Пример 6: Пустой массив
        int[] array6 = {};

        // Пример 7: Массив с уже отсортированными элементами
        int[] array7 = {-10, -7, -5, -2, 0, 1, 3, 5};

        // Пример 8: Массив с максимальными и минимальными значениями int
        int[] array8 = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};

        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array1));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array2));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array3));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array4));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array5));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array6));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array7));
        System.out.println("Task.findSumOfEvenPositiveNumbers(array1) = " + Task.findSumOfEvenPositiveNumbers(array8));

    }
}
