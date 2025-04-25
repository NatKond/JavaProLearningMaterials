package org.tel.ran.homework04;

public abstract class Content implements Comparable<Content> {

    private String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void displayFormatedContent(String indent, StringBuilder output){
        //System.out.println(indent + name);
        output.append(indent).append(name).append("\n");
    }

    @Override
    public int compareTo(Content obj) {
        return name.compareTo(obj.getName());
    }
}
