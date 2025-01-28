package org.tel.ran._2025_01_21.lesson03practice.part2;

public abstract class Animal {

    /** Создать класс Animal и расширяющие его классы Dog, Cat, Horse.
     *  Класс Animal содержит переменные food, location и методы makeNoise, eat, sleep.
     *  Метод makeNoise, например, может выводить на консоль "Такое-то животное издаёт звук".
     *  Dog, Cat, Horse переопределяют методы makeNoise, eat. Добавьте переменные в классы Dog, Cat, Horse,
     *  характеризующие только этих животных, если придумаете.
     *  Создайте класс Ветеринар, в котором определите метод void treatAnimal(Animal animal).
     *  Пусть этот метод распечатывает food и location пришедшего на прием животного.
     *  В методе main создайте массив типа Animal, в который запишите животных всех имеющихся у вас типов.
     *  В цикле отправляйте их на прием к ветеринару.
     */

    protected String name;
    protected String food;
    protected String location;

    public Animal(String name, String food, String location) {
        this.name = name;
        this.food = food;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }

    public abstract void makeNoise();

    public abstract void eat();

    public abstract void sleep();

}
