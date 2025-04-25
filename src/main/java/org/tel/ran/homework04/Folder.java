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
    public void displayFormatedContent(String indent, StringBuilder output) {
        super.displayFormatedContent(indent, output);
        for (Content component : content) {
            component.displayFormatedContent(indent + "  ", output);
        }
    }

    public void addContent(Content component) {
        content.add(component);
    }

    public boolean hasFolder(String folderName) {
        for (Content component : content) {
            if (component instanceof Folder) {
                if (component.getName().equals(folderName)) return true;
            }
        }
        return false;
    }

    public Folder getFolder(String folderName) {
        for (Content component : content) {
            if (component instanceof Folder) {
                if (component.getName().equals(folderName)) return (Folder) component;
            }
        }
        throw new IllegalArgumentException("There no such folder");
    }
}
