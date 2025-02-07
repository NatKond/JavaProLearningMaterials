package org.tel.ran.homework04;

public abstract class Content implements Comparable {

    private String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayFormatedContent(String indent){
        System.out.println(indent + name);
    }

    @Override
    public int compareTo(Object o) {
        Content obj = (Content) o;
        return name.compareTo(obj.getName());
    }
}
