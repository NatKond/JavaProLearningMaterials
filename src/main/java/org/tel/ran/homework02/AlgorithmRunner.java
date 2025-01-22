package org.tel.ran.homework02;

/**
 * Написать программу, которая принимает на вход три целых числа:
 * 1. algorithmId - тип алгоритма, где 1 - вычисление ряда чисел Фибоначии, 2 - вычисление факториала.
 * 2. loopType - тип цикла, который нужно использовать, где 1 - цикл while, 2 - цикл do-while, 3 - цикл for.
 * 3. n - параметр передаваемый в алгоритм.
 */

public class AlgorithmRunner {

    private final String VALID_CHARACTERS = "1234567890";
    private final int NUMBER_OF_PARAMETERS = 3;

    public int[] executeAlgorithm(String input) {
        input = input.replaceAll("\\s+", "");
        if (!checkStringForValidCharacters(input)) throw new IllegalArgumentException("Invalid input data!");
        int[] inputData = parseInput(input);
        int algorithmId = inputData[0];
        int loopType = inputData[1];
        int inputNumber = inputData[2];
        return chooseAlgorithm(algorithmId, loopType, inputNumber);
    }

    private int[] chooseAlgorithm(int algorithmId,  int loopType, int inputNumber) {
        switch (algorithmId) {
            case 1: {
                return chooseLoopFibonacci(loopType, inputNumber);
            }
            case 2: {
                return chooseLoopFactorial(loopType, inputNumber);
            }
            default: {
                throw new IllegalArgumentException("Invalid algorithm type!");
            }
        }
    }

        private int[] chooseLoopFibonacci(int loopType, int inputNumber){
            FibonacciSequence fibonacciSequence = new FibonacciSequence(inputNumber);
            switch (loopType) {
                case 1: {
                    return fibonacciSequence.getSequenceWhile();
                }
                case 2: {
                    return fibonacciSequence.getSequenceDoWhile();
                }
                case 3: {
                    return fibonacciSequence.getSequenceFor();
                }
                default: {
                    throw new IllegalArgumentException("Invalid loop type!");
                }
            }
        }

        private int[] chooseLoopFactorial(int loopType, int inputNumber){
            Factorial factorial = new Factorial();
            switch (loopType) {
                case 1: {
                    return new int[]{factorial.getFactorialWhile(inputNumber)};
                }
                case 2: {
                    return new int[]{factorial.getFactorialDoWhile(inputNumber)};
                }
                case 3: {
                    return new int[]{factorial.getFactorialFor(inputNumber)};
                }
                default: {
                    throw new IllegalArgumentException("Invalid loop type!");
                }
            }
        }

        private int[] parseInput (String input){
            int[] inputData = new int[NUMBER_OF_PARAMETERS];
            for (int i = 0; i < inputData.length - 1; i++) {
                inputData[i] = input.charAt(i) - '0';
            }
            inputData[inputData.length - 1] = Integer.parseInt(input.substring(inputData.length - 1));
            return inputData;
        }

        private boolean checkStringForValidCharacters (String input){
            if (input == null || input.length() < 3) {
                throw new IllegalArgumentException("Invalid input data!");
            }
            for (char c : input.toCharArray()) {
                if (VALID_CHARACTERS.indexOf(c) == -1) return false;
            }
            return true;
        }

        private String printResult (String algorithmName, String loopType,int[] result){
            StringBuilder output = new StringBuilder(algorithmName + " calculated using the " + loopType + " loop: ");
            for (int n : result) output.append(n).append(" ");
            return output.toString();
        }

}