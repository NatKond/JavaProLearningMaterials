package org.tel.ran._2025_02_25.lesson12practice;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s1 = "SSSS SSS";
        boolean matches = Pattern.matches ("[A-Z]{4}[-\\s]? [A-Z]{3}", s1) ;
        System.out.println(matches);

        String s2 = "1234567";
        String s3 = "123-4567";
        String s4 = "123 5678";
        String regex = "\\d{3}[-\\s]?\\d{4}";

        System.out.println(Pattern.matches(regex,s2));
        System.out.println(Pattern.matches(regex,s3));
        System.out.println(Pattern.matches(regex,s4));
    }
}
