package org.tel.ran._2025_03_18.lesson16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class Main {
    static int k = 5;

    public static void main(String[] args) {
        Operation operationAnonymous = new Operation() {
            @Override
            public int calculate(int x, int y) {
                return x + y;
            }
        };

        Operation operationLambda = (x, y) -> {
            k = 10;
            if (x % 2 == 0) {
                return x + y;
            } else {
                return x - y;
            }
        };

        Operation operationLambda2 = Integer::sum;
        System.out.println("k = " + k);
        System.out.println("operationLambda.calculate(5,10) = " + operationLambda.calculate(5, 10));
        System.out.println("operationLambda2.calculate(5,10) = " + operationLambda2.calculate(5, 10));
        System.out.println("k = " + k);
        MyFunction myFunction = n -> System.out.println(n);
        myFunction.method(6);

        FunctionGeneric<Integer> functionGeneric = (x, y) -> x + y;
        FunctionGeneric<String> functionGeneric2 = (x, y) -> x + y;
        System.out.println("functionGeneric.calculate(5,10) = " + functionGeneric.calculate(5, 10));
        System.out.println("functionGeneric2.calculate(\"5\", \"10\") = " + functionGeneric2.calculate("5", "10"));

        Person person = new Person("Sam", 21, false);
        Predicate<Person> personPredicate = p -> p.getAge() >= 18;
        Predicate<Person> personPredicate2 = Person::isActive;
        System.out.println("personPredicate.test(person) = " + personPredicate.test(person));
        System.out.println("personPredicate2.test(person) = " + personPredicate2.test(person));

        Consumer<Person> personConsumer = p -> System.out.println(p);
        personConsumer.accept(person);

        Supplier<Person> personSupplier = () -> new Person("Anonymous", 18, true);
        Person person1 = personSupplier.get();
        System.out.println("person1 = " + person1);

        Function<Person, String> personStringFunction = p -> p.toString() + " This is my person.";
        System.out.println("personStringFunction = " + personStringFunction.apply(person));

        UnaryOperator<Person> personUnaryOperator = p -> {
            p.setAge(p.getAge() + 1);
            return p;
        };
        Person person2 = personUnaryOperator.apply(person1);
        System.out.println("person2 = " + person2);

        BiFunction<String,Integer,Person> personBiFunction = (name,age) -> new Person(name,age,true);
        System.out.println("personBiFunction.apply(\"Hugo\", 15) = " + personBiFunction.apply("Hugo", 15));

        List<Person> personList = new ArrayList<>(List.of(
                personBiFunction.apply("Anja", 23),
                personBiFunction.apply("Tom", 20),
                personBiFunction.apply("Harry", 12),
                personBiFunction.apply("Andrew", 40)));
        List<Person> personAdultList = new ArrayList<>();
        for (Person person3 : personList) {
            if (person3.getAge() >= 18){
                personAdultList.add(person3);
            }
        }
        System.out.println("personAdultList = " + personAdultList);

        List<Person> personAdultList2 = personList.stream()
                .filter(p -> p.getAge() >= 18)
                .toList();
        System.out.println("personAdultList2 = " + personAdultList2);

        String s = "count chars";
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') continue;
            charCountMap.merge(c, 1,(oldValue, newValue) -> oldValue + 1);
//            charCountMap.putIfAbsent(c,0);
//            charCountMap.put(c,charCountMap.get(c) + 1);
        }
        System.out.println("charCountMap = " + charCountMap);

        personList.forEach(p -> p.setAge(p.getAge() + 1));
        System.out.println("personList = " + personList);

    }
}
