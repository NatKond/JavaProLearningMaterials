package org.tel.ran.summary02;

abstract public class Creature {

    private String name;

    public Creature(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void sayHello();

    public void playWithEachOther(Creature another){
        System.out.println(name + " is playing with " + another.getName());
    };
}
