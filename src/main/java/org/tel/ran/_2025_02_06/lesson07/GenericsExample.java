package org.tel.ran._2025_02_06.lesson07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {

        // ------------ BEFORE JAVA 5 ------------
        List animals = new ArrayList();

        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(new Animal());
        animals.add(123);

        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i) instanceof Animal animal){
                animal.voice();
            }
        }
        System.out.println();

        // ------------ JAVA 5 ------------
        List<Animal> animals1 = new ArrayList<Animal>(List.of(new Animal(), new Animal(), new Animal(), new Animal()));

        for (Animal a: animals1){
            a.voice();
        }

        // ------------ JAVA 7 ------------
        List<Animal> animals2 = new ArrayList<>(List.of(new Animal(), new Animal(), new Animal(), new Animal()));

        for (Animal a: animals1){
            a.voice();
        }

        List<Animal> animals3 = List.of(new Animal(),new Animal(),new Animal()); //unmodifiable list
        // animals3.add(new Animal()); Error

        List<Animal> animals4 = new ArrayList<>(List.of(new Animal(),new Animal(),new Animal()));


    }
}
