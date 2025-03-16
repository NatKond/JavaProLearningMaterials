package org.tel.ran._2025_03_14.summary07;

import java.util.Objects;

public class User {
    private String name;
    private UserRole role;

    public User(String name, UserRole role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        User user = (User) object;
        return Objects.equals(name, user.name) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }

    @Override
    public String toString() {
        return name + " : " + role;
    }
}
