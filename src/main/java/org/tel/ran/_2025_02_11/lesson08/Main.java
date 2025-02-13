package org.tel.ran._2025_02_11.lesson08;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(11 >> 1);

        MyArrayList<Integer> myArrayList = new MyArrayList<>(16);
        System.out.println(Arrays.toString(myArrayList.elementData) + " ");
        System.out.println(myArrayList);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        System.out.println(Arrays.toString(myArrayList.elementData));
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.add(14);
        myArrayList.add(15);
        System.out.println(Arrays.toString(myArrayList.elementData));

        myArrayList.remove(7);
        System.out.println(myArrayList);

        for (Integer num: myArrayList){
            System.out.print(num + " ");
        }
        System.out.println();
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);
        System.out.println(myLinkedList);
        myLinkedList.add(2,7);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.get(5));
        myLinkedList.set(1,9);
        System.out.println(myLinkedList);
        myLinkedList.remove(5);
        System.out.println(myLinkedList);
        Integer num = 4;
        myLinkedList.remove(num);
        System.out.println(myLinkedList);
    }
}
