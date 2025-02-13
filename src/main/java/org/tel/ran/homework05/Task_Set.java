package org.tel.ran.homework05;

import java.util.*;

import static org.tel.ran.textFormatting.*;

public class Task_Set {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>(List.of(5, -2, 7, 1, -3, 4, 8, -3));
        System.out.println(RED + integerSet + RESET);
        System.out.println(findSumPositives(integerSet));
        Set<String> stringSet1 = new HashSet<>(List.of("Hello", "Hey", "Bye", "Goodbye", "Ay", "Bye"));
        System.out.println(RED + stringSet1 + RESET);
        System.out.println(findAllCombinations(stringSet1, integerSet));
        Set<String> stringSet2 = new HashSet<>(List.of("Hi", "Good morning", "Farewell", "Goodbye", "Bye", "See you"));
        System.out.println(RED + stringSet2 + RESET);
        System.out.println(combineSets(stringSet1, stringSet2));
        System.out.println(findCommonElementsSet(stringSet1, stringSet2));
        System.out.println(filterUniqueSet(stringSet1, stringSet2));
    }

    /**
     * Найти сумму всех элементов в Set<Integer>, которые являются четными числами.
     */
    public static int findSumPositives(Set<Integer> integerSet) {
        System.out.println(YELLOW + "Найти сумму всех элементов в Set<Integer>, которые являются четными числами." + RESET);
        int sum = 0;
        for (Integer num : integerSet) {
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }

    /**
     * Получить все возможные комбинации из Set<String> и Set<Integer>, где каждая комбинация представляет собой строку
     * и число, объединенные вместе.
     */
    public static Set<String> findAllCombinations(Set<String> stringSet, Set<Integer> integerSet) {
        System.out.println(YELLOW + "Получить все возможные комбинации из Set<String> и Set<Integer>." + RESET);
        Set<String> combinations = new HashSet<>();
        for (Integer num : integerSet) {
            for (String str : stringSet) {
                combinations.add(num + str);
            }
        }
        return combinations;
    }

    /**
     * Имеется два набора элементов Set. Создать Set, в котором бы находились: все элементы из двух наборов,
     * только общие для двух наборов элементы, только элементы, которые присутствуют в первом наборе и отсутствуют во втором
     */

    public static <T> Set<T> combineSets(Set<T> set1, Set<T> set2) {
        System.out.println(YELLOW + "Создать Set, в котором бы находились все элементы из двух наборов." + RESET);
        Set<T> combinedSet = new HashSet<>(set1);
        combinedSet.addAll(set2);
        return combinedSet;
    }

    public static <T> Set<T> findCommonElementsSet(Set<T> set1, Set<T> set2) {
        System.out.println(YELLOW + "Создать Set, в котором бы находились только общие для двух наборов элементы." + RESET);
        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);
        return intersectionSet;
    }

    public static <T> Set<T> filterUniqueSet(Set<T> set1, Set<T> set2) {
        System.out.println(YELLOW + "Создать Set, в котором бы находились только элементы, которые присутствуют в первом наборе и отсутствуют во втором." + RESET);
        Set<T> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);
        return differenceSet;
    }

}
