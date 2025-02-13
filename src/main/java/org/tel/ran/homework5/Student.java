package org.tel.ran.homework5;

public class Student {
    private String name;
    private double avgMark;

    public Student(String name, double avgMark) {
        this.name = name;
        this.avgMark = avgMark;
    }

    public String getName() {
        return name;
    }

    public double getAvgMark() {
        return avgMark;
    }

    @Override
    public String toString() {
        return name + " : " + avgMark;
    }
}
