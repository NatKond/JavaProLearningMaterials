package org.tel.ran._2025_01_24.summary02;

public class Dog extends Animal{

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    public void sayHello() {
        System.out.println("Bark! I'm a dog of " + breed + "breed. My name is " + getName());
    }

    @Override
    public void playWithEachOther(Creature another) {
        if(another instanceof Cat){
            System.out.printf("Dog %s barks. Cat %s runs away%n", getName(), another.getName());
        }
        super.playWithEachOther(another);
    }
}
