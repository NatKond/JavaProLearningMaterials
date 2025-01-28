package org.tel.ran.lesson01;

import java.text.DecimalFormat;
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

    private static final String VALID_CHARACTERS = "+-*/1234567890. ";

    private static final String MATH_OPERATIONS = "+-*/";

    private final String[] history = new String[5];

    private int countCases;

    public String getResult(String input){
        if (!checkStringForValidCharacters(input)) return "Error. The string contains invalid characters.";

        ArrayList<Double> numbers = new ArrayList<>();
        StringBuilder operations = new StringBuilder();

        parseString(input,numbers,operations);
        if (checkDivisionByZero(numbers,operations)) return "Error, division by zero!";

        double result = calculate(numbers, operations);

        String stringWithCase = createStringWithCase(numbers,operations);
        DecimalFormat twoDecimals = new DecimalFormat("0.00");
        String output = stringWithCase + twoDecimals.format(result);
        saveHistory(output);
        return output;
    }

    public String[] getHistory(){
        return this.history;
    }

    private void saveHistory (String output){
        if (countCases == history.length){
            for (int i = 0; i < history.length - 1; i++) {
                history[i] = history[i+1];
                countCases = history.length - 1;
            }
        }

        history[countCases] = output;
        countCases++;
    }

    private boolean checkStringForValidCharacters(String input){
        for (char c:input.toCharArray()){
            if (VALID_CHARACTERS.indexOf(c) == -1) return false;
        }
        return true;
    }

    private void parseString(String input, ArrayList<Double> numbers, StringBuilder operations){
        input = input.replaceAll("\\s+","");
        int startOfNumber = 0;
        int indexOfOperation;
        char c;
        for (int i = 1; i < input.length(); i++) {
            c = input.charAt(i);
            indexOfOperation = MATH_OPERATIONS.indexOf(c);
            if (indexOfOperation != -1){
                numbers.add(Double.parseDouble(input.substring(startOfNumber,i)));
                operations.append(MATH_OPERATIONS.charAt(indexOfOperation));
                startOfNumber = i + 1;
            }
        }
        numbers.add(Double.parseDouble(input.substring(startOfNumber)));
    }

    private boolean checkDivisionByZero(ArrayList<Double> numbers, StringBuilder operations){
        for (int i = 0; i < operations.length(); i++) {
            if (operations.charAt(i) == '/' && numbers.get(i + 1) == 0) return true;
        }
        return false;
    }

    private double calculate (ArrayList<Double> numbers, StringBuilder operations){
        ArrayList<Double> numbersCopy = new ArrayList<>(numbers);
        StringBuilder operationsCopy = new StringBuilder(operations);
        multiplyAndDivide(numbersCopy, operationsCopy);
        return addAndSubtract(numbersCopy, operationsCopy);
    }

    private void multiplyAndDivide(ArrayList<Double> numbers, StringBuilder operations){
        int indexOfMultiplication = operations.indexOf("*");
        int indexOfDivision = operations.indexOf("/");
        while (indexOfMultiplication != -1 || indexOfDivision != -1){
            if (indexOfMultiplication != -1){
                operations.deleteCharAt(indexOfMultiplication);
                numbers.set(indexOfMultiplication, numbers.get(indexOfMultiplication) * numbers.get(indexOfMultiplication + 1));
                numbers.remove(indexOfMultiplication + 1);
            }
            indexOfDivision = operations.indexOf("/");

            if (indexOfDivision != -1){
                operations.deleteCharAt(indexOfDivision);
                numbers.set(indexOfDivision, numbers.get(indexOfDivision) / (numbers.get(indexOfDivision + 1)));
                numbers.remove(indexOfDivision + 1);
            }
            indexOfMultiplication = operations.indexOf("*");
            indexOfDivision = operations.indexOf("/");
        }
    }

    private double addAndSubtract (ArrayList<Double> numbers, StringBuilder operations){
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

    private String createStringWithCase(ArrayList<Double> numbers, StringBuilder operations){
        StringBuilder stringWithCase = new StringBuilder();
        DecimalFormat df = new DecimalFormat("0.##");
        for (int i = 0; i < operations.length(); i++) {
            stringWithCase.append(df.format(numbers.get(i))).append(" ").append(operations.charAt(i)).append(" ");
        }
        stringWithCase.append(df.format(numbers.getLast())).append(" = ");

        return stringWithCase.toString();
    }

}
