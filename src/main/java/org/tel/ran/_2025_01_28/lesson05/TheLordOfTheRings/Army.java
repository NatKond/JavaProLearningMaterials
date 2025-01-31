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

    public Hero findAliveHero(int startIndex){
        Hero hero = heroes[startIndex];
        if (!hero.isAlive()) {
            for (int i = startIndex + 1; i < heroes.length; i++) {
                if (heroes[i].isAlive()) {
                    hero = heroes[i];
                    break;
                }
            }
        }
        return hero;
    }

    public int findAliveHeroIndex(int startIndex){
        Hero hero = heroes[startIndex];
        int index = startIndex;
        if (!hero.isAlive()) {
            for (int i = startIndex + 1; i < heroes.length; i++) {
                if (heroes[i].isAlive()) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public void attack(Army enemies){
        int indexEnemies = 0;
        for (int i = 0; i < heroes.length; i++) {
            Hero hero1 = this.findAliveHero(i);
            Hero hero2 = enemies.findAliveHero(indexEnemies);
            hero1.attack(hero2);
            indexEnemies++;
            if (indexEnemies == enemies.getHeroes().length) {
                indexEnemies = 0;
            }
        }
        /* for (Hero hero1 : heroes) {

            if (!hero1.isAlive()) continue;

            Hero hero2 = enemies.getHeroes()[indexEnemies];

            while (!hero2.isAlive() && indexEnemies < enemies.getHeroes().length - 1) {
                hero2 = enemies.getHeroes()[++indexEnemies];
            }
            if (!hero2.isAlive()) break;

            hero1.attack(hero2);

            indexEnemies++;

            if (indexEnemies == enemies.getHeroes().length) {
                indexEnemies = 0;
            }
        }*/
    }

    @Override
    public String toString() {
        return Arrays.toString(heroes);
    }

}
