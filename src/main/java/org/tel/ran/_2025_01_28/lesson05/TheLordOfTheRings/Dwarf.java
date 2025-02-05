package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidArmorMultiplierException;
import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidHealthException;

public class Dwarf extends Hero{

    private double armorMultiplier;

    public Dwarf(String name, int health, int power, int defence, double armorMultiplier) {
        super(name, health, power, defence);
        setArmorMultiplier(armorMultiplier);
    }

    @Override
    public String toString() {
        return String.format("Dwarf %s has %d health.", getName(), getHealth());
    }

    @Override
    public int getDefence() {
        return (int)(super.getDefence() * armorMultiplier);
    }

    @Override
    protected void setHealth(int health) {
        if (health >= 120 && health <= 150){
            super.setHealth(health);
        } else {
            throw new InvalidHealthException("Dwarf can't have " + health + " health. Dwarf health should be between 120 and 150.");
        }
    }

    private void setArmorMultiplier(double armorMultiplier) {
        if (armorMultiplier > 1.0 && armorMultiplier <= 5) {
            this.armorMultiplier = armorMultiplier;
        } else {
            throw new InvalidArmorMultiplierException("The armor multiplier can't be " + armorMultiplier + ". The armor multiplier should be between 1 and 5.");
        }
    }
}
