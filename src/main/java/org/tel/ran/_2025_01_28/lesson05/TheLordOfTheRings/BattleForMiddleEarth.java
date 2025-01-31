package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class BattleForMiddleEarth {

    public static final String BLUE = "\u001B[36m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Human human1 = new Human("Human1",100,90,3, 2,25);
        Elf elf1 = new Elf("Elf1",80,80,2,40);
        Dwarf dwarf1 = new Dwarf("Dwarf1", 150,110,5,2.5);
        Orc orc1 = new Orc("Orc1", 105,90,2);
        Warg warg1 = new Warg("Warg1",80,80,2,10);
        Nazgul nazgul1 = new Nazgul("Nasgul1", 150,120,6,5);

        Army army1 = new Army("Middle Earth Defenders", new Hero[]{human1, elf1, dwarf1});
        Army army2 = new Army("Mordor Forces", new Hero[]{nazgul1, orc1, warg1});

        fight1(army1,army2);
    }

    public static void fight1 (Army army1, Army army2) {
        System.out.println("Battle starts.");
        int countMoves = 0;
        while (army1.isAlive() && army2.isAlive()) {
            countMoves++;
            System.out.println("------------- " + countMoves + " move. -------------");
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
