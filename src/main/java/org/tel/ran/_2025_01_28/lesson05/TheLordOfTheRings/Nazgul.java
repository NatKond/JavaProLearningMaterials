package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidCounterDamageValueException;
import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidHealthException;

public class Nazgul extends Hero{

    private int counterDamage;

    public Nazgul(String name, int health, int power, int defence, int addDamage) {
        super(name, health, power, defence);
        setAddDamage(addDamage);
    }

    @Override
    public String toString() {
        return String.format("Nazgul %s has %d health.", getName(), getHealth());
    }

    @Override
    protected void takeDamage(int damage, Hero enemy) {
        super.takeDamage(damage, enemy);
        enemy.takeDamage(counterDamage,this);
    }

    @Override
    protected void setHealth(int health) {
        if (health >= 150 && health <= 180){
            super.setHealth(health);
        } else {
            throw new InvalidHealthException("Nazgul can't have " + health + " health. Nazgul health should be between 150 and 180.");
        }
    }

    private void setAddDamage(int counterDamage) {
        if (counterDamage > 1 && counterDamage <= 10) {
            this.counterDamage = counterDamage;
        } else {
            throw new InvalidCounterDamageValueException("Counter damage value can't be " + counterDamage + ". Counter damage value should be between 1 and 10.");
        }
    }
}
