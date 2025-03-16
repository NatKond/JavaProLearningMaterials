package org.tel.ran.homework07;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.tel.ran.textFormatting.*;

public class WordCounter {

    public static String countWords(String text){
        return printMap(getWordsCountMap(text));
    }

    private static Map<String, Integer> getWordsCountMap(String string) {
        String[] strings = string.replaceAll("[^\\p{L}' ]", "").trim().toLowerCase().split("\\s+");
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

    private static String printMap(Map<String, Integer> wordsCountMap) {
        Set<Map.Entry<String, Integer>> wordsCountSet = wordsCountMap.entrySet();
        StringBuilder output = new StringBuilder();
        char letter = ' ';
        for (Map.Entry<String, Integer> word : wordsCountSet) {
            if (!(letter == (word.getKey().toUpperCase().charAt(0)))){
                letter = (word.getKey().toUpperCase().charAt(0));
                output.append(YELLOW).append(letter).append(": ").append(RESET);
            } else output.append("   " );
            output.append(word.getKey()).append(" ").append(word.getValue()).append("\n");
            /*if (letter == (word.getKey().toUpperCase().charAt(0))) {
                System.out.println("   " + word.getKey() + " " + word.getValue());
            } else {
                letter = (word.getKey().toUpperCase().charAt(0));
                System.out.println(YELLOW + letter + ": " + RESET + word.getKey() + " " + word.getValue());
            }*/
        }
        return output.toString();
    }
}
