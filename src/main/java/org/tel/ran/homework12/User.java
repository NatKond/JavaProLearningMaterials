package org.tel.ran.homework12;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String country;

    public User(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        OnlineApp.addUser(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, country);
    }

    public void view(Content content) {
        content.view();
        OnlineApp.interact(this, content, InteractionType.VIEW);
    }

    public void like(Content content) {
        OnlineApp.interact(this, content, InteractionType.LIKE);
    }

    public void comment(Content content, String comment) {
        OnlineApp.interact(this, content, InteractionType.COMMENT, comment);
    }

    @Override
    public String toString() {
        return name + ", country: " + country;
    }
}
