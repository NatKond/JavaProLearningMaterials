package org.tel.ran._2025_01_21.lesson03practice;

public class Square extends Shape{

    private int side;

    public Square(String color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Draw a " + this.getColor() + " square with a side of " + side + ".");
    }
}
