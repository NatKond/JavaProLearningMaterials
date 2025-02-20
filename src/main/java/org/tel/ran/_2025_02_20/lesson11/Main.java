package org.tel.ran._2025_02_20.lesson11;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "1");
        integerStringMap.put(2, "2");
        integerStringMap.put(3, "3");
        integerStringMap.put(4, "4");
        integerStringMap.put(5, "5");
        integerStringMap.put(6, "6");
        integerStringMap.put(7, "7");
        integerStringMap.put(8, "8");
        integerStringMap.put(9, "9");
        integerStringMap.put(10, "10");
        integerStringMap.put(12, "11");
        integerStringMap.put(13, "12");
        integerStringMap.put(14, "13");
        integerStringMap.put(15, "14");
        integerStringMap.put(16, "15");

        /*Class<HashMap<Integer, String>> hashMapClass = (Class<HashMap<Integer, String>>) integerStringMap.getClass();
        Field table = hashMapClass.getDeclaredField("table");
        table.setAccessible(true);

        Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) ((Object[]) table.get(integerStringMap))[0];
        Class<?> modeClass = entry.getClass();
        Field next = modeClass.getDeclaredField("next");
        next.setAccessible(true);
        System.out.println(Arrays.toString((Object[])table.get(integerStringMap)));
        System.out.println(entry);
        System.out.println(next.get(entry));*/
    }
}
