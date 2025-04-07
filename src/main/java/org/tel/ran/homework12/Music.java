package org.tel.ran.homework12;

public class Music extends Content {
    private String description;

    public Music(String name, String description) {
        super(name);
        this.description = description;
    }

    @Override
    public void view() {
        System.out.println("Music: " + super.getName() + "/n" + description);
    }

    @Override
    public String toString() {
        return "Music: " + super.getName();
    }
}
