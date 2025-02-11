package org.tel.ran._2025_01_14.lesson01;

import java.util.Arrays;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String answer;
        String input;

        do {
            System.out.println("Enter an expression to solve:");
            input = scanner.nextLine();
            System.out.println(calculator.getResult(input));
            System.out.println("------ HISTORY ------");
            System.out.println(Arrays.toString(calculator.getHistory()));
            do{
                System.out.println("Another calculation? (Y/N)");
                answer = scanner.nextLine();
            } while (!answer.equals("Y") && !answer.equals("N"));
        } while (answer.equals("Y"));
    }
}