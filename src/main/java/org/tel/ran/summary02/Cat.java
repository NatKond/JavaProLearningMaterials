package org.tel.ran.summary02;

public class Cat extends Animal implements MouseCatcher{

    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void sayHello() {
        System.out.println("Meow! I'm a cat. My name is " + getName());
    }

    @Override
    public void playWithEachOther(Creature another) {
        if (another instanceof Dog){
            // %s - ссылка на строку
            // %d - ссылка на число
            // %n - перенос строки на следующую строку
            // System.out.println("Dog " + another.getName() + " barks. Cat " + getName() + " runs away.");
            // System.out.println(String.format("Dog %s barks. Cat %s runs away", another.getName(), getName()));
            System.out.printf("Dog %s barks. Cat %s runs away%n", another.getName(), getName());
            return;
        }
        super.playWithEachOther(another);
    }

    @Override
    public void catchMouse(Mouse mouse) {
        System.out.printf("%s catches a mouse %s",getName(),mouse.getName());
    }
}
