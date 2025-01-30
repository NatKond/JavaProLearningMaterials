package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Orc extends Hero{

    private final int healthMax;

    public Orc(String name, int health, int power, int defence) {
        super(name, health, power, defence);
        healthMax = health;
    }

    @Override
    public int getPower() {
        double powerMultiplier = (1 - (double) getHealth()/healthMax) + 1;
        return (int) (super.getPower() * powerMultiplier);
    }
}
