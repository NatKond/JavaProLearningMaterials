package org.tel.ran.homework06;

import org.tel.ran.homework05.Point;

import java.util.Iterator;

import static org.tel.ran.textFormatting.*;

public class TestArrayList {

    public static void main(String[] args) {
        FixedSizeArrayList<Point> points = new FixedSizeArrayList<>(7);
        points.add(null);
        points.add(new Point(1, 2));
        points.add(new Point(3, 4));
        points.add(new Point(3, 1));
        points.add(new Point(1, 1));
        points.add(new Point(2, 4));
        points.add(new Point(3, 5));
        //points.add(new Point(2,2));
        System.out.println(YELLOW + points + RESET);

        System.out.println("--------- CONTAINS ---------");
        System.out.println("points.contains(null) = " + points.contains(null));
        System.out.println("points.contains(new Point(3,1)) = " + points.contains(new Point(3, 1)));
        System.out.println("points.contains(new Point(2,4)) = " + points.contains(new Point(2, 4)));
        System.out.println("points.contains(new Point(2,2)) = " + points.contains(new Point(2, 2)));

        System.out.println("---------- REMOVE ----------");
        System.out.println(YELLOW + points + RESET);
        System.out.println("points.remove(0) = " + points.remove(0));
        System.out.println("points.contains(null) = " + points.contains(null));
        System.out.println(YELLOW + points + RESET);
        System.out.println("points.remove(5) = " + points.remove(5));
        System.out.println("points.contains(new Point(3, 5)) = " + points.contains(new Point(3, 5)));
        System.out.println(YELLOW + points + RESET);
        System.out.println("points.remove(new Point(1, 1)) = " + points.remove(new Point(1, 1)));
        System.out.println(YELLOW + points + RESET);
        System.out.println("points.remove(new Point(3, 2)) = " + points.remove(new Point(3, 2)));
        System.out.println(YELLOW + points + RESET);

        System.out.println("-------- ADD BY INDEX --------");
        points.add(1, new Point(3, 3));
        System.out.println("points.add(1, new Point(3, 3))");
        System.out.println(YELLOW + points + RESET);
        points.add(3, new Point(1, 1));
        System.out.println("points.add(3, new Point(1, 1))");
        System.out.println(YELLOW + points + RESET);
        points.add(5, null);
        System.out.println("points.add(5, null)");
        System.out.println(YELLOW + points + RESET);

        System.out.println("-------- GET BY INDEX --------");
        System.out.println("points.get(0) = " + points.get(0));
        System.out.println("points.get(4) = " + points.get(4));
        System.out.println("points.get(points.size() - 1) = " + points.get(points.size() - 1));

        System.out.println("-------- SET BY INDEX --------");
        System.out.println("points.set(0, new Point(0,0))) = " + points.set(0, new Point(0, 0)));
        System.out.println("points.set(2, new Point(0,1))) = " + points.set(2, new Point(0, 1)));
        System.out.println("points.set(6, new Point(0,0))) = " + points.set(6, new Point(0, 0)));
        System.out.println(YELLOW + "points = " + points + RESET);

        System.out.println("--------- INDEX OF ---------");
        System.out.println("points.indexOf(null) = " + points.indexOf(null));
        System.out.println("points.indexOf(new Point(0,0)) = " + points.indexOf(new Point(0,0)));
        System.out.println("points.lastIndexOf(new Point(0,0)) = " + points.lastIndexOf(new Point(0,0)));
        System.out.println("points.remove(0) = " + points.remove(0));
        System.out.println("points.indexOf(new Point(0,0)) = " + points.indexOf(new Point(0,0)));
        System.out.println(YELLOW + "points = " + points + RESET);

        System.out.println("--------- ITERATOR ---------");
        Iterator<Point> pointIterator = points.iterator();
        // pointIterator.remove();  //OutOfRangeException
        System.out.println("pointIterator.next() = " + pointIterator.next());
        System.out.println("pointIterator.next() = " + pointIterator.next());
        pointIterator.remove();
        System.out.println("pointIterator.remove()");
        System.out.println(YELLOW + "points = " + points + RESET);
        System.out.println("pointIterator.next() = " + pointIterator.next());
        System.out.println("pointIterator.next() = " + pointIterator.next());
        System.out.println("pointIterator.next() = " + pointIterator.next());
        System.out.println("pointIterator.next() = " + pointIterator.next());
        pointIterator.remove();
        System.out.println("pointIterator.remove()");
        System.out.println(YELLOW + "points = " + points + RESET);
        // System.out.println("pointIterator.next() = " + pointIterator.next()); //OutOfRangeException

        System.out.println("--------- CLEAR ---------");
        points.clear();
        System.out.println("points.clear()");
        System.out.println(YELLOW + "points = " + points + RESET);
        points.add(new Point(0,0));
        System.out.println(YELLOW + "points = " + points + RESET);
    }
}
