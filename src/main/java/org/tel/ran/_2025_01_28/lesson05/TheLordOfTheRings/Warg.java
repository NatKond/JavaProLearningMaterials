package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Warg extends Hero{

    private int healthAmount;

    private final int healthMax;

    public Warg(String name, int health, int power, int defence, int healthAmount) {
        super(name, health, power, defence);
        healthMax = health;
        setHealthAmount(healthAmount);
    }

    @Override
    public void attack(Hero enemy) {
        heal();
        super.attack(enemy);
    }

    private void heal(){
        setHealth(getHealth() + healthAmount);
        if (getHealth() > healthMax){
            setHealth(healthMax);
        }
        System.out.printf("%s healed to %d health points.%n",getName(), getHealth());
    }

    private void setHealthAmount(int healthAmount) {
        this.healthAmount = healthAmount;
    }
}
