package org.tel.ran._2025_02_06.lesson07;

import java.util.ArrayList;
import java.util.List;

public class WildCardExample {
    public static void main(String[] args) {
        Animal[] animals = {new Animal(), new Animal(), new Animal()};
        test(animals);

        Dog[] dogs = {new Dog(), new Dog(), new Dog()};
        test(dogs);

        ArrayList <Animal> animalList = new ArrayList<>(List.of(new Animal(), new Animal(), new Animal()));
        List <Dog> dogList = new ArrayList<>(List.of(new Dog(),new Dog(),new Dog()));
        List <Object> objects = new ArrayList<>(List.of(new Object(), new Object(),new Object()));

        test(animalList);
        test(dogList);
        testObj(objects);
    }

    public static void test(Animal[] animals){
        for (Animal animal:animals){
            System.out.println(animal);
        }
    }

    public static void test(List<? extends Animal> animals){
        for (Animal animal:animals){
            System.out.println(animal);
        }
    }

    public static void testObj(List<? super Animal> animals){
        for (Object animal:animals){
            System.out.println(animal);
        }
    }

}
