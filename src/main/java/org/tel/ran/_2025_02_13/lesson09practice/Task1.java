package org.tel.ran._2025_02_13.lesson09practice;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String str = "dssireuauoiwrutdslkjf.,xcmkdfjghlskfj;slk;awr;oksd;lfgm";
        System.out.println("getUniqueCount(str) = " + getUniqueCount(str));
    }

    public static int getUniqueCount(String string){
        Set <Character> characters = new HashSet<>();
        for (char c:string.toCharArray()){
            characters.add(c);
        }
        return characters.size();
    }
}
