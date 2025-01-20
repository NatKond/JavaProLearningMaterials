package org.tel.ran.homework01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the Fibonacci sequence: ");
        String length = scanner.nextLine();

        FibonacciSequence fs1 = new FibonacciSequence(Integer.parseInt(length));
        System.out.println("fs1.getSequenceFor() = " + Arrays.toString(fs1.getSequenceFor()));
        System.out.println("fs1.getSequenceWhile() = " + Arrays.toString(fs1.getSequenceWhile()));
        System.out.println("fs1.getSequenceDoWhile() = " + Arrays.toString(fs1.getSequenceDoWhile()));

        FibonacciSequence fs2 = new FibonacciSequence();
        fs1.setLength(Integer.parseInt(length));
        System.out.println("fs2.getSequenceFor() = " + Arrays.toString(fs2.getSequenceFor()));
        System.out.println("fs2.getSequenceWhile() = " + Arrays.toString(fs2.getSequenceWhile()));
        System.out.println("fs2.getSequenceDoWhile() = " + Arrays.toString(fs2.getSequenceDoWhile()));
    }
}
