package org.tel.ran.homework5;

import java.time.Year;
import java.util.*;

import static org.tel.ran.textFormatting.*;

/**
 * Создать класс Point для хранения координат (x, y) точки на плоскости. Создать список точек, отсортировать по координате y.
 * Создать TreeSet со всеми уникальными точками. Создать TreeSet со всеми различными по координате y точками.
 */

public class Point implements Comparable<Point> {
    private int x;
    private int y;

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
        return "Point[" + x + ", " + y + ']';
    }

    @Override
    public int compareTo(Point point) {
        return this.y - point.y;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Point point)) return false;
        return this.x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Comparator<Point> pointComparator = new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                Point point1 = (Point) o1;
                Point point2 = (Point) o2;
                if (point1.x == point2.x && point1.y == point2.y) {
                    return 0;
                }
                if (point1.x != point2.x) {
                    return (point1.x - point2.x);
                } else {
                    return (point1.y - point2.y);
                }
            }
        };
        List<Point> points = new ArrayList<>(List.of(
                new Point(2, 3),
                new Point(2, 4),
                new Point(1, 1),
                new Point(1, 2),
                new Point(0, 4),
                new Point(0, 3),
                new Point(2, 2),
                new Point(2, 3)));
        System.out.println(RED + "ArrayList: " + RESET);
        System.out.println(YELLOW + points + RESET);
        points.sort(pointComparator);
        System.out.println(RED + "Sorted ArrayList: " + RESET);
        System.out.println(YELLOW + points + RESET);

        Set<Point> pointsSet = new HashSet<>(List.of(
                new Point(2, 3),
                new Point(2, 4),
                new Point(1, 1),
                new Point(1, 2),
                new Point(0, 4),
                new Point(0, 3),
                new Point(2, 2),
                new Point(2, 3)));
        System.out.println(RED + "HashSet: " + RESET);
        System.out.println(YELLOW + pointsSet + RESET);

        Set<Point> pointsTreeSet = new TreeSet<>(List.of(
                new Point(2, 3), // +
                new Point(2, 4), // +
                new Point(1, 1), // +
                new Point(1, 2), // +
                new Point(0, 4),
                new Point(0, 3),
                new Point(2, 2),
                new Point(2, 3)));
        pointsTreeSet.add(new Point(0, 4));
        pointsTreeSet.add(new Point(0, 3));
        System.out.println(RED + "TreeSet: " + RESET);
        System.out.println(YELLOW + pointsTreeSet + RESET);

        Set<Point> pointsTreeSet2 = new TreeSet<>(pointComparator);
        pointsTreeSet2.addAll(List.of(
                new Point(2, 3), // +
                new Point(2, 4), // +
                new Point(1, 1), // +
                new Point(1, 2), // +
                new Point(0, 4), // +
                new Point(0, 3),
                new Point(2, 2),
                new Point(2, 0)));
        System.out.println(RED + "TreeSet with comparator: " + RESET);
        System.out.println(YELLOW + pointsTreeSet2 + RESET);
    }
}
