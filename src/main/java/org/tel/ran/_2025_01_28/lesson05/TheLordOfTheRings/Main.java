package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class Main {
    public static void main(String[] args) {
        Nazgul nazgul1 = new Nazgul("Nasgul1", 100,80,10,10);
        Elf elf1 = new Elf("Elf1",80,50,5,30);


        elf1.attack(nazgul1);
    }
}
