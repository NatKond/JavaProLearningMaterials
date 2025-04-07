package org.tel.ran.homework12;

public class Article extends Content {
    private String text;

    public Article(String name, String text) {
        super(name);
        this.text = text;
    }

    @Override
    public void view() {
        System.out.println("Article: " + super.getName() + "/n" + text);
    }

    @Override
    public String toString() {
        return "Article: " + super.getName();
    }
}
