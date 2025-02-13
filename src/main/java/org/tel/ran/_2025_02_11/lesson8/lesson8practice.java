package org.tel.ran._2025_02_11.lesson8;

import java.util.*;

public class lesson8practice {
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
