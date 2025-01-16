package org.tel.ran.homework01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FibonacciSequence fs1;
        String length = scanner.nextLine();

        while (!length.isEmpty()){
            fs1 = new FibonacciSequence(Integer.parseInt(length));
            System.out.println("fs1.getSequenceFor() = " + Arrays.toString(fs1.getSequenceFor()));
            System.out.println("fs1.getSequenceWhile() = " + Arrays.toString(fs1.getSequenceWhile()));
            System.out.println("fs1.getSequenceDoWhile() = " + Arrays.toString(fs1.getSequenceDoWhile()));
            length = scanner.nextLine();
        }

    }
}
