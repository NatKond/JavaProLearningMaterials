package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Dwarf extends Hero{

    private double armorMultiplier;

    public Dwarf(String name, int health, int power, int defence, double armorMultiplier) {
        super(name, health, power, defence);
        setArmorMultiplier(armorMultiplier);
    }

    @Override
    public int getDefence() {
        return (int)(super.getDefence() * armorMultiplier);
    }

    private void setArmorMultiplier(double armorMultiplier) {
        if (armorMultiplier > 1.0 && armorMultiplier <= 5) {
            this.armorMultiplier = armorMultiplier;
        } else {
            throw new IllegalArgumentException("Armor multiplier is invalid.");
        }
    }
}
