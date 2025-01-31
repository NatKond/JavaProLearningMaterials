package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import java.util.Arrays;

public class Army {

    private String name;

    private Hero[] heroes;

    public Army(String name, Hero[] heroes) {
        this.name = name;
        this.heroes = heroes;
    }

    public Hero[] getHeroes() {
        return heroes;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        for (Hero hero: heroes){
            if (hero.isAlive()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(heroes);
    }

}
