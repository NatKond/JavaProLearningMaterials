package org.tel.ran._2025_01_21.lesson03practice;

/**
 * Создайте абстрактный класс Shape и его наследники Circle, Square, Triangle. Класс Shape содержит метод draw() и переменную хранящую цвет.
 * Классы Circle, Square, Triangle содержат переменные радиус, сторона квадрата, сторона треугольника соответственно.
 * В main создать массив содержащий эти фигуры. В цикле у каждой фигуры вызвать метод draw, который будет выводить
 * в консоль сообщение в формате «Draw <форма фигуры> of <цвет> color with a <соответствующий параметр>».
 */

public abstract  class Shape {

    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract void draw();
}
