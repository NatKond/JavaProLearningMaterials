package org.tel.ran._2025_03_11.lesson14;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        System.out.println(season);
        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
        System.out.println(Season.FALL);
        System.out.println(SeasonConstant.SPRING);
        System.out.println(SeasonConstant.SUMMER);
        System.out.println(SeasonConstant.WINTER);
        System.out.println(SeasonConstant.FALL);

        String[] seasonConstants = {SeasonConstant.FALL, SeasonConstant.SUMMER, SeasonConstant.SPRING, SeasonConstant.WINTER};
        for (String s : seasonConstants) {
            System.out.println("s = " + s);
        }

        Season[] seasons = Season.values();
        for (Season s : seasons) {
            System.out.println("s = " + s);
        }

        System.out.println("seasons.length = " + seasons.length);
        System.out.println("season.ordinal() = " + season.ordinal());

        Season season1 = Season.valueOf("WINTER");
        System.out.println("season1 = " + season1);
        Season season2 = Season.valueOf(Season.class, "FALL");
        System.out.println("season2 = " + season2);

        Object o = new Object();
        System.out.println(o.getClass().getName() + "@" + Integer.toHexString(o.hashCode()));
        System.out.println("o = " + o);

        BadYear badYear = new BadYear();
        badYear.addSeason(SeasonConstant.SPRING);
        badYear.addSeason(SeasonConstant.SUMMER);
        badYear.addSeason(SeasonConstant.WINTER);
        badYear.addSeason(SeasonConstant.FALL);
        badYear.addSeason("ALOHA");
        System.out.println("badYear = " + badYear);

        GoodYear goodYear = new GoodYear();
        goodYear.addSeason(Season.SPRING);
        goodYear.addSeason(Season.SUMMER);
        goodYear.addSeason(Season.WINTER);
        goodYear.addSeason(Season.FALL);
        System.out.println("goodYear = " + goodYear);

        for (Country c : Country.values()) {
            System.out.println("c.toString() = " + c.toString());
            c.sayHello();
        }
    }
}
