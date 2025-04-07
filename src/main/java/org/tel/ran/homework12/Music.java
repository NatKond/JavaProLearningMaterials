package org.tel.ran.homework12;

import java.util.Objects;

public class Music implements Content {
    private String name;
    private String description;

    public Music(String name, String description) {
        this.name = name;
        this.description = description;
        OnlineApp.addContent(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Music music = (Music) object;
        return Objects.equals(name, music.name) && Objects.equals(description, music.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public void view() {
        System.out.println("Music: " + name + "/n" + description);
    }

    @Override
    public String toString() {
        return "Music: " + name;
    }
}
