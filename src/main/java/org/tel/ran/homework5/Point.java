package org.tel.ran.homework5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.tel.ran.textFormatting.*;

/**
 * Создать класс Point для хранения координат (x, y) точки на плоскости. Создать список точек, отсортировать по координате y.
 * Создать TreeSet со всеми уникальными точками. Создать TreeSet со всеми различными по координате y точками.
 */

public class Point implements Comparable{
    private Integer x;
    private Integer y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Point["+ x + ", " + y + ']';
    }

    @Override
    public int compareTo(Object o) {
        Point point = (Point) o;
        return y.compareTo(point.getY());
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Point point = (Point) object;
        return Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>(List.of(new Point(2,3),new Point(1,1),new Point(1,2), new Point(0,4)));
        System.out.println(RED + points + RESET);
        points.sort(Comparator.naturalOrder());
        System.out.println(RED + points + RESET);
    }
}
