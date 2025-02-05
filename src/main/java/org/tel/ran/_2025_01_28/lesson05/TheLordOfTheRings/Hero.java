package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Hero {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREY = "\u001B[90m";

    public static final String YELLOW_BG = "\u001B[43m";
    public static final String PURPLE_BG = "\u001B[45m";

    public static final String BOLD = "\u001B[1m";    // Жирный

    private String name;

    private int health;

    private int power;

    private int defence;

    public Hero(String name, int health, int power, int defence) {
        this.name = name;
        setHealth(health);
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

    public boolean isAlive() {
        return (health != 0);
    }

    public void attack (Hero enemy){
        int damage = getPower() / enemy.getDefence();
        System.out.printf("%s%s%s attacks %s for %d damage.%s%n", getBackgroundColor(this), BOLD,name, enemy.getName(), damage, RESET);
        //System.out.printf("%s attacks %s for %d damage.%n", name, enemy.getName(),damage);
        enemy.takeDamage(damage, this);
    }

    protected void takeDamage(int damage, Hero enemy){
        if (health == 0) {
            System.out.printf("%s cannot be damaged by %s. He is already dead.%n", name, enemy.getName());
            return;
        }

        health -= damage;
        System.out.printf("%s%s%s takes %s%d%s damage from %s%s%s.%n",getNameColor(this), name,RESET,RED, damage,RESET, getNameColor(enemy), enemy.getName(),RESET);
        if (health <= 0){
            health = 0;
            System.out.printf("%s%s%s dies.%n",GREY, name,RESET);
        }else {
            System.out.printf("%s%s%s remains %s%d%s health points.%n",getNameColor(this), name, RESET, GREEN, health,RESET);
        }
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected String getNameColor(Hero hero) {
        if (hero instanceof Human || hero instanceof Elf || hero instanceof Dwarf) {
            return YELLOW;
        } else if (hero instanceof Orc || hero instanceof Warg || hero instanceof Nazgul) {
            return PURPLE;
        }
        return RESET;
    }

    protected static String getBackgroundColor(Hero hero) {
        if (hero instanceof Human || hero instanceof Elf || hero instanceof Dwarf) {
            return YELLOW_BG;
        } else if (hero instanceof Orc || hero instanceof Warg || hero instanceof Nazgul) {
            return PURPLE_BG;
        }
        return RESET;
    }
}
