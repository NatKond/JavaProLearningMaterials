package org.tel.ran.lesson01;

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
            calculator.printHistory();
            do{
                System.out.println("Another calculation? (Y/N)");
                answer = scanner.nextLine();
            } while (!answer.equals("Y") && !answer.equals("N"));
        } while (answer.equals("Y"));
    }
}