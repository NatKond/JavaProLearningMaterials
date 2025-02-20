package org.tel.ran.homework07;

import java.util.*;

import static org.tel.ran.textFormatting.*;
/*
It's a sunny day, but Jack's not happy. He doesn't know why. Maybe it's because he's forgotten something important. Let's see—oh, it's his best friend's birthday! He'd better hurry!

 1999, a small town had only 2 schools and 3 grocery stores. Now, in 2024, it has 10 schools, 15 grocery stores, and over 50 restaurants. The population grew from 5,000 to 20,000 in just 25 years!

Apple, apple, apple! I love apples. Red apples, green apples, and yellow apples. Apples are great for pies, apple juice, apple sauce, and apple snacks. Who doesn't love apples?
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String answer;
        String input;
        boolean flag = true;
        Map<String, Integer> wordsCount = new TreeMap<>();
        while (flag) {
            printActions();
            answer = scanner.nextLine();
            switch (answer) {
                case "0" -> flag = false;
                case "1" -> {
                    System.out.println("Enter some text:");
                    input = scanner.nextLine();
                    wordsCount = getWordsCountMap(input);
                    printMap(wordsCount);
                }
            }
        }
    }

    private static Map<String, Integer> getWordsCountMap(String string) {
        string = string.replaceAll("[^\\p{L}' ]", "").trim().replaceAll(" {2}", " ");
        String[] strings = string.toLowerCase().split("\\s");
        Map<String, Integer> output = new TreeMap<>(Comparator.naturalOrder());
        for (String str : strings) {
            if (output.containsKey(str)) {
                output.put(str, output.get(str) + 1);
            } else {
                output.put(str, 1);
            }
        }
        return output;
    }

    private static void printMap(Map<String, Integer> wordsCountMap) {
        Set<Map.Entry<String, Integer>> wordsCountSet = wordsCountMap.entrySet();
        char letter = ' ';
        for (Map.Entry<String, Integer> word : wordsCountSet) {
            if (letter == (word.getKey().toUpperCase().charAt(0))) {
                System.out.println("   " + word.getKey() + " " + word.getValue());
            } else {
                letter = (word.getKey().toUpperCase().charAt(0));
                System.out.println(YELLOW + letter + ": " + RESET + word.getKey() + " " + word.getValue());
            }
        }
    }

    private static void printActions() {
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to enter some text and see the words count
                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}
