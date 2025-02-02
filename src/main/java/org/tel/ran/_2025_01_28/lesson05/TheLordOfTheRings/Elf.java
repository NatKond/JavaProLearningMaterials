package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidChanceToDodgeExceptions;
import org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings.exceptions.InvalidHealthException;

import java.util.Random;

public class Elf extends Hero{

    private static final Random RANDOM = new Random();

    private int chanceToDodge;

    public Elf(String name, int health, int power, int defence, int chanceToDodge) {
        super(name, health, power, defence);
        setChanceToDodge(chanceToDodge);
    }

    @Override
    public String toString() {
        return String.format("Elf %s has %d health.", getName(), getHealth());
    }

    @Override
    protected void takeDamage(int damage, Hero enemy) {
        if (chanceToDodge > RANDOM.nextInt(101)){
            System.out.printf("%s%s%s has dodged.%n",YELLOW,getName(),RESET);
            return;
        }
        super.takeDamage(damage, enemy);
    }

    @Override
    protected void setHealth(int health) {
        if (health >= 80 && health <= 110){
            super.setHealth(health);
        } else {
            throw new InvalidHealthException("The health is invalid.");
        }
    }

    private void setChanceToDodge(int chanceToDodge) {
        if (chanceToDodge > 0 && chanceToDodge <= 100) {
            this.chanceToDodge = chanceToDodge;
        } else {
            throw new InvalidChanceToDodgeExceptions("Chance to dodge is invalid.");
        }
    }
}
