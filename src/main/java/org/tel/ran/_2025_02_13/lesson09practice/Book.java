package org.tel.ran._2025_02_13.lesson09practice;

import java.util.Objects;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return Objects.equals(title, book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }
}
