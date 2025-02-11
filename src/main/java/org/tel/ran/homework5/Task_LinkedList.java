package org.tel.ran.homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task_LinkedList {
    public static void main(String[] args) {
        List<String> linkedListStrings = new LinkedList<>(List.of("Hello", "Bye", "Goodbye", "Ay","Afternoon","Bye", "Hello"));
        System.out.println(findShortestWord(linkedListStrings));
        System.out.println(combineAllWords(linkedListStrings));
        List<Integer> linkedListInteger = new LinkedList<>(List.of(5,2,7,1,3,4,8,3));
        System.out.println(reverseList(linkedListStrings));
        System.out.println(reverseList(linkedListInteger));
        System.out.println(Arrays.toString(findFirstAndLast(linkedListStrings, "Bye")));
        System.out.println(Arrays.toString(findFirstAndLast(linkedListInteger, 3)));

    }


    /**
     * Перебрать LinkedList и найти самую короткую строку.
     */
    public static String findShortestWord(List<String> strings){
        String shortestWord = strings.getFirst();
        for (String st:strings){
            if (st.length() < shortestWord.length()){
                shortestWord = st;
            }
        }
        return shortestWord;
    }
    /**
     * Перебрать LinkedList и объединить все строки в одну с использованием разделителя "|".
     */
    public static String combineAllWords(List<String> strings){
        StringBuilder allWorlds = new StringBuilder(strings.getFirst());
        for (String st:strings){
            allWorlds.append("|").append(st);
        }
        return allWorlds.toString();
    }

    /**
     * Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовлетворяющие определенному условию.
     */

    /**
     * Напишите метод, чтобы получить первое и последнее вхождение указанных элементов в связанном списке.
     * input: list = {1, 4, 3, 2, 1, 2, 2, 0}, element = 2 output: 3 (индекс первого вхождения), 6 (индекс последнего вхождения)
     */
    public static int[] findFirstAndLast(List list, Object element){
        return new int[]{list.indexOf(element), list.lastIndexOf(element)};
    }

    /**
     * Имеется лист. Написать метод, возвращающий этот же лист, в котором элементы расположены в обратном порядке.
     */
    public static List reverseList(List list){
        List reversedList = new LinkedList();
        for (Object ob: list){
            reversedList.addFirst(ob);
        }
        return reversedList;
    }

    /**
     * Имеется лист. Написать метод, возвращающий этот же лист, в котором элементы расположены в обратном порядке.
     */




}
