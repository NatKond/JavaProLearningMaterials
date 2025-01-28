package org.tel.ran._2025_01_24.summary02;

public class Main {
    public static void main(String[] args) {
        // Экземпляры класса Cat
        Cat cat1 = new Cat("Whiskers", 3, "Black");
        Cat cat2 = new Cat("Mittens", 5, "White");

        // Экземпляр класса Dog
        Dog dog = new Dog("Rex", 4, "Labrador Retriever");

        // Экземпляры класса Mouse
        Mouse mouse1 = new Mouse("Speedy", 1);
        Mouse mouse2 = new Mouse("Tiny", 2);

        // Экземпляр класса Human
        Human human = new Human("Jane Smith", 25);

        // Экземпляр класса Robot
        Robot robot = new Robot("T-800");

        Creature[] creatures = {cat1, cat2, dog, mouse1, mouse2, human, robot};
        AnimalWalker[] animalWalkers = {human, robot};
        Animal[] pets = {cat1, cat2, dog};
        MouseCatcher[] mouseCatchers = {cat1, cat2, robot};
        Animated[] animateds = {cat1, cat2, dog, mouse1, mouse2, human};

        System.out.println("---------- FEEDING ----------");
        human.feed(pets);
        System.out.println("---------- GREETINGS ----------");
        greetings(creatures);
        System.out.println("---------- TIME TO PLAY ----------");
        playWithEachOther(creatures);
        System.out.println("---------- WALKING TIME ----------");
        walkAnimals(animalWalkers, pets);
        System.out.println("---------- CATCHING TIME ----------");
        catchMouse(mouseCatchers,mouse1);
        System.out.println("---------- GETTING OLDER TIME ----------");
        gettingOlder(animateds);
    }

    public static void greetings(Creature[] creatures){
        for (Creature c:creatures){
            c.sayHello();
        }
    }

    public static void playWithEachOther(Creature[] creatures){

        /* каждый сыграет с каждым по 2 раза
        for (Creature c1:creatures){
            for (Creature c2: creatures){
                if (c1 != c2) c1.playWithEachOther(c2);
            }
        } */

        for (int i = 0; i < creatures.length; i++) {
            for (int j = i + 1; j < creatures.length; j++) {
                creatures[i].playWithEachOther(creatures[j]);
            }
        }
    }
    public static void walkAnimals(AnimalWalker[] animalWalkers, Animal[] animals){
        int walkerIndex = 0;

        for (Animal animal: animals){
            if (walkerIndex == animalWalkers.length) walkerIndex = 0;
            animalWalkers[walkerIndex++].walkAnimal(animal);
        }
    }

    public static void catchMouse(MouseCatcher[] mouseCatchers, Mouse mouse){
        for (MouseCatcher mouseCatcher:mouseCatchers){
            mouseCatcher.catchMouse(mouse);
        }
    }

    public static void gettingOlder(Animated[] animateds){
        for (Animated animated:animateds){
            animated.grow();
        }
    }
}
