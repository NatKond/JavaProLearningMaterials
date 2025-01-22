package org.tel.ran.homework02;

/**
 * Написать программу, которая принимает на вход три целых числа:
 * 1. algorithmId - тип алгоритма, где 1 - вычисление ряда чисел Фибоначии, 2 - вычисление факториала.
 * 2. loopType - тип цикла, который нужно использовать, где 1 - цикл while, 2 - цикл do-while, 3 - цикл for.
 * 3. n - параметр передаваемый в алгоритм.
 */

public class AlgorithmRunner {

    private final String VALID_CHARACTERS = "1234567890 ";
    private final int NUMBER_OF_PARAMETERS = 3;

    public void executeAlgorithm(String input) {
        if (!checkStringForValidCharacters(input)) throw new IllegalArgumentException("Invalid input data!");
        int[] inputData = parseInput(input);
        int algorithmId = inputData[0];
        int loopType = inputData[1];
        int inputNumber = inputData[2];

        switch (algorithmId) {
            case 1: {
                switch (loopType) {
                    case 1: {
                        FibonacciSequence fibonacciSequence = new FibonacciSequence(inputNumber);
                        printResult("Fibonacci sequence", "while", fibonacciSequence.getSequenceWhile());
                        return;
                    }
                    case 2: {
                        FibonacciSequence fibonacciSequence = new FibonacciSequence(inputNumber);
                        printResult("Fibonacci sequence", "do-while",fibonacciSequence.getSequenceDoWhile());
                        return ;
                    }
                    case 3: {
                        FibonacciSequence fibonacciSequence = new FibonacciSequence(inputNumber);
                        printResult("Fibonacci sequence", "for",fibonacciSequence.getSequenceFor());
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid loop type!");
                    }
                }
            }
            case 2: {
                switch (loopType) {
                    case 1: {
                        Factorial factorial = new Factorial();
                        printResult("Factorial", "while", new int[]{factorial.getFactorialWhile(inputNumber)});
                        return;
                    }
                    case 2: {
                        Factorial factorial = new Factorial();
                        printResult("Factorial", "do-while", new int[]{factorial.getFactorialDoWhile(inputNumber)});
                        return;
                    }
                    case 3: {
                        Factorial factorial = new Factorial();
                        printResult("Factorial", "for", new int[]{factorial.getFactorialFor(inputNumber)});
                        return;
                    }
                    default: {
                        throw new IllegalArgumentException("Invalid loop type!");
                    }
                }
            }
            default: {
                throw new IllegalArgumentException("Invalid algorithm type!");
            }
        }
    }

    private int[] parseInput(String input) {
        input = input.replaceAll("\\s+","");

        int[] inputData = new int[NUMBER_OF_PARAMETERS];
        for (int i = 0; i < inputData.length - 1; i++) {
            inputData[i] = input.charAt(i) - '0';
        }
        inputData[inputData.length - 1] = Integer.parseInt(input.substring(inputData.length - 1));
        return inputData;
    }

    private boolean checkStringForValidCharacters(String input){
        for (char c:input.toCharArray()){
            if (VALID_CHARACTERS.indexOf(c) == -1) return false;
        }
        return true;
    }

    private void printResult (String algorithmName, String loopType, int[] result){
        StringBuilder output = new StringBuilder(algorithmName + " calculated using the " + loopType + " loop: ");
        for (int n: result) output.append(n).append(" ");
        System.out.println(output);
    }

}