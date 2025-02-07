package org.tel.ran.homework04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileSystem {

    public static final Folder ROOT = new Folder("root");

    public static final String INITIAL_INDENT = "";

    public static final int MIN_FILE_NAME_LENGTH = 4;

    public static final int MIN_LENGTH_EXTENSION = 3;

    public static final int MAX_LENGTH_EXTENSION = 6;

    public static void displayFormatedContent(){
        ROOT.displayFormatedContent(INITIAL_INDENT);
    }

    public static void createStructureFromString(String input){
        ArrayList<String> names = parseString(input);

        Folder currentFolder = ROOT;

        for (String name: names){
            if (isFile(name)){
                currentFolder.addContent(new File(name));
                break;
            } else if (currentFolder.hasFolder(name)){
                currentFolder = currentFolder.getFolder(name);
            } else {
                Folder newFolder = new Folder(name);
                currentFolder.addContent(newFolder);
                currentFolder = newFolder;
            }
        }
    }

    private static ArrayList<String> parseString(String input){
        //input = input.replaceAll("\\s+","");
        ArrayList<String> names = new ArrayList<>(List.of(input.split("/")));
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            if (iterator.next().isEmpty()){
                iterator.remove();
            }
        }
        if (names.getFirst().equals("root")) {
            names.removeFirst();
        }
        return names;
    }

    private static boolean isFile(String name){
        if (name.length() - MIN_FILE_NAME_LENGTH < 0) return false;
        return name.indexOf(".") <= (name.length() - MIN_LENGTH_EXTENSION) && name.indexOf(".") >= (name.length() - MAX_LENGTH_EXTENSION);
    }
}
