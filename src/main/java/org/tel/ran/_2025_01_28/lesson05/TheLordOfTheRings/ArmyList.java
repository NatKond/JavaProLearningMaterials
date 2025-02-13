package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArmyList {

    private String name;

    private List <Hero> heroes;

    Iterator<Hero> armyIterator;

    public ArmyList(String name, List<Hero> heroes) {
        this.name = name;
        this.heroes = heroes;
        armyIterator = heroes.iterator();
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return !heroes.isEmpty();
    }

    public void removeFallen(){
        armyIterator = heroes.iterator();
        while (armyIterator.hasNext()){
            if (!armyIterator.next().isAlive()){
                armyIterator.remove();
            }
        }
    }

    public Hero getNextHero(){
        if (!armyIterator.hasNext()) {
            armyIterator = heroes.iterator();
        }
        return armyIterator.next();
    }

    public void attack(ArmyList enemyArmy){
        for (Hero hero : heroes){
            if (!enemyArmy.isAlive()){
                break;
            }
            hero.attack(enemyArmy.getNextHero());
            enemyArmy.removeFallen();
        }
    }
    @Override
    public String toString() {
        return (heroes).toString();
    }
}
