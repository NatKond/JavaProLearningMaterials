package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import java.util.Arrays;

public class ArmyArray {

    private String name;

    private Hero[] heroes;

    public ArmyArray(String name, Hero[] heroes) {
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
        for (int i = startIndex; i < heroes.length; i++) {
            if (heroes[i].isAlive()) {
                return heroes[i];
            }
        }
        return null;
    }

    public int findAliveHeroIndex(int startIndex){
        for (int i = startIndex; i < heroes.length; i++) {
            if (heroes[i].isAlive()) {
                return i;
            }
        }
        return -1;
    }

    public void attack(ArmyArray enemies){
        if (!this.isAlive()) return;
        if (!enemies.isAlive()) return;
        int i = 0;
        int indexEnemies = 0;

        while (i < heroes.length && enemies.isAlive()){
            i = findAliveHeroIndex(i);
            if (i == -1) return;
            Hero hero1 = heroes[i];

            indexEnemies = enemies.findAliveHeroIndex(indexEnemies);
            if (indexEnemies == -1) {
                indexEnemies = enemies.findAliveHeroIndex(0);;
            }

            Hero hero2 = enemies.getHeroes()[indexEnemies];

            hero1.attack(hero2);
            i++;
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
