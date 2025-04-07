package org.tel.ran.homework12;

public class Video extends Content{
    private String description;

    public Video(String name, String description) {
        super(name);
        this.description = description;
    }

    @Override
    public void view() {
        System.out.println("Video: " + super.getName() + "/n" + description);
    }

    @Override
    public String toString() {
        return "Video: " + super.getName();
    }
}
