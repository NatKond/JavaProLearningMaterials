package org.tel.ran.lesson01;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String input = scanner.nextLine();

        while (!input.isEmpty()){
            System.out.println(calculator.getResult(input));
            input = scanner.nextLine();
        }
    }
}