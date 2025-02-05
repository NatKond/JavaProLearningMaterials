package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class BattleForMiddleEarth {

    public static final String BLUE = "\u001B[36m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        /*Human human1 = new Human("Human1",100,90,3, 3,25);
        Elf elf1 = new Elf("Elf1",80,80,2,100);
        Dwarf dwarf1 = new Dwarf("Dwarf1", 150,110,5,2);
        Orc orc1 = new Orc("Orc1", 105,90,2);
        Warg warg1 = new Warg("Warg1",80,80,2,10);
        Nazgul nazgul1 = new Nazgul("Nasgul1", 150,120,6,5);*/

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



        Army army1 = new Army("Middle Earth Defenders", new Hero[]{human1, human2, human3, elf1, dwarf1, dwarf2});
        Army army2 = new Army("Mordor Forces", new Hero[]{orc1, orc2, orc3, orc4, warg1, warg2, nazgul1, nazgul2});

        fight(army1,army2);
    }

    public static void fight1 (Army army1, Army army2) {
        System.out.println("Battle starts.");
        int countAttacks = 0;
        while (army1.isAlive() && army2.isAlive()) {
            countAttacks++;
            System.out.println("------------- " + countAttacks + " move. -------------");
            army1.attack(army2);
            army2.attack(army1);
        }
        System.out.println();

        if (army1.isAlive()) System.out.println(BLUE  + army1.getName() + " has won!" + RESET);
        if (army2.isAlive()) System.out.println(BLUE  + army2.getName() + " has won!" + RESET);
        System.out.println(army1.toString());
        System.out.println(army2.toString());
    }

    public static void fight(Army army1, Army army2){
        System.out.println("Battle starts.");
        int index1 = 0;
        int index2 = 0;
        boolean allHadAttacked1 = false;
        boolean allHadAttacked2 = false;
        int countMoves = 0;
        while (army1.isAlive() && army2.isAlive()){
            countMoves++;
            System.out.println("------------- " + countMoves + " move. -------------");

            index1 = army1.findAliveHeroIndex(index1);
            index2 = army2.findAliveHeroIndex(index2);

            Hero hero1 = army1.getHeroes()[index1];
            Hero hero2 = army2.getHeroes()[index2];
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
            if (index1 == army1.getHeroes().length) {
                System.out.printf("%s%s had attacked.%s%n",BLUE,army1.getName(),RESET);
                index1 = 0;
                allHadAttacked1 = true;
            }
            if (index2 == army2.getHeroes().length) {
                System.out.printf("%s%s had attacked.%s%n",BLUE,army2.getName(),RESET);
                index2 = 0;
                allHadAttacked2 = true;
            }

            if (allHadAttacked1 && allHadAttacked2) {
                allHadAttacked1 = false;
                allHadAttacked2 = false;
            }
        }
        System.out.println();

        if (army1.isAlive()) System.out.println(BLUE  + army1.getName() + " has won!" + RESET);
        if (army2.isAlive()) System.out.println(BLUE  + army2.getName() + " has won!" + RESET);
        System.out.println(army1.toString());
        System.out.println(army2.toString());
    }
}
