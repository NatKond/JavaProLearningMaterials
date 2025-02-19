package org.tel.ran._2025_01_21.lesson03practice;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle("red", 5);
        Shape square = new Square("yellow", 2);
        Shape triangle = new Triangle("green", 2,3);

        Shape[] shapes = {circle, square, triangle};

        for (Shape s: shapes) s.draw();

    }
}
