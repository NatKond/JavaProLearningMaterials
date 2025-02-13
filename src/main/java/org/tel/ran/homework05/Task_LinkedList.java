package org.tel.ran.homework05;

import java.util.*;

import static org.tel.ran.textFormatting.*;

public class Task_LinkedList {
    public static void main(String[] args) {
        List<String> linkedListStrings = new LinkedList<>(List.of("Hello", "Bye", "Goodbye", "Ay", "Afternoon", "Bye", "Hello"));
        System.out.println(RED + linkedListStrings + RESET);
        System.out.println(findShortestWord(linkedListStrings));
        System.out.println(combineAllWords(linkedListStrings));
        System.out.println(findString(linkedListStrings, "Bye"));

        List<Integer> linkedListInteger = new LinkedList<>(List.of(5, 2, 7, 1, 3, 4, 8, 3));
        System.out.println(RED + linkedListInteger + RESET);
        System.out.println(reverseList(linkedListStrings));
        System.out.println(reverseList(linkedListInteger));
        System.out.println("Bye: " + Arrays.toString(findFirstAndLast(linkedListStrings, "Bye")));
        System.out.println("3: " + Arrays.toString(findFirstAndLast(linkedListInteger, 3)));
        System.out.println("By: " + findStringsStartingWith(linkedListStrings, "By"));

        List<Student> linkedListStudent = new LinkedList<>(List.of(new Student("Anna Austin", 4.3), new Student("Brian Brown", 3.4), new Student("Catherine Clark", 4.7), new Student("David Davis", 2.9), new Student("Emma Evans", 4.9), new Student("Isabella Irving", 3.2), new Student("Grace Green", 3.9)));
        System.out.println(RED + linkedListStudent + RESET);
        removeStudents(linkedListStudent, 3.4);
        System.out.println("avgMark < 3.4 : " + linkedListStudent);
    }


    /**
     * Перебрать LinkedList и найти самую короткую строку.
     */
    public static String findShortestWord(List<String> strings) {
        System.out.println(YELLOW + "Перебрать LinkedList и найти самую короткую строку." + RESET);
        String shortestWord = strings.getFirst();
        for (String st : strings) {
            if (st.length() < shortestWord.length()) {
                shortestWord = st;
            }
        }
        return shortestWord;
    }

    /**
     * Перебрать LinkedList и объединить все строки в одну с использованием разделителя "|".
     */
    public static String combineAllWords(List<String> strings) {
        System.out.println(YELLOW + "Перебрать LinkedList и объединить все строки в одну с использованием разделителя |." + RESET);
        StringBuilder allWorlds = new StringBuilder(strings.getFirst());
        for (String st : strings) {
            allWorlds.append("|").append(st);
        }
        return allWorlds.toString();
    }

    /**
     * Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.
     */

    public static void removeStudents(List<Student> students, double avgMark) {
        System.out.println(YELLOW + "Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию." + RESET);
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAvgMark() < avgMark) {
                iterator.remove();
            }
        }
    }

    /**
     * Напишите метод, чтобы получить первое и последнее вхождение указанных элементов в связанном списке.
     * input: list = {1, 4, 3, 2, 1, 2, 2, 0}, element = 2 output: 3 (индекс первого вхождения), 6 (индекс последнего вхождения)
     */
    public static <T> int[] findFirstAndLast(List<T> list, T element) {
        System.out.println(YELLOW + "Напишите метод, чтобы получить первое и последнее вхождение указанных элементов в связанном списке." + RESET);
        return new int[]{list.indexOf(element), list.lastIndexOf(element)};
    }

    /**
     * Имеется лист. Написать метод, возвращающий этот же лист, в котором элементы расположены в обратном порядке.
     */
    public static <T> List<T> reverseList(List<T> list) {
        System.out.println(YELLOW + "Имеется лист. Написать метод, возвращающий этот же лист, в котором элементы расположены в обратном порядке." + RESET);
        List<T> reversedList = new LinkedList<>();
        for (T ob : list) {
            reversedList.addFirst(ob);
        }
        return reversedList;
    }

    /**
     * Проверить, содержит ли List<String> заданную строку и вернуть ее индекс. Если строка не найдена, вернуть -1.
     */
    public static int findString(List<String> strings, String target) {
        System.out.println(YELLOW + "Проверить, содержит ли List<String> заданную строку и вернуть ее индекс. Если строка не найдена, вернуть -1." + RESET);
        ListIterator<String> stringIterator = strings.listIterator();
        while (stringIterator.hasNext()) {
            if (stringIterator.next().equals(target)) {
                return stringIterator.previousIndex();
            }
        }
        return -1;
    }

    /**
     * Проверить, содержит ли List<String> хотя бы одну строку, которая начинается с заданного префикса.
     */
    public static boolean findStringsStartingWith(List<String> strings, String start) {
        System.out.println(YELLOW + "Проверить, содержит ли List<String> хотя бы одну строку, которая начинается с заданного префикса." + RESET);
        for (String string : strings) {
            if (string.startsWith(start)) {
                return true;
            }
        }
        return false;
    }
}
