package org.tel.ran.homework12;

import java.util.Objects;

public abstract class Content {
    private String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void view();


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Content content = (Content) object;
        return Objects.equals(name, content.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
