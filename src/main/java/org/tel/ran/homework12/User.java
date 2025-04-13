package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private String name;
    private int age;
    private String country;
    private Set<Interaction> interactions;

    public User(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.interactions = new HashSet<>();
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

    public Set<Interaction> getInteractions() {
        return interactions;
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

    public void view(Content content, LocalDate date) {
        content.view();
        Interaction interaction = Interaction.builder(content, InteractionType.VIEW).localDate(date).build();
        this.interactions.add(interaction);
    }

    public void like(Content content, LocalDate date) {
        Interaction interaction = Interaction.builder(content, InteractionType.LIKE).localDate(date).build();
        this.interactions.add(interaction);
    }

    public void comment(Content content, LocalDate date, String comment) {
        Interaction interaction = Interaction.builder(content, InteractionType.COMMENT).localDate(date).comment(comment).build();
        this.interactions.add(interaction);
    }

    @Override
    public String toString() {
        return name + ", country: " + country;
    }
}
