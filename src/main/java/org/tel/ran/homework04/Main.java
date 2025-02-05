package org.tel.ran.homework04;

import java.util.*;

public class Main {

    public static final Folder ROOT = new Folder("root");

    public Comparator componentComparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            FileSystemObject component1 = (FileSystemObject) o1;
            FileSystemObject component2 = (FileSystemObject) o2;

            return component1.getName().compareTo(component2.getName());
        }
    };

    public static void main(String[] args) {

        createStructureFromString("test.txt");

        createStructureFromString("root/folder1/1.txt");
        createStructureFromString("root/folder1/New.java");
        createStructureFromString("root/folder2/Hello");
        createStructureFromString("root/folder2/Hello/test/test1");
        createStructureFromString("root/folder2/Task.txt");
        ROOT.displayFormatedContent("");
    }

    public static void createStructureFromString(String input){
        ArrayList <String> names = new ArrayList<>(Arrays.asList(input.split("/")));
        if (names.getFirst().equals("root")) {
            names.removeFirst();
        }

        Folder currentFolder = ROOT;

        for (String name: names){
            if (isFile(name)){
                currentFolder.addContent(new File(name));
            } else if (currentFolder.getFolder(name) != null){
                currentFolder = currentFolder.getFolder(name);
            } else {
                Folder newFolder = new Folder(name);
                currentFolder.addContent(newFolder);
                currentFolder = newFolder;
            }
        }
    }

    private static boolean isFile(String name){
        return name.indexOf(".") == (name.length() - 4);
    }
}
