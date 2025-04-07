package org.tel.ran.homework12;

import java.util.Objects;

public class Video implements Content{
    private String name;
    private String description;

    public Video(String name, String description) {
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
        Video video = (Video) object;
        return Objects.equals(name, video.name) && Objects.equals(description, video.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public void view() {
        System.out.println("Video: " + name + "/n" + description);
    }

    @Override
    public String toString() {
        return "Video: " + name;
    }
}
