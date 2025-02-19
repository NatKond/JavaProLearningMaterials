package org.tel.ran._2025_02_14.summary04;

import java.util.*;

import static org.tel.ran.textFormatting.*;

public class Main {
    public static void main(String[] args) {

        System.out.println(YELLOW + "isAnagram(\"Silence\",\"Listen\") = " + isAnagram("Silence", "Listen") + RESET);
        System.out.println(YELLOW + "isAnagram(\"Silent\",\"Listen\") = " + isAnagram("Silent", "Listen") + RESET);
        System.out.println(YELLOW + "isAnagramWithMaps(\"Silent\", \"Listen\") = " + isAnagramWithMaps("Silent", "Listen") + RESET);
        System.out.println(YELLOW + "isAnagramWithMaps(\"Silence\", \"Listen\") = " + isAnagramWithMaps("Silence", "Listen") + RESET);
        System.out.println(YELLOW + "isAnagramWithMaps(\"просветитель\",\"терпеливость\") = " + isAnagramWithMaps("Просветитель", "Терпеливость") + RESET);
        System.out.println("getStringFromNumber(1) = " + getStringFromNumber(4));
        System.out.println("getStringFromNumberWithMap(5) = " + getStringFromNumberWithMap(5));
        System.out.println("getSymbolOfSuit(\"Heart\") = " + RED + getSymbolOfSuit("Heart") + RESET);
        System.out.println("getSymbolOfSuit(\"Spade\") = " + BLUE + getSymbolOfSuit("Spade") + RESET);
        System.out.println("getSymbolOfSuit(\"Club\") = " + BLUE + getSymbolOfSuit("Club") + RESET);

        Map<String,Integer> mapExample = new HashMap<>(Map.of("Hi!", 1, "Hello", 2, "Bye",3,"Goodbye",4,"Afternoon",2, "Good morning",1));
        System.out.println("mapExample = " + mapExample);
        System.out.println(YELLOW + "findTargetEntry(mapExample,2) = " + findTargetEntry(mapExample, 2));
        System.out.println("findTargetEntry(mapExample,1) = " + findTargetEntry(mapExample, 1) + RESET);
    }

    /**
     * Дано 2 строки, проверить являются ли они анаграммами
     */

    public static boolean isAnagram(String s1, String s2) {
        char[] charsS1 = s1.toLowerCase().toCharArray();
        Arrays.sort(charsS1);
        System.out.println("charsS1 = " + Arrays.toString(charsS1));

        char[] charsS2 = s2.toLowerCase().toCharArray();
        Arrays.sort(charsS2);
        System.out.println("charsS2 = " + Arrays.toString(charsS2));

        return Arrays.equals(charsS1, charsS2);
    }

    public static boolean isAnagramWithMaps(String s1, String s2) {
        Map<Character, Integer> mapS1 = new HashMap<>();
        Map<Character, Integer> mapS2 = new HashMap<>();

        for (Character c : s1.toLowerCase().toCharArray()) {
            if (mapS1.containsKey(c)) {
                mapS1.put(c, mapS1.get(c) + 1);
            } else {
                mapS1.put(c, 1);
            }
        }
        System.out.println("mapS1 = " + mapS1);
        for (Character c : s2.toLowerCase().toCharArray()) {
            if (mapS2.containsKey(c)) {
                mapS2.put(c, mapS2.get(c) + 1);
            } else {
                mapS2.put(c, 1);
            }
        }
        System.out.println("mapS2 = " + mapS2);
        return Objects.equals(mapS1, mapS2);
        //return mapS1.equals(mapS2);
    }

    /**
     * Дано число от 1 до 10, вывести на экран его строковое представление
     */
    public static String getStringFromNumber(Integer integer) {
        String[] numberNames = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        return numberNames[integer - 1];
    }

    public static String getStringFromNumberWithMap(Integer integer) {
        Map<Integer,String> map = Map.of(1, "one",2, "two", 3,"three",4, "four",5, "five",6, "six", 7,"seven", 8, "eight",9, "nine",10, "ten");
        return map.get(integer);
    }

    public static char getSymbolOfSuit(String suit){
        char[] symbols = {9827, 9830, 9829, 9824};
        Map<String,Character> suits = Map.of("CLUB", symbols[0], "DIAMOND", symbols[1], "HEART", symbols[2], "SPADE",symbols[3]);
        return suits.get(suit.toUpperCase());
    }

    /**
     * Найти все ключи в Map<String, Integer>, соответствующие заданному значению, и вернуть их в виде списка.
     */
    public static List<String> findTargetEntry(Map<String,Integer> map, Integer target){
        Set<Map.Entry<String,Integer>> entrySet = map.entrySet();
        List<String> output = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: entrySet){
            if (entry.getValue().equals(target)){
                output.add(entry.getKey());
            }
        }
        return output;
    }
}

