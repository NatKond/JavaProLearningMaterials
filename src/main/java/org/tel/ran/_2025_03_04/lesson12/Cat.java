package org.tel.ran._2025_03_04.lesson12;

import java.util.Objects;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat " + name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Cat cat = (Cat) object;
        return Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
