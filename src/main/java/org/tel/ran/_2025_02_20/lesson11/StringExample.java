package org.tel.ran._2025_02_20.lesson11;

import java.util.Arrays;

public class StringExample {
    public static void main(String[] args) {
        String str = "Thanks for the detailed reply! A late check-in won’t be necessary since we arrive in the morning.";
        String[] strings = str.split("[\\s\\p{Punct}]+");
        System.out.println("strings = " + Arrays.toString(strings));
    }
}
