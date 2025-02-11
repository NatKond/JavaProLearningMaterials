package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

import java.util.ArrayList;
import java.util.List;

public class BattleForMiddleEarth {

    public static final String BLUE = "\u001B[36m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Human human = new Human("Human1",100,90,3, 3,25);
        Elf elf = new Elf("Elf1",80,80,2,100);
        Dwarf dwarf = new Dwarf("Dwarf1", 150,110,5,2);
        Orc orc = new Orc("Orc1", 105,90,2);
        Warg warg = new Warg("Warg1",80,80,2,10);
        Nazgul nazgul = new Nazgul("Nasgul1", 150,120,6,5);

        Human human1 = new Human("Aragorn", 100, 90, 3, 2, 25);
        Human human2 = new Human("Boromir", 110, 85, 4, 3, 20);
        Human human3 = new Human("Theoden", 105, 92, 3, 2, 30);
        Human human4 = new Human("Eomer", 105, 88, 4, 3, 28);

        Elf elf1 = new Elf("Legolas", 80, 80, 2, 40);
        Elf elf2 = new Elf("Thranduil", 85, 75, 3, 35);
        Elf elf3 = new Elf("Galadriel", 90, 85, 2, 50);
        Elf elf4 = new Elf("Elrond", 95, 82, 3, 45);

        Dwarf dwarf1 = new Dwarf("Gimli", 150, 110, 5, 2.5);
        Dwarf dwarf2 = new Dwarf("Dain Ironfoot", 130, 115, 6, 2.8);
        Dwarf dwarf3 = new Dwarf("Thorin Oakenshield", 145, 108, 5, 2.7);
        Dwarf dwarf4 = new Dwarf("Balin", 145, 105, 5, 2.4);

        Orc orc1 = new Orc("Azog", 105, 90, 2);
        Orc orc2 = new Orc("Bolg", 110, 95, 3);
        Orc orc3 = new Orc("Gothmog", 100, 88, 2);
        Orc orc4 = new Orc("Uglúk", 102, 89, 2);

        Warg warg1 = new Warg("Sharptooth", 80, 80, 2, 10);
        Warg warg2 = new Warg("Bloodfang", 85, 85, 3, 5);

        Nazgul nazgul1 = new Nazgul("Witch-King of Angmar", 150, 120, 6, 5);
        Nazgul nazgul2 = new Nazgul("Khamûl", 165, 115, 5, 4);

        ArmyArray armyArray1 = new ArmyArray("Middle Earth Defenders", new Hero[]{human1, human2, human3, elf1, dwarf1, dwarf2});
        ArmyArray armyArray2 = new ArmyArray("Mordor Forces", new Hero[]{orc1, orc2, orc3, orc4, warg1, warg2, nazgul1, nazgul2});

        // fight(armyArray1, armyArray2);

        ArmyList armyList1 = new ArmyList("Middle Earth Defenders", new ArrayList<>(List.of(human1, human2, human3, elf1, dwarf1, dwarf2)));
        ArmyList armyList2 = new ArmyList("Mordor Forces", new ArrayList<>(List.of(orc1, orc2, orc3, orc4, warg1, warg2, nazgul1, nazgul2)));


        fight(armyList1, armyList2);
    }

    public static void fight(ArmyList armyList1,  ArmyList armyList2){
        System.out.println("Battle starts.");
        int countAttacks = 0;
        while (armyList1.isAlive() && armyList2.isAlive()) {
            countAttacks++;
            System.out.println("------------- " + countAttacks + " move. -------------");
            armyList1.attack(armyList2);
            armyList2.attack(armyList1);
        }
        if (armyList1.isAlive()) System.out.println(BLUE  + armyList1.getName() + " has won!" + RESET);
        if (armyList2.isAlive()) System.out.println(BLUE  + armyList2.getName() + " has won!" + RESET);
        System.out.println(armyList1);
        System.out.println(armyList2);
    }


    public static void fight1 (ArmyArray armyArray1, ArmyArray armyArray2) {
        System.out.println("Battle starts.");
        int countAttacks = 0;
        while (armyArray1.isAlive() && armyArray2.isAlive()) {
            countAttacks++;
            System.out.println("------------- " + countAttacks + " move. -------------");
            armyArray1.attack(armyArray2);
            armyArray2.attack(armyArray1);
        }
        System.out.println();

        if (armyArray1.isAlive()) System.out.println(BLUE  + armyArray1.getName() + " has won!" + RESET);
        if (armyArray2.isAlive()) System.out.println(BLUE  + armyArray2.getName() + " has won!" + RESET);
        System.out.println(armyArray1);
        System.out.println(armyArray2);
    }

    public static void fight(ArmyArray armyArray1, ArmyArray armyArray2){
        System.out.println("Battle starts.");
        int index1 = 0;
        int index2 = 0;
        boolean allHadAttacked1 = false;
        boolean allHadAttacked2 = false;
        int countMoves = 0;
        while (armyArray1.isAlive() && armyArray2.isAlive()){
            countMoves++;
            System.out.println("------------- " + countMoves + " move. -------------");

            index1 = armyArray1.findAliveHeroIndex(index1);
            index2 = armyArray2.findAliveHeroIndex(index2);

            Hero hero1 = armyArray1.getHeroes()[index1];
            Hero hero2 = armyArray2.getHeroes()[index2];
            /*
            if (!hero1.isAlive()) {
                for (int i = index1 + 1; i < army1.getHeroes().length; i++) {
                    if (army1.getHeroes()[i].isAlive()) {
                        hero1 = army1.getHeroes()[i];
                        index1 = i;
                        break;
                    }
                }
            }
            if (!hero2.isAlive()) {
                for (int i = index2 + 1; i < army2.getHeroes().length; i++) {
                    if (army2.getHeroes()[i].isAlive()) {
                        hero2 = army2.getHeroes()[i];
                        index2 = i;
                        break;
                    }
                }
            }
            */
            if (!allHadAttacked1) hero1.attack(hero2);
            if (!allHadAttacked2) hero2.attack(hero1);
            index1++;
            index2++;
            if (index1 == armyArray1.getHeroes().length) {
                System.out.printf("%s%s had attacked.%s%n",BLUE, armyArray1.getName(),RESET);
                index1 = 0;
                allHadAttacked1 = true;
            }
            if (index2 == armyArray2.getHeroes().length) {
                System.out.printf("%s%s had attacked.%s%n",BLUE, armyArray2.getName(),RESET);
                index2 = 0;
                allHadAttacked2 = true;
            }

            if (allHadAttacked1 && allHadAttacked2) {
                allHadAttacked1 = false;
                allHadAttacked2 = false;
            }
        }
        System.out.println();

        if (armyArray1.isAlive()) System.out.println(BLUE  + armyArray1.getName() + " has won!" + RESET);
        if (armyArray2.isAlive()) System.out.println(BLUE  + armyArray2.getName() + " has won!" + RESET);
        System.out.println(armyArray1.toString());
        System.out.println(armyArray2.toString());
    }
}
