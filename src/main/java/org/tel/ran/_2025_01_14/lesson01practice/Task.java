package org.tel.ran.lesson01practice;

import java.util.Arrays;

public class Task {

    public static void main(String[] args) {
        String example = "Hello Java Class";
        StringBuilder exampleStringBuilder = new StringBuilder();
        for (int i = 0; i < example.length(); i++) {
            exampleStringBuilder.append(example.charAt(example.length() - 1 - i));
        }
        System.out.println("exampleStringBuilder = " + exampleStringBuilder);
        System.out.println("exampleStringBuilder.reverse() = " + exampleStringBuilder.reverse());

        String[] array = {"one", "two", "tree", "four", "five"};
        System.out.println("reverseStringArray(array) = " + reverseStringArray(array));
    }
    public static String reverseStringArray(String[] array){
        StringBuilder reversed = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (String s : array) {
            result.append(reversed.append(s).reverse());
            reversed.delete(0, s.length());
        }

        return result.toString();
    }
}
