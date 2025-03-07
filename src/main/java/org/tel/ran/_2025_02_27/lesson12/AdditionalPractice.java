package org.tel.ran._2025_02_27.lesson12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionalPractice {
    public static void main(String[] args) {
        String text1 = """
                The little lizard l leisurely lounged under the lemon tree.
                Bouncing b bunnies boldly bounded beyond the broken bridge.
                Daring dogs danced delightfully despite daunting downpours.
                Several students studied sincerely, searching for success.""";
        System.out.println(text1);
        Pattern pattern1 = Pattern.compile("\\b[Ll]\\w*"); // words starting with letter l
        Matcher matcher1 = pattern1.matcher(text1);
        while (matcher1.find()) {
            System.out.println(matcher1.start() + "-" + matcher1.end() + ": " + matcher1.group());
        }

        String text2 = """
                The ancient {artifact} was hidden inside a {cave}.
                When Sarah found it, she whispered, "Unbelievable!" and later added, "This is historic!"
                Among the ruins, she noticed a /mysterious/ symbol and a /secret/ passage.
                She consulted the (map) for clues, but the (directions) were unclear.""";
        Pattern pattern2 = Pattern.compile("(?<=\\()\\w+(?=\\))");
        Matcher matcher2 = pattern2.matcher(text2);
        while (matcher2.find()) {
            System.out.println(matcher2.start() + ":" + matcher2.group());
        }

        String text3 = "abc acb cdf bcd cab cba";
        Pattern pattern3 = Pattern.compile("\\s\\w+\\s");
        Matcher matcher3 = pattern3.matcher(text3);
        System.out.println(matcher3.find());
        System.out.println(matcher3.group());
    }
}
