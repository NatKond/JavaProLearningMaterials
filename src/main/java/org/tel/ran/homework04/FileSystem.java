package org.tel.ran.homework04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class FileSystem {

    private static final Folder ROOT = new Folder("root");
    private static final String INITIAL_INDENT = "";
    public static final Logger LOGGER = new Logger("files/log",true);

    private FileSystem() {
    }

    public static void displayFormatedContent(){
        System.out.println(getFormatedContent());
    }

    public static void saveToFileFormatedContent(String path){
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(getFormatedContent());
            fileWriter.flush();
        } catch (IOException e) {
            LOGGER.log(e.getMessage(), java.nio.file.FileSystem.class);
        }
    }

    public static void createStructureFromString(String input){
        ArrayList<String> names = parseString(input);

        Folder currentFolder = ROOT;

        for (String name: names){
            if (File.isFile(name)){
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

    private static String getFormatedContent(){
        StringBuilder output = new StringBuilder();
        ROOT.displayFormatedContent(INITIAL_INDENT, output);
        return output.toString();
    }

    private static ArrayList<String> parseString(String input){
        //input = input.replaceAll("\\s+","");
        ArrayList<String> names = new ArrayList<>(List.of(input.split("/")));
        names.removeIf(String::isEmpty);
        if (names.getFirst().equals("root")) {
            names.removeFirst();
        }
        return names;
    }
}
