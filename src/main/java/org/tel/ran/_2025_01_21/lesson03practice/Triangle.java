package org.tel.ran._2025_01_21.lesson03practice;

public class Triangle extends Shape{

    private int side1;

    private int side2;

    public Triangle(String color, int side1, int side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void draw() {
        System.out.println("Draw a " + this.getColor() + " triangle with first side " + side1 + " and second side " + side2 + ".");
    }
}
