package org.tel.ran._2025_03_18.lesson16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // когда в лямде мы используем вызов статического метода класса
        // (аргументы) -> Класс. метод (аргументы) Класс::метод
        Operation operation1 = (x, y) -> x + y;
        Operation operation2 = (x, y) -> Integer.sum(x, y);
        Operation operation3 = Integer::sum;

        // когда в лямде мы используем вызов НЕ статического метода (вызов метода объекта класса)
        // (объект, аргрументы) -> объект. метод (аргументы) ------> Класс::метод
        BiConsumer<Person, String> biConsumer = (person, string) -> person.sayIt(string);
        BiConsumer<Person, String> biConsumerMethodReference = Person::sayIt;

        // когда в лямде мы используем метод объекта, переданного извне
        // (аргументы) -> объект.метод (аргумента) ------> объект::метод

        // когда в лямде мы используем метод объекта, переданного извне /
        //  (аргументы) -> объект.метод (аргумента)----> объект::метод
        Person object = new Person ("Ivan", 20 ,true);
        Consumer<String> consumer = string -> object.sayIt(string);
        Consumer<String> consumerMethodReference = object::sayIt;

        Function<Person, String> function = person -> person.getName();
        Function<Person, String> functionMethodReference = Person::getName;

        List<Person> personList = new ArrayList<>();
        List<String> list = personList.stream()
                .map(Person::getName).sorted()
                .limit(3).toList();
    }
}
