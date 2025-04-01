package org.tel.ran._2025_03_28.summary08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * С помощью стримов:
 * Посчитать количество неповторяющихся слов в списке
 * Посчитать количество людей с именем "Tom" в списке имен
 * Из списка имен вывести первое по алфавиту, предпоследнее по алфавиту
 * Посчитать количество чисел от 1 до 1000, которые делятся на 7.
 * Посчитать сумму квадратов чисел от 1 до 100
 * Проверить, все ли числа из списка четные
 */


public class Main {
    public static void main(String[] args) {
        List<String> words = List.of(
                "apple", "banana", "orange", "apple", "grape", "banana",
                "peach", "kiwi", "mango", "pear", "plum", "peach", "kiwi"
        );
        System.out.println("words.size() = " + words.size());
        System.out.println("countUniqueWords(words) = " + countUniqueWords(words));

        List<String> names = List.of(
                "Tom", "Alice", "Bob", "Tom", "Charlie", "David", "Eve",
                "Tom", "Frank", "Grace", "Hank", "Tom", "Ivy", "Jack", "Tom"
        );

        System.out.println("countName(names,\"Tom\") = " + countName(names, "Tom"));
        System.out.println("names.stream().sorted().toList() = " + names.stream().sorted().toList());
        System.out.println("getFirstName(names) = " + getFirstName(names));
        System.out.println("getFirstName(new ArrayList<>())) = " + getFirstName(new ArrayList<>()));

        System.out.println("getSecondLastName(names) = " + getSecondLastName(names));
        System.out.println("getSecondLastName(new ArrayList<>())) = " + getSecondLastName(new ArrayList<>()));

        System.out.println("numbersDivisibleBy(7) = " + numbersDivisibleBy(7));
        System.out.println("sumSquares(100) = " + sumSquares(100));

        System.out.println("areAllEven(List.of(2, 4, 6, 122, 64, 78)) = " + areAllEven(List.of(2, 4, 8, 122, 64, 78)));

    }

    /**
     * Посчитать количество неповторяющихся слов в списке
     *
     * @param words
     * @return
     */
    public static long countUniqueWords(List<String> words) {
        return words.stream().distinct().count();
    }

    /**
     * Посчитать количество людей с именем "Tom" в списке имен
     *
     * @param names
     * @param name
     * @return
     */
    public static long countName(List<String> names, String name) {
        return names.stream().filter(n -> n.equals(name)).count();
    }


    /**
     * Из списка имен вывести первое по алфавиту, предпоследнее по алфавиту
     *
     * @param names
     * @return
     */
    public static String getFirstName(List<String> names) {
//        return names.stream().min((n1,n2) -> n1.compareTo(n2)).get();
//        return names.stream().min(String::compareTo).get();
        return names.stream()
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Invalid data."));
    }

    /**
     * Из списка имен вывести предпоследнее по алфавиту
     *
     * @param names
     * @return
     */

    public static String getSecondLastName(List<String> names) {
        return names.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(2)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Invalid data."));
    }

    /**
     * Посчитать количество чисел от 1 до 1000, которые делятся на 7.
     * @param number
     * @return
     */
    public static long numbersDivisibleBy(int number) {
        return IntStream.rangeClosed(1, 1000).filter(n -> n % number == 0).count();
    }

    /**
     * Посчитать сумму квадратов чисел от 1 до 100
     * @param limit
     * @return
     */
    public static long sumSquares(int limit) {
        return IntStream.rangeClosed(1, limit).map(n -> n * n).sum();
    }

    /**
     * Проверить, все ли числа из списка четные
     * @param numbers
     * @return
     */
    public static boolean areAllEven(List<Integer> numbers) {
        return numbers.stream().allMatch(n -> n % 2 == 0);
    }
}
