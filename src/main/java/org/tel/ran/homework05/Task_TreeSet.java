package org.tel.ran.homework05;

import java.util.*;

import static org.tel.ran.textFormatting.*;

/**
 * Создать TreeSet. Из него: Найти заданное число 10, самое большое, самое маленькое Вывести все четные числа
 * Получить список всех чисел в обратном порядке Получить список всех чисел меньше 7
 */
public class Task_TreeSet {

    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>(Set.of(8, 5, 11, 2, 9, 4, 3, 1, 7, 10, 6));
        System.out.println("findNumber(numbers,10) = " + findNumber(numbers, 10));
        System.out.println("findMin(numbers) = " + findMin(numbers));
        System.out.println("findMax(numbers) = " + findMax(numbers));
        System.out.println("createReversedList(numbers) = " + createReversedList(numbers));
        System.out.println("createListWithNumbersLessThanTarget(numbers, 7) = " + createListWithNumbersLessThanTarget(numbers, 7));
    }

    public static boolean findNumber(TreeSet<Integer> numbers, int target) {
        System.out.println(YELLOW + "Найти заданное число 10" + RESET);
        /*for (Integer number:numbers){
            if (number.equals(target)){
                return true;
            }
        }
        return false;*/
        return numbers.contains(target);
    }

    public static Integer findMin(TreeSet<Integer> numbers) {
        System.out.println(YELLOW + "Найти самое маленькое число" + RESET);
        return numbers.getFirst();
    }

    public static Integer findMax(TreeSet<Integer> numbers) {
        System.out.println(YELLOW + "Найти самое большое число" + RESET);
        return numbers.getLast();
    }

    public static List<Integer> createReversedList(TreeSet<Integer> numbers) {
        System.out.println(YELLOW + "Получить список всех чисел в обратном порядке" + RESET);
        List<Integer> reversedList = new ArrayList<>(numbers);
        return reversedList.reversed();
    }

    public static List<Integer> createListWithNumbersLessThanTarget(Set<Integer> numbers, int target) {
        System.out.println(YELLOW + "Получить список всех чисел меньше target" + RESET);
        List<Integer> listWithNumbersLessThanTarget = new ArrayList<>();
        for (Integer number : numbers) {
            if (number >= target) {
                break;
            }
            listWithNumbersLessThanTarget.add(number);
        }
        return listWithNumbersLessThanTarget;
    }
}
