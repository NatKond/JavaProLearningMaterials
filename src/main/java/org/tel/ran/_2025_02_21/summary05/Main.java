package org.tel.ran._2025_02_21.summary05;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = Map.of("1", 1, "2", 2, "3", 3, "4", 4, "5", 5);
        System.out.println("hasValueAboveThreshold(stringIntegerMap,5) = " + hasValueAboveThreshold(stringIntegerMap, 5));
        System.out.println("hasValueAboveThreshold(stringIntegerMap,4) = " + hasValueAboveThreshold(stringIntegerMap, 4));
        System.out.println("hasValueAboveThreshold(stringIntegerMap,3) = " + hasValueAboveThreshold(stringIntegerMap, 3));
        Map<String, Integer> nameAgeMap = Map.of("Alice", 25, "Bob", 30, "Charlie", 22, "David", 28, "Emma", 27, "Frank", 35, "Grace", 24, "Henry", 29, "Isabella", 26);
        System.out.println("hasValueAboveThreshold(nameAgeMap,25) = " + hasValueAboveThreshold(nameAgeMap, 25));
        System.out.println("hasValueAboveThreshold(nameAgeMap,25) = " + hasValueAboveThreshold(nameAgeMap, 28));
        System.out.println("hasValueAboveThreshold(nameAgeMap,25) = " + hasValueAboveThreshold(nameAgeMap, 30));
        Map<Integer, Boolean> integerBooleanMap1 = Map.of(1, true, 2, true, 3, true, 4, true, 6, true);
        Map<Integer, Boolean> integerBooleanMap2 = Map.of(1, true, 2, true, 3, false, 4, true, 6, true);
        System.out.println("isAllValuesTrue(integerBooleanMap1) = " + isAllValuesTrue(integerBooleanMap1));
        System.out.println("isAllValuesTrue(integerBooleanMap2) = " + isAllValuesTrue(integerBooleanMap2));
        System.out.println("sumOfValues(nameAgeMap,List.of(\"Bob\",\"Emma\")) = " + sumOfValues(nameAgeMap, Set.of("Bob", "Emma", "Henry", "Al")));
        System.out.println("nameAgeMap = " + nameAgeMap);
        System.out.println("swapMap(nameAgeMap) = " + swapMap(nameAgeMap));
        System.out.println("groupedByLength(List.of(\"AAA\",\"BBB\",\"CCC\",\"AA\",\"BB\",\"CC\")) = " + groupedByLength(List.of("AAA", "BBB", "CCC", "AA", "BB", "CC")));
        Map<String, String> stringStringMap = Map.of("1", "1", "2", "2", "3", "H", "4", "4", "5", "A");
        System.out.println("findNumberKeys(stringStringMap) = " + findNumberKeys(stringStringMap));
        System.out.println("findNumberKeysRegex(stringStringMap) = " + findNumberKeysRegex(stringStringMap));
    }

    /**
     * Проверить, содержит ли Map<String, Integer> хотя бы одну запись, у которой значение больше заданного порога.
     */
    public static boolean hasValueAboveThreshold(Map<String, Integer> stringIntegerMap, int threshold) {
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            if (entry.getValue() > threshold) {
                return true;
            }
        }
        return false;
    }

    /**
     * Проверить, все ли значения в Map<Integer, Boolean> равны true.
     */
    public static boolean isAllValuesTrue(Map<Integer, Boolean> integerBooleanMap) {
        for (Map.Entry<Integer, Boolean> entry : integerBooleanMap.entrySet()) {
            if (!entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Найти сумму всех значений(int) в Map<String, Integer>, которые соответствуют заданному ключевому набору
     */
    public static int sumOfValues(Map<String, Integer> stringIntegerMap, Set<String> keys) {
        int sum = 0;
        for (String key : keys) {
            if (stringIntegerMap.containsKey(key)) {
                sum += stringIntegerMap.get(key);
            }
        }
        return sum;
    }

    /**
     * Дана Map<String, Integer>, вернуть Map в которой все ключи являются значениями, а все значения ключами из этой Map
     */
    public static Map<Integer, String> swapMap(Map<String, Integer> stringIntegerMap) {
        Map<Integer, String> integerStringMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()) {
            integerStringMap.put(entry.getValue(), entry.getKey());
        }
        return integerStringMap;
    }

    /**
     * Дан список строк, нужно сгруппировать их по длине
     */
    public static Map<Integer, List<String>> groupedByLength(List<String> strings) {
        Map<Integer, List<String>> integerListMap = new HashMap<>(); // создаем мапу
        for (String s : strings) { // берем слово из списка
            if (!integerListMap.containsKey(s.length())) { // если элемента с длиной этого слова нет
                ArrayList<String> words = new ArrayList<>();
                words.add(s);
                integerListMap.put(s.length(), words); // то добаляем новый элемент в мапу с ключем = длине, значением - новый с список с одним элементом - этим словом
            } else { // иначе добавляем слово в уже существующий список, находим список по ключу = длина слова
                List<String> words = integerListMap.get(s.length());
                words.add(s);
            }
        }
        return integerListMap;
    }

    /**
     * Найти все ключи, значение которых состоит только из цифр.
     */
    public static Set<String> findNumberKeys(Map<String, String> stringStringMap) {
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
            try {
                Integer.parseInt(entry.getValue());
                keys.add(entry.getKey());
            } catch (NumberFormatException _) {
            }
        }
        return keys;
    }

    public static Set<String> findNumberKeysRegex(Map<String, String> stringStringMap) {
        Set<String> keys = new HashSet<>();
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
            if (entry.getValue().matches("\\d+")) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }
}
