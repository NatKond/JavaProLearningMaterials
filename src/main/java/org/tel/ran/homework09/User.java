package org.tel.ran.homework09;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private int age;

    public User(String firstName, String lastName, String email, String phone, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ": " + email + ", " + phone + ", age = " + age;
    }
}
