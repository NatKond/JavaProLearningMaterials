package org.tel.ran._2025_02_27.lesson12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "лимонный торт, лимонный пирог, лимонный сок. Не лимонный, а вишневый!";
        Pattern pattern1 = Pattern.compile("лимонный(?= пирог)"); // positive case
        Pattern pattern2 = Pattern.compile("лимонный(?! пирог)"); // negative case
        Pattern pattern3 = Pattern.compile("(?<! пирог)лимонный");
        Matcher matcher = pattern3.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher.start() + "-" + matcher.end() + ": " + matcher.group());
        }
        String s2 = "Иван Иванович купил 3 яблока по цене 25.50 рубля за штуку. В магазине также были груши (4 штуки)," +
                " но они стоили 30.75 рубля. 21:35:54 Он решил оплатить картой Mastercard с номером 1234-5678-9012-3456.";
        System.out.println(getCountNumbers(s2));

        String s3 = "This is a word in a sentence. Another word appears here. Sometimes, a word can be found multiple times in a paragraph. Word.";
        String s4 = "Word word word word word.";
        System.out.println(replaceWord(s3));
        System.out.println(replaceWord(s4));
        System.out.println(replaceWordMatcher(s3));
        System.out.println(replaceWordMatcher(s4));

        String s5 = "xbacthis is a test. xbacyou should remove only x before abc. xacb should disappear, but x alone should stay. Another xacbtest.";
        System.out.println(deleteLetter(s5));

        String s6 = "abc1 should be removed, but abc should stay. abc2 must go, while abc three stays. Another test: abc9 disappears, but abc 5 stays because of the space.";
        System.out.println(deleteDigits(s6));

        String s7 = " This  is   a test string  with   multiple spaces.  Remove        extra  spaces  correctly! ";
        System.out.println(deleteAdditionalSpaces(s7));

        String s8 = "Alice found 55 apples, but she lost 2 on her way home.";
        String s9 = "Room 2999 was locked, but room 2998 was open.";
        System.out.println(finsSumOfAllDigits(s8));
        System.out.println(finsSumOfAllDigits(s9));
        System.out.println(findCharsInWords("words", "letters"));
    }

    /**
     * 1.В данной строке найти количество цифр.
     */
    public static int getCountNumbers(String text) {
        int count = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     * Замените в строке все вхождения 'word' на 'letter'
     */
    public static String replaceWord(String text) {
        return text.replaceAll("[Ww]ord", "letter");
    }

    public static String replaceWordMatcher(String text) {
        Pattern pattern = Pattern.compile("[Ww]ord");
        StringBuilder textCopy = new StringBuilder(text);
        Matcher matcher = pattern.matcher(textCopy);
        int start, end;
        int pointer = 0;
        while (matcher.find(pointer)) {
            start = matcher.start();
            end = matcher.end();
            textCopy.replace(start, end, "letter");
            pointer = end + 1;
        }
        return textCopy.toString();
    }

    /**
     * Удалите в строке все буквы 'x'. за которыми следует 'abc'.
     */
    public static String deleteLetter(String text) {
        StringBuilder textCopy = new StringBuilder(text);
        Pattern pattern = Pattern.compile("x(abc|acb|bac|bca|cab|cba)");
        Matcher matcher = pattern.matcher(textCopy);
        int pointer = 0;
        while (matcher.find(pointer)) {
            textCopy.deleteCharAt(matcher.start());
            pointer = matcher.start();
        }
        return textCopy.toString();
    }

    /**
     * Удалите в строке все 'abc', за которыми следует цифра.
     */
    public static String deleteDigits(String text) {
        //return text.replaceAll("(abc|acb|bac|bca|cab|cba)(?=\\d)","");
        return text.replaceAll("((?=[abc]{3})a?b?c?)(?=\\d)", "");
    }

    /**
     * Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов заменить на одиночные пробелы. Крайние пробелы в строке удалить.
     */
    public static String deleteAdditionalSpaces(String text) {
        return text.trim().replaceAll("\\s{2,}", " ");
    }

    /**
     * Дан текст. Найти сумму имеющихся в нем цифр
     */
    public static int finsSumOfAllDigits(String text) {
        int sum = 0;
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return sum;
    }

    /**
     * Даны два слова. Найдите только те символы слов, которые встречаются в обоих словах только один раз.
     */
    public static List<Character> findCharsInWords(String s1, String s2) {
        Map<Character, Integer> letterCountMap1 = getLetterCountMap(s1);
        Map<Character, Integer> letterCountMap2 = getLetterCountMap(s2);
        Set <Map.Entry<Character,Integer>> letterCountSet = letterCountMap1.entrySet();
        letterCountSet.retainAll(letterCountMap2.entrySet());
        ArrayList<Character> output = new ArrayList<>();
        for (Map.Entry<Character,Integer> entry:letterCountSet){
            if (entry.getValue().equals(1)){
                output.add(entry.getKey());
            }
        }
        return output;
    }

    private static Map<Character,Integer> getLetterCountMap(String s) {
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (!letterCountMap.containsKey(c)) {
                letterCountMap.put(c, 1);
            } else {
                letterCountMap.put(c, letterCountMap.get(c) + 1);
            }
        }
        return letterCountMap;
    }
}
