package org.tel.ran._2025_02_04.lesson06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
    public static void main(String[] args) {
        Map hashMap = new HashMap();

        hashMap.put("Ivan", "+22222");
        hashMap.put("Sidr", "+44444");
        hashMap.put("Pert", "+33333");
        hashMap.put("Ivan", "+55555");
        System.out.println("hashMap = " + hashMap);

        Set entries = hashMap.entrySet();

        for (Object obj : entries){
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("entry.getKey() = " + entry.getKey());
            System.out.println("entry.getValue() = " + entry.getValue());
            System.out.println(entry.toString());
        }
    }
}
