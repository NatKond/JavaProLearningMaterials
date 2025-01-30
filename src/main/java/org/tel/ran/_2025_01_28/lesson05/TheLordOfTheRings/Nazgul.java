package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

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
            throw new IllegalArgumentException("The health is invalid.");
        }
    }

    private void setAddDamage(int counterDamage) {
        if (counterDamage > 1 && counterDamage <= 10) {
            this.counterDamage = counterDamage;
        } else {
            throw new IllegalArgumentException("Counter damage value is invalid.");
        }
    }
}
