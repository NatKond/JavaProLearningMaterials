package org.tel.ran.homework02;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String VALID_CHARACTERS = "1234567890";

    private static final int NUMBER_OF_PARAMETERS = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                To run an algorithm enter three numbers separated by a space:\s
                1. algorithmId - the type of algorithm, where 1 represents the calculation of the Fibonacci sequence, and 2 represents the calculation of a factorial.
                2. loopType - the type of loop to be used, where 1 represents a while loop, 2 represents a do-while loop, and 3 represents a for loop.
                3. inputNumber - the parameter passed to the algorithm.\s""");
        String inputLine = scanner.nextLine();
        int[] input = parseInputForAlgorithmRunner(inputLine);
        AlgorithmRunner algorithmRunner = new AlgorithmRunner();
        int[] result = algorithmRunner.executeAlgorithm(input[0], input[1], input[2]);
        printResult(algorithmRunner.getLastAlgorithmName(),algorithmRunner.getLastLoopType(),result);
    }

    private static int[] parseInputForAlgorithmRunner (String input){
        input = input.replaceAll("\\s+", "");
        if (!checkStringForValidCharacters(input)) throw new IllegalArgumentException("Invalid input data!");
        int[] inputData = new int[NUMBER_OF_PARAMETERS];
        for (int i = 0; i < inputData.length - 1; i++) {
            inputData[i] = input.charAt(i) - '0';
        }
        inputData[inputData.length - 1] = Integer.parseInt(input.substring(inputData.length - 1));
        return inputData;
    }

    private static void printResult (String algorithmName, String loopType, int[] result){
        StringBuilder output = new StringBuilder(algorithmName + " calculated using the " + loopType + " loop: ");
        for (int n : result) output.append(n).append(" ");
        System.out.println(output);
    }

    private static boolean checkStringForValidCharacters (String input){
        if (input == null || input.length() < 3) {
            throw new IllegalArgumentException("Invalid input data!");
        }
        for (char c : input.toCharArray()) {
            if (VALID_CHARACTERS.indexOf(c) == -1) return false;
        }
        return true;
    }

}
