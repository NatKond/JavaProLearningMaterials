package org.tel.ran._2025_01_21.lesson03practice;

public class Circle extends Shape{

    private int radius;

    public Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }


    @Override
    public void draw() {
        System.out.println("Draw a " + super.getColor() + " circle with a radius of " + radius + ".");
    }
}
