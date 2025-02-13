package org.tel.ran._2025_02_11.lesson08practice;

public class CustomListApp {
    public static void main(String[] args) {
        // 1 3 4 3 5
        MyNode one = new MyNode(1);
        MyNode two = new MyNode(3);
        MyNode three = new MyNode(4);
        MyNode four = new MyNode(3);
        MyNode five = new MyNode(5);

        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);

        MyNode current = one;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }

        CustomList customList = new CustomList(one);
        System.out.println(customList);
    }
}
