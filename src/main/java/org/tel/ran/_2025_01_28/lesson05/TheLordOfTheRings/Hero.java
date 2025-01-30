package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Hero {

    private String name;

    private int health;

    private int power;

    private int defence;

    public Hero(String name, int health, int power, int defence) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.defence = defence;
    }

    public String getName() {
        return name;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public void attack (Hero enemy){
        int damage = getPower() / enemy.getDefence();
        enemy.takeDamage(damage, this);
        System.out.printf("%s attacks %s for %d damage.%n", name, enemy.getName(),damage);
    }

    protected void takeDamage(int damage, Hero enemy){
        health -= damage;
        System.out.printf("%s takes %d damage from %s.%n", name, damage, enemy.getName());
        if (health <= 0){
            System.out.printf("%s dies.%n",name);
        }else {
            System.out.printf("%s remains %d.%n", name, health);
        }
    }

}
