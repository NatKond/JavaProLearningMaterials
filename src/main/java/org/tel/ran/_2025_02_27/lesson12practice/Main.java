package org.tel.ran._2025_02_27.lesson12practice;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String text = "Hello java!";
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.insert(3, "-");
        System.out.println(stringBuilder);
        String s = stringBuilder.toString();
        System.out.println(generateFullAddress("Berlin", "14199", "Fitz-Wildung-straße", "23"));
        System.out.println(generateFullAddress("Berlin", "10117", "Friedrichstraße", "185-190"));

        System.out.println(reverseString(text));
    }

    public static String generateFullAddress(String... parts) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String part : parts) {
            stringBuilder.append(part).append(" ");
        }
        return stringBuilder.toString();
    }

    public static String reverseString(String s) {
        Stack<Character> characters = new Stack<>();
        for (Character c : s.toCharArray()) {
            characters.push(c);
        }
        StringBuilder reversedString = new StringBuilder();
        while (!characters.empty()){
            reversedString.append(characters.pop());
        }
        return reversedString.toString();
    }
}
