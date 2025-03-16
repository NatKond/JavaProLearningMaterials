package org.tel.ran._2025_03_11.lesson14;

import java.util.ArrayList;
import java.util.List;

public class BadYear {
    private List<String> seasons = new ArrayList<>();

    public void addSeason(String season){
        seasons.add(season);
    }

    @Override
    public String toString() {
        return "BadYear{" +
                "seasons=" + seasons +
                '}';
    }
}
