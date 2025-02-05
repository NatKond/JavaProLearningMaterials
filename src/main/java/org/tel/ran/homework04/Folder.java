package org.tel.ran.homework04;

import java.util.*;

public class Folder extends Content {

    private Set<Content> content = new TreeSet<>();

    public Folder(String name) {
        super(name);
    }

    public Folder(String name, Set<Content> content) {
        super(name);
        this.content = content;
    }

    @Override
    public void displayFormatedContent(String indent) {
        super.displayFormatedContent(indent);
        for (Content obj: content){
            obj.displayFormatedContent(indent + "  ");
        }
    }

    public void addContent(Content component){
        content.add(component);
    }

    public Folder getFolder(String folderName){
        for (Content component: content){
            if (component instanceof Folder){
                if (component.getName().equals(folderName)) return (Folder) component;
            }
        }
        return null;
    }
}
