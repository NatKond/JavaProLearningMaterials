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

    private String lastAlgorithmName;

    private String lastLoopType;

    public String getLastAlgorithmName() {
        return lastAlgorithmName;
    }

    public String getLastLoopType() {
        return lastLoopType;
    }

    public int[] executeAlgorithm(int algorithmId, int loopType, int inputNumber) {
        return chooseAlgorithm(algorithmId, loopType, inputNumber);
    }

    private int[] chooseAlgorithm(int algorithmId,  int loopType, int inputNumber) {
        switch (algorithmId) {
            case 1: {
                lastAlgorithmName = "Fibonacci";
                return chooseLoopFibonacci(loopType, inputNumber);
            }
            case 2: {
                lastAlgorithmName = "Factorial";
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
                    lastLoopType = "while";
                    return fibonacciSequence.getSequenceWhile();
                }
                case 2: {
                    lastLoopType = "do-while";
                    return fibonacciSequence.getSequenceDoWhile();
                }
                case 3: {
                    lastLoopType = "for";
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
                    lastLoopType = "while";
                    return new int[]{factorial.getFactorialWhile(inputNumber)};
                }
                case 2: {
                    lastLoopType = "do-while";
                    return new int[]{factorial.getFactorialDoWhile(inputNumber)};
                }
                case 3: {
                    lastLoopType = "for";
                    return new int[]{factorial.getFactorialFor(inputNumber)};
                }
                default: {
                    throw new IllegalArgumentException("Invalid loop type!");
                }
            }
        }

}