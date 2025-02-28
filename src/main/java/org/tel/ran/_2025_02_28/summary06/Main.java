package org.tel.ran._2025_02_28.summary06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------- CONTAINS_WORD --------");
        System.out.println("\"apple\", \"app\" = " + containsWord("apple", "app"));
        System.out.println("\"berry\", \"strawberry\" = " + containsWord("berry", "strawberry"));
        System.out.println("\"orange\", \"grapes\" = " + containsWord("orange", "grapes"));
        System.out.println("\"th\", \"method\" = " + containsWord("th", "method"));
        System.out.println("\"\", \"method\" = " + containsWord("", "method"));
        System.out.println("null, \"method\" = " + containsWord(null, "method"));
        System.out.println("-------- CONTAINS_WORD_WITH_MATCHER --------");
        System.out.println("\"apple\", \"app\" = " + containsWordMatcher("apple", "app"));
        System.out.println("\"berry\", \"strawberry\" = " + containsWordMatcher("berry", "strawberry"));
        System.out.println("\"orange\", \"grapes\" = " + containsWordMatcher("orange", "grapes"));
        System.out.println("\"th\", \"method\" = " + containsWordMatcher("th", "method"));
        System.out.println("\"\", \"method\" = " + containsWordMatcher("", "method"));
        System.out.println("null, \"method\" = " + containsWordMatcher(null, "method"));
        System.out.println("-------- REMOVE_ALL_DIGITS --------");
        System.out.println(removeAllDigits("He1llo jav5a!11"));
        System.out.println("-------- CHECK_PARENTHESIS --------");
        System.out.println("(5 + 2) * 10 - 5) / 5 = " + checkParenthesis("((5 + 2) * 10 - 5) / 5"));
        System.out.println("(5 + 2) * (10 - 5) = " + checkParenthesis("(5 + 2) * (10 - 5)"));
        System.out.println("((5 + 2)) = " + checkParenthesis("((5 + 2)"));
        System.out.println("(5 + 2))) = " + checkParenthesis("((5 + 2)"));
        System.out.println(")5 + 2( = " + checkParenthesis(")5 + 2( "));
        System.out.println("-------------- TEXT --------------");
        String text = "The little lizard leisurely lounged under the lemon tree.";
        System.out.println(text);
        System.out.println("---------- COUNT_WORDS ----------");
        System.out.println(countWords(text));
        System.out.println("-------- GET_LONGEST_WORD --------");
        System.out.println(getLongestWord(text));
    }

    /**
     * Даны две строки. Определите, содержится ли меньшая по длине строка в большей.
     */
    public static boolean containsWord(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        if (str1.length() >= str2.length()) {
            return str1.contains(str2);
        } else {
            return str2.contains(str1);
        }
    }

    public static boolean containsWordMatcher(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        String longer, shorter;

        if (str1.length() >= str2.length()) {
            longer = str1;
            shorter = str2;
        } else {
            shorter = str1;
            longer = str2;
        }

        Pattern pattern = Pattern.compile(shorter);
        Matcher matcher = pattern.matcher(longer);
        return matcher.find();
    }

    /**
     * Удалить в строке все цифры.
     */
    public static String removeAllDigits(String text) {
        return text.replaceAll("\\d", "");
    }

    /**
     * Дана строка - проверить правильно ли в ней расставлены скобки
     */
    public static boolean checkParenthesis(String text) {
        Pattern leftParenthesis = Pattern.compile("\\(");
        Matcher matcherLeftParenthesis = leftParenthesis.matcher(text);
        Pattern rightParenthesis = Pattern.compile("\\)");
        Matcher matcherRightParenthesis = rightParenthesis.matcher(text);
        boolean left = matcherLeftParenthesis.find(), right = matcherRightParenthesis.find();
        while (left || right) {
            if (!left || !right) return false;
            if (matcherLeftParenthesis.start() > matcherRightParenthesis.start()) {
                return false;
            }
            left = matcherLeftParenthesis.find();
            right = matcherRightParenthesis.find();
        }
        return true;
    }

    /**
     * Дана строка, состоящая из слов, разделенных пробелами. Определите количество слов в строке.
     */
    public static int countWords(String text) {
        return text.trim().split("\\s+").length;
    }

    /**
     * Строка состоит из слов, разделенных одним или несколькими пробелами. Найдите слово наибольшей длины
     */
    public static String getLongestWord(String text) {
        String[] textWords = text.replaceAll("[^\\p{L}' ]", "").trim().split("\\s+");
        String longestWord = "";
        for (String s : textWords) {
            if (s.length() > longestWord.length()) {
                longestWord = s;
            }
        }
        return longestWord;
    }
}
