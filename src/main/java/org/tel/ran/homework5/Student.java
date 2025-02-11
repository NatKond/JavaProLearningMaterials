package org.tel.ran.homework5;

public class Student {
    private String name;
    private String avg_mark;

    public Student(String name, String avg_mark) {
        this.name = name;
        this.avg_mark = avg_mark;
    }

    public String getName() {
        return name;
    }

    public String getAvg_mark() {
        return avg_mark;
    }
}
