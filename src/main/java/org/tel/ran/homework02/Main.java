package org.tel.ran.homework02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                To run an algorithm enter three numbers separated by a space:\s
                1. algorithmId - the type of algorithm, where 1 represents the calculation of the Fibonacci sequence, and 2 represents the calculation of a factorial.
                2. loopType - the type of loop to be used, where 1 represents a while loop, 2 represents a do-while loop, and 3 represents a for loop.
                3. inputNumber - the parameter passed to the algorithm.\s""");
        String input = scanner.nextLine();
        AlgorithmRunner algorithmRunner = new AlgorithmRunner();
        System.out.println(Arrays.toString(algorithmRunner.executeAlgorithm(input)));
    }
}
