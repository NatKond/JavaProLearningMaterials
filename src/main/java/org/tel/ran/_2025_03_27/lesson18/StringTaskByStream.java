package org.tel.ran._2025_03_27.lesson18;

import java.util.*;
import java.util.stream.Collectors;

public class StringTaskByStream {
    public static void main(String[] args) {
        String s = "Once upon a time a Wolf was lapping at a spring on a hillside, when, looking up, what should he see but a Lamb just beginning to drink a little lower down.";
        List<String> words = List.of(s.toLowerCase().replaceAll("[\\P{L}&&[^\\s']]", "").split(" "));
        Map<Character, TreeSet<String>> map = words.stream()
                .map(word -> word + " " + Collections.frequency(words, word))
                .collect(Collectors.groupingBy(w -> Character.toUpperCase(w.charAt(0)), TreeMap::new,
                        Collectors.toCollection(TreeSet::new)));

        String result = map.entrySet().stream().map(entry -> {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(entry.getKey())
                            .append(": ")
                            .append(entry.getValue().pollFirst())
                            .append("\n");
                    entry.getValue()
                            .forEach(string -> {
                        stringBuilder.append("   ")
                                .append(string)
                                .append("\n");
                    });
                    return stringBuilder;
                })
                .collect(Collectors.joining());
        System.out.println(result);
    }
}
