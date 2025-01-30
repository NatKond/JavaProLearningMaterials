package org.tel.ran._2025_01_28.lesson05.TheLordOfTheRings;

public class BattleForMiddleEarth {

    public static void main(String[] args) {
        Human human1 = new Human("Human1",100,60,3, 2,40);
        Elf elf1 = new Elf("Elf1",80,70,2,20);
        Dwarf dwarf1 = new Dwarf("Dwarf", 150,110,5,2);
        Orc orc1 = new Orc("Orc1", 110,100,2);
        Warg warg1 = new Warg("Warg1",80,90,2,7);
        Nazgul nazgul1 = new Nazgul("Nasgul1", 150,120,6,10);

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
        }




    }
}
