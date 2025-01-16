package org.tel.ran.lesson01;

import java.util.ArrayList;

/**
 * Написать программу “Калькулятор” таким образом, что бы она принимала от пользователя
 * вычисляемое математическое выражение в виде одной строки. Например 10.5*5+1-7.1 (без пробелов)
 * и последовательно выполняла бы указанные арифметические операции над аргументами.
 * Результат вычислений необходимо вывести с точностью до двух чисел после запятой
 * в формате <значение аргумента 1> <знак математической операции> <значение аргумента 2> = <значение переменной результата>
 * (добавлены пробелы относительно введённой строки)
 **/

public class Calculator {

    private boolean checkString(String input){
        String check = "+-*/1234567890.";
        for (char c:input.toCharArray()){
            if (check.indexOf(c) == -1) return false;
        }
        return true;
    }

    private void parseString(String input, ArrayList<Double> numbers, StringBuilder operations){
        String mathOperations = "+-*/";
        int startOfNumber = 0;
        int indexOfOperation;
        char c;
        for (int i = 1; i < input.length(); i++) {
            c = input.charAt(i);
            indexOfOperation = mathOperations.indexOf(c);
            if (indexOfOperation != -1){
                numbers.add(Double.parseDouble(input.substring(startOfNumber,i)));
                operations.append(mathOperations.charAt(indexOfOperation));
                startOfNumber = i + 1;
            }
        }
        numbers.add(Double.parseDouble(input.substring(startOfNumber)));
    }

    private void multiply(ArrayList<Double> numbers, StringBuilder operations){
        int indexOfMultiplication = operations.indexOf("*");
        while (indexOfMultiplication != -1){
            operations.deleteCharAt(indexOfMultiplication);
            numbers.set(indexOfMultiplication, numbers.get(indexOfMultiplication) * numbers.get(indexOfMultiplication + 1));
            numbers.remove(indexOfMultiplication + 1);
            indexOfMultiplication = operations.indexOf("*");
        }
    }

    private void divide(ArrayList<Double> numbers, StringBuilder operations){
        int indexOfDivision = operations.indexOf("/");
        while (indexOfDivision != -1){
            operations.deleteCharAt(indexOfDivision);
            numbers.set(indexOfDivision, numbers.get(indexOfDivision) / (numbers.get(indexOfDivision + 1)));
            numbers.remove(indexOfDivision + 1);
            indexOfDivision = operations.indexOf("/");
        }
    }

    private double addAndSubtract(ArrayList<Double> numbers, StringBuilder operations){
        double result = numbers.getFirst();
        for (int i = 0; i < operations.length(); i++) {
            if (operations.charAt(i) == '+'){
                result += numbers.get(i + 1);
            }
            if (operations.charAt(i) == '-') {
                result -= numbers.get(i + 1);
            }
        }
        return result;
    }

    public String getResult(String input){
        input = input.replaceAll("\\s+","");
        if (!checkString(input)) return "Error. The string contains invalid characters.";

        ArrayList<Double> numbers = new ArrayList<>();
        StringBuilder operations = new StringBuilder();

        parseString(input,numbers,operations);

        multiply(numbers, operations);

        divide(numbers, operations);

        return "= " + addAndSubtract(numbers, operations);
    }

}
