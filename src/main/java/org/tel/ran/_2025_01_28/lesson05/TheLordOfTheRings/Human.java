package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import java.util.Random;

public class Human extends Hero{

    private static final Random RANDOM = new Random();

    private double damageMultiplier;

    private int chanceOfCriticalDamage;

    public Human(String name, int health, int power, int defence, double damageMultiplier, int chanceOfCriticalDamage) {
        super(name, health, power, defence);
        setDamageMultiplier(damageMultiplier);
        setChanceOfCriticalDamage(chanceOfCriticalDamage);
    }

    @Override
    public String toString() {
        return String.format("Human %s has %d health.", getName(), getHealth());
    }

    @Override
    public void attack(Hero enemy) {
        int damage;
        if (chanceOfCriticalDamage > RANDOM.nextInt(101)){
            damage = (int) (getPower() * damageMultiplier / enemy.getDefence());
            enemy.takeDamage(damage, getName());
            System.out.printf("%s attacks %s for %d damage", getName(), enemy.getName(),damage);
        } else super.attack(enemy);
    }

    private void setDamageMultiplier(double damageMultiplier) {
        if (damageMultiplier > 1.0 && damageMultiplier <= 5){
            this.damageMultiplier = damageMultiplier;
        } else {
            throw new IllegalArgumentException("Value of damage multiplier is invalid.");
        }
    }

    private void setChanceOfCriticalDamage(int chanceOfCriticalDamage) {
        if (chanceOfCriticalDamage > 0 && chanceOfCriticalDamage <= 100) {
            this.chanceOfCriticalDamage = chanceOfCriticalDamage;
        } else {
            throw new IllegalArgumentException("Chance of critical damage is invalid.");
        }
    }
}
