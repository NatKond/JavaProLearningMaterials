package org.tel.ran._2025_03_11.lesson14;

import java.util.ArrayList;
import java.util.List;

public class GoodYear {
    private List<String> seasons = new ArrayList<>();

    public GoodYear() {
    }

    public void addSeason(Season season){
        seasons.add(season.name());
    }

    @Override
    public String toString() {
        return "GoodYear{" +
                "seasons=" + seasons +
                '}';
    }
}
