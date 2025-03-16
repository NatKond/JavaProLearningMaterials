package org.tel.ran.homework07;

import java.util.*;

/**
 * Программа принимает на вход текст, произвольной длины, обрабатывает его и выводит все слова, которые встречаются в тексте (без дубликатов) группируя их по первой букве в алфавитном порядке.
 * Знаки препинания, кавычки, скобки (кроме апострофа) игнорируются, числа также игнорируются.
 * Регистр заглавных букв не учитывается. Подсчитать количество вхождений.
 */

/*
It's a sunny day, but Jack's not happy. He doesn't know why. Maybe it's because he's forgotten something important. Let's see —oh, it's his best friend's birthday! He'd better hurry!

 1999, a small town had only 2 schools and 3 grocery stores. Now, in 2024, it has 10 schools, 15 grocery stores, and over 50 restaurants. The population grew from 5,000 to 20,000 in just 25 years!

Apple, apple, apple! I love apples. Red apples, green apples, and yellow apples. Apples are great for pies, apple juice, apple sauce, and apple snacks. Who doesn't love apples?

Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a Lamb just beginning to drink a little lower down.
 */

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String answer;
        String input;
        boolean flag = true;
        Map<String, Integer> wordsCount = new TreeMap<>();
        while (flag) {
            printActions();
            answer = SCANNER.nextLine();
            switch (answer) {
                case "0" -> flag = false;
                case "1" -> {
                    System.out.println("Enter some text:");
                    input = SCANNER.nextLine();
                    System.out.println(WordCounter.countWords(input));
                }
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
