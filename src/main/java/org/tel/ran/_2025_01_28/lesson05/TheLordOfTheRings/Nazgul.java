package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Nazgul extends Hero{

    private int addDamage;

    public Nazgul(String name, int health, int power, int defence, int addDamage) {
        super(name, health, power, defence);
        setAddDamage(addDamage);
    }

    @Override
    protected void takeDamage(int damage, Hero enemy) {
        super.takeDamage(damage, enemy);
        enemy.takeDamage(addDamage,this);
    }

    private void setAddDamage(int addDamage) {
        this.addDamage = addDamage;
    }
}
