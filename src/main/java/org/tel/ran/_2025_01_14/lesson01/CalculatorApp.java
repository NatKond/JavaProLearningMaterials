package org.tel.ran._2025_01_14.lesson01;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String answer;
        String input;
        int count = 0;

        do {
            System.out.println("Enter an expression to solve:");
            input = scanner.nextLine();
            System.out.println(calculator.getResult(input));
            System.out.println("------ HISTORY ------");
            for (String s : calculator.getHistory()) {
                if (s != null) {
                    System.out.println(s);
                }
            }
            do {
                System.out.println("Another calculation? (Y/N)");
                answer = scanner.nextLine();
            } while (!answer.equals("Y") && !answer.equals("N"));
        } while (answer.equals("Y"));
    }
}