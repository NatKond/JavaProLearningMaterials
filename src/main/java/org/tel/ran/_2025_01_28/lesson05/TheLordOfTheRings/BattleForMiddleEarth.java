package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class BattleForMiddleEarth {

    public static final String BLUE = "\u001B[36m";

    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        Human human1 = new Human("Human1",100,90,3, 2,25);
        Elf elf1 = new Elf("Elf1",80,80,2,40);
        Dwarf dwarf1 = new Dwarf("Dwarf", 150,110,5,2.5);
        Orc orc1 = new Orc("Orc1", 105,90,2);
        Warg warg1 = new Warg("Warg1",80,80,2,10);
        Nazgul nazgul1 = new Nazgul("Nasgul1", 150,120,6,5);

        Army army1 = new Army("MiddleEarthDefenders ", new Hero[]{human1,elf1,dwarf1});
        Army army2 = new Army("MordorForces", new Hero[]{orc1,nazgul1});

        fight(army1,army2);
        /*
        int count = 1;

        while ((human1.getHealth() != 0 || elf1.getHealth() != 0 || dwarf1.getHealth() != 0) && (orc1.getHealth() != 0 || warg1.getHealth() != 0 || nazgul1.getHealth() != 0)){
            if (human1.getHealth() != 0 && orc1.getHealth() != 0) {
                System.out.print(count + ". ");
                human1.attack(orc1);
                count++;
            } else if (human1.getHealth() != 0 && warg1.getHealth() != 0) {
                System.out.print(count + ". ");
                human1.attack(warg1);
                count++;
            } else if (human1.getHealth() != 0 && nazgul1.getHealth() != 0) {
                System.out.print(count + ". ");
                human1.attack(nazgul1);
                count++;
            }

            if (elf1.getHealth() != 0 && warg1.getHealth() != 0) {
                System.out.print(count + ". ");
                elf1.attack(warg1);
                count++;
            } else if (elf1.getHealth() != 0 && orc1.getHealth() != 0){
                System.out.print(count + ". ");
                elf1.attack(orc1);
                count++;
            } else if (elf1.getHealth() != 0 && nazgul1.getHealth() != 0) {
                System.out.print(count + ". ");
                elf1.attack(nazgul1);
                count++;
            }

            if (dwarf1.getHealth() != 0 && nazgul1.getHealth() != 0) {
                System.out.print(count + ". ");
                dwarf1.attack(nazgul1);
                count++;
            } else if (dwarf1.getHealth() != 0 && orc1.getHealth() != 0) {
                System.out.print(count + ". ");
                dwarf1.attack(orc1);
                count++;
            } else if (dwarf1.getHealth() != 0 && warg1.getHealth() != 0) {
                System.out.print(count + ". ");
                dwarf1.attack(warg1);
                count++;
            }

            if (orc1.getHealth() != 0 && human1.getHealth() != 0) {
                System.out.print(count + ". ");
                orc1.attack(human1);
                count++;
            } else if (orc1.getHealth() != 0 && elf1.getHealth() != 0) {
                System.out.print(count + ". ");
                orc1.attack(elf1);
                count++;
            } else if (orc1.getHealth() != 0 && dwarf1.getHealth() != 0) {
                System.out.print(count + ". ");
                orc1.attack(dwarf1);
                count++;
            }

            if (warg1.getHealth() != 0 && elf1.getHealth() != 0) {
                System.out.print(count + ". ");
                warg1.attack(elf1);
                count++;
            } else if (warg1.getHealth() != 0 && human1.getHealth() != 0) {
                System.out.print(count + ". ");
                warg1.attack(human1);
                count++;
            } else if (warg1.getHealth() != 0 && dwarf1.getHealth() != 0) {
                System.out.print(count + ". ");
                warg1.attack(dwarf1);
                count++;
            }

            if (nazgul1.getHealth() != 0 && dwarf1.getHealth() != 0) {
                System.out.print(count + ". ");
                nazgul1.attack(dwarf1);
                count++;
            } else if (nazgul1.getHealth() != 0 && human1.getHealth() != 0) {
                System.out.print(count + ". ");
                nazgul1.attack(human1);
                count++;
            } else if (nazgul1.getHealth() != 0 && elf1.getHealth() != 0) {
                System.out.print(count + ". ");
                nazgul1.attack(elf1);
                count++;
            }
        }*/
    }

    public void fight1 (Army army1, Army army2) {
        System.out.println("Battle starts.");
        int index1 = 0;
        int index2 = 0;
        while (army1.isAlive() && army1.isAlive()) {
            for (int i = 0; i < army1.getHeroes().length; i++) {

            }
        }
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
            System.out.println("------------ " + countMoves + " move. ------------");
            Hero hero1 = army1.getHeroes()[index1];
            Hero hero2 = army2.getHeroes()[index2];
            if (!hero1.isAlive()) {
                for (int i = index1 + 1; i < army1.getHeroes().length; i++) {
                    if (army1.getHeroes()[i].isAlive()) {
                        hero1 = army1.getHeroes()[i];
                        index1 = i;
                        break;
                    }
                }
            }
            if (!hero1.isAlive()) {
                for (int i = index2 + 1; i < army2.getHeroes().length; i++) {
                    if (army2.getHeroes()[i].isAlive()) {
                        hero2 = army2.getHeroes()[i];
                        index2 = i;
                        break;
                    }
                }
            }

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
                System.out.printf("%s%s had attacked.%s%n",BLUE,army1.getName(),RESET);
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
    }
}
