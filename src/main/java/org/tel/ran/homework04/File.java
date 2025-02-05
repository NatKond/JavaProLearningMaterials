package org.tel.ran.homework04;

public class File implements FileSystemObject {

    String name;

    public File(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayFormatedContent(String indent) {
        System.out.println(indent + getName());
    }
}
