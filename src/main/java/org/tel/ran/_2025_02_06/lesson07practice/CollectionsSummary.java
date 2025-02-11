package org.tel.ran._2025_02_06.lesson07practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Структуры данных : класс
 * Array : int[], String[]
 * Dynamic Array : ArrayList
 * Linked List                 : Linked List
 * (One direction, first pos)  : (Bi direction, store first and last position)
 */

public class CollectionsSummary {
    public static void main(String[] args) {
        // Массив после создания нельзя изменить количество элементов
        // Сохраняет только однородные данные и работает с ними по одному принципу
        int[] ints = {1, 2, 3, 4, 5, 6, 3};
        int readFromArray = ints[2];
        String arrayAsString = Arrays.toString(ints);
        System.out.println(arrayAsString);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1); // 1
        integers.add(2); // 2
        integers.add(3); // 3
        integers.add(3); // 4
        integers.add(3); // 5
        integers.add(3); // 6
        integers.add(3); // 7
        integers.add(3); // 8
        integers.add(3); // 9
        // Метод проверки определил, что места нет и создал новый массив
        // в 1,5 раза больше, чем имеющийся, т. е. глвый массив размером 15
        // Далее все элементы из старого массива перекомпилировались в новый
        // и мы получили массив из 15 элементов, первые 10 уже заполнены
        // и в переменную integers, вместо старого массива, была присвоена
        // ссылка на новый массив, а старый будет удален garbage collector
        integers.add(3); // 10
        integers.add(3); // 11
        int readFromArrayList = integers.get(1);
        System.out.println(integers);

        // add(value) - fast(const)
        // 1 4 5 6 7 4 6 7 8 9 7 _ _ _
        // add(5)
        // 1 4 5 6 7 4 6 7 8 9 7 5 _ _

        // get(index) - fast(const)

        // add (index, value) - slow(linear)
        // 1 4 5 6 7 4 6 7 8 9 7 5 _ _
        // add(0,5) - все элементы будут сдвигаться враво,
        // 5 1 4 5 6 7 4 6 7 8 9 7 5 _

        LinkedList <Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(5);

        int readFromLinkedList = list.get(4);
        System.out.println(list);
        // 1 -> 3 -> 2 -> 4 -> 5
        // add(0,5) - fast(const)
        // add(9) - slow(linear)



    }
}
