package org.tel.ran.homework12;

import java.util.Objects;

public class Article implements Content {
    private String name;
    private String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
        OnlineApp.addContent(this);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(name, article.name) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text);
    }

    @Override
    public void view() {
        System.out.println("Article: " + name + "/n" + text);
    }

    @Override
    public String toString() {
        return "Article: " + name;
    }
}
