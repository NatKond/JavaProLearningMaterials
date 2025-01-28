package org.tel.ran._2025_01_28.lesson05practice;

public class Main {
    public static void main(String[] args) {
        Dolphin dolphin = new Dolphin();
        Fish fish = new Fish();
        Horse horse = new Horse();
        Lion lion = new Lion();

        Animal[] animals = {dolphin, fish, horse, lion};
        action(animals);

        Horse horse1 = new Horse();
        Animal horse2 = new Horse();
        ((Horse)horse2).jump();
    }

    public static void action(Animal... animals) {
        for (Animal animal : animals) {
            if (animal instanceof EarthAnimal earthAnimal) {
                earthAnimal.walk();
                if(animal instanceof Horse){
                    ((Horse) animal).jump();
                }
            } else if (animal instanceof MarineAnimal) {
                MarineAnimal marineAnimal = (MarineAnimal) animal;
                marineAnimal.swim();
            }
        }
    }
}
