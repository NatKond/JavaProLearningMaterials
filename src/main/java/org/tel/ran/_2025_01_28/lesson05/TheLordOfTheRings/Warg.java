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
    public String toString() {
        return String.format("Warg %s has %d health.", getName(), getHealth());
    }

    @Override
    public void attack(Hero enemy) {
        super.attack(enemy);
        heal();
    }

    @Override
    protected void setHealth(int health) {
        if (health >= 80 && health <= 100){
            super.setHealth(health);
        } else {
            throw new IllegalArgumentException("The health is invalid.");
        }
    }

    protected void heal(){
        super.setHealth(getHealth() + healthAmount);
        System.out.printf("%s%s%s heals to %s%d%s health points.%n",PURPLE,getName(),RESET, GREEN, getHealth(),RESET);
        if (getHealth() > healthMax){
            setHealth(healthMax);
        }
    }

    private void setHealthAmount(int healthAmount) {
        if (healthAmount > 1 && healthAmount <= 10) {
            this.healthAmount = healthAmount;
        } else {
            throw new IllegalArgumentException("Health amount to heal is invalid.");
        }
    }
}
