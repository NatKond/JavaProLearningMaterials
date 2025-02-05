package org.tel.ran.homework04;

import java.util.*;

public class Folder implements FileSystemObject {

    private String name;

    private Set<FileSystemObject> content = new TreeSet<>();

    public Folder(String name) {
        this.name = name;
    }

    public Folder(String name, Set<FileSystemObject> content) {
        this.name = name;
        this.content = content;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayFormatedContent(String indent) {
        System.out.println(indent + getName());
        for (FileSystemObject obj: content){
            obj.displayFormatedContent(indent + "  ");
        }
    }

    public void addContent(FileSystemObject component){
        content.add(component);
    }

    public Folder getFolder(String folderName){
        for (FileSystemObject component: content){
            if (component instanceof Folder){
                if (component.getName().equals(folderName)) return (Folder) component;
            }
        }
        return null;
    }
}
