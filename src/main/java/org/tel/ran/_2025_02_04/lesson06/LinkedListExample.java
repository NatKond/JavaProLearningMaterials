package org.tel.ran._2025_02_04.lesson06;

import java.awt.*;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(0);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);

        System.out.println("linkedList = " + linkedList);
        System.out.println("linkedList.peek() = " + linkedList.peek());
        System.out.println("linkedList.poll() = " + linkedList.poll());
        System.out.println("linkedList = " + linkedList);
        System.out.println("linkedList.peekFirst() = " + linkedList.peekFirst());
        System.out.println("linkedList.pollLast() = " + linkedList.pollLast());
        System.out.println("linkedList = " + linkedList);
    }
}
