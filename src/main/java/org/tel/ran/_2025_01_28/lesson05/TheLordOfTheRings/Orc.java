package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidHealthException;

public class Orc extends Hero{

    private final int healthMax;

    public Orc(String name, int health, int power, int defence) {
        super(name, health, power, defence);
        healthMax = health;
    }

    @Override
    public String toString() {
        return String.format("Orc %s has %d health.", getName(), getHealth());
    }

    @Override
    protected void setHealth(int health) {
        if (health >= 100 && health <= 130){
            super.setHealth(health);
        } else {
            throw new InvalidHealthException("Orc can't have " + health + " health. Orc health should be between 100 and 130.");
        }
    }

    @Override
    public int getPower() {
        double powerMultiplier = (1 - (double) getHealth()/healthMax) + 1;
        return (int) (super.getPower() * powerMultiplier);
    }
}
