package org.tel.ran.homework06;

import java.util.Iterator;

import static org.tel.ran.textFormatting.*;

public class Main {
    public static void main(String[] args) {
        FixedSizeList<String> stringFixedSizeList = new FixedSizeList<>(10);
        stringFixedSizeList.add("Hello");
        stringFixedSizeList.add("Hi");
        stringFixedSizeList.add("Hey");
        stringFixedSizeList.add("Good morning");
        stringFixedSizeList.add("Good afternoon");
        stringFixedSizeList.add("Good evening");
        stringFixedSizeList.add(null);
        stringFixedSizeList.add("Bye");
        stringFixedSizeList.add("See you");
        stringFixedSizeList.add("Take care");
        //stringFixedSizeList.add("Farewell"); //MaxSizeExceededException
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);

        System.out.println("--------- CONTAINS ---------");
        System.out.println("stringFixedSizeList.contains(null) = " + stringFixedSizeList.contains(null));
        System.out.println("stringFixedSizeList.contains(\"Hi\") = " + stringFixedSizeList.contains("Hi"));
        System.out.println("stringFixedSizeList.contains(\"Take care\") = " + stringFixedSizeList.contains("Take care"));

        System.out.println("---------- REMOVE ----------");
        System.out.println("stringFixedSizeList.remove(1) = " + stringFixedSizeList.remove(1));
        System.out.println("stringFixedSizeList.contains(\"Hi\") = " + stringFixedSizeList.contains("Hi"));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        System.out.println("stringFixedSizeList.remove(8) = " + stringFixedSizeList.remove(8));
        System.out.println("stringFixedSizeList.contains(\"Take care\") = " + stringFixedSizeList.contains("Take care"));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        System.out.println("stringFixedSizeList.remove(Hey) = " + stringFixedSizeList.remove("Hey"));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        System.out.println("stringFixedSizeList.remove(null) = " + stringFixedSizeList.remove(null));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);

        System.out.println("-------- ADD BY INDEX --------");
        stringFixedSizeList.add(1, "Hey");
        System.out.println("stringFixedSizeList.add(1, \"Hey\")");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        stringFixedSizeList.add(6, "Farewell");
        System.out.println("stringFixedSizeList.add(6, \"Farewell\")");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        stringFixedSizeList.add(7, "Hello");
        System.out.println("stringFixedSizeList.add(7, \"Hello\")");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        stringFixedSizeList.add(5, null);
        System.out.println("stringFixedSizeList.add(7, null)");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        // stringFixedSizeList.remove("Hi"); //ElementNotFoundException

        System.out.println("-------- GET BY INDEX --------");
        System.out.println("stringFixedSizeList.get(0) = " + stringFixedSizeList.get(0));
        System.out.println("stringFixedSizeList.get(5) = " + stringFixedSizeList.get(5));
        System.out.println("stringFixedSizeList.get(stringFixedSizeList.size() - 1) = " + stringFixedSizeList.get(stringFixedSizeList.size() - 1));

        System.out.println("-------- SET BY INDEX --------");
        System.out.println("stringFixedSizeList.set(0,\"Hi\") = " + stringFixedSizeList.set(0, "Hi"));
        System.out.println("stringFixedSizeList.set(2,\"Hello\") = " + stringFixedSizeList.set(2, "Hello"));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);

        System.out.println("--------- INDEX OF ---------");
        System.out.println("stringFixedSizeList.indexOf(null) = " + stringFixedSizeList.indexOf(null));
        System.out.println("stringFixedSizeList.indexOf(\"Hello\") = " + stringFixedSizeList.indexOf("Hello"));
        System.out.println("stringFixedSizeList.lastIndexOf(\"Hello\") = " + stringFixedSizeList.lastIndexOf("Hello"));
        System.out.println("stringFixedSizeList.remove(2) = " + stringFixedSizeList.remove(2));
        System.out.println("stringFixedSizeList.indexOf(\"Hello\") = " + stringFixedSizeList.indexOf("Hello"));
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);


        System.out.println("--------- ITERATOR ---------");
        Iterator<String> stringIterator = stringFixedSizeList.iterator();
        // stringIterator.remove();  //OutOfRangeException
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        stringIterator.remove();
        System.out.println("stringIterator.remove()");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        System.out.println("stringIterator.next() = " + stringIterator.next());
        stringIterator.remove();
        System.out.println("stringIterator.remove()");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
        System.out.println("stringIterator.next() = " + stringIterator.next());
        // System.out.println("stringIterator.next() = " + stringIterator.next()); //OutOfRangeException

        System.out.println("--------- CLEAR ---------");
        stringFixedSizeList.clear();
        System.out.println("stringFixedSizeList.clear()");
        System.out.println(YELLOW + "stringFixedSizeList = " + stringFixedSizeList + RESET);
    }
}
