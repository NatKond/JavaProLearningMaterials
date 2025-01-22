package org.tel.ran.lesson03practice.part2;

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Cat("Fluffy","cat food", "in a house", 4);
        Animal animal2 = new Dog("Bob","dog food", "outside", false);
        Animal animal3 = new Horse("Thunderbolt", "horse food", "in a stable", 45);

        Animal[] animals = {animal1,animal2,animal3};

        for (Animal a:animals){
            System.out.println("---------- Vet --------");
            Veterinarian.treatAnimal(a);
        }
    }
}
