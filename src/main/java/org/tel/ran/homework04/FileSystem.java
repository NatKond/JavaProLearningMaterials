package org.tel.ran.homework04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class FileSystem {

    private static final Folder ROOT = new Folder("root");

    private static final String INITIAL_INDENT = "";

    public static final Logger LOGGER = new Logger("files/log", true);

    private FileSystem() {
    }

    public static void displayFormatedContent() {
        System.out.println(getFormatedContent());
    }

    public static void saveToFileFormatedContent(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(getFormatedContent());
        } catch (IOException e) {
            LOGGER.log(e.getMessage(), java.nio.file.FileSystem.class);
        }
    }

    public static void readFileSystemFromFileFormatedContent(String path) {
        ArrayList<String> input = new ArrayList<>();
        try (FileReader fileReader = new FileReader(path)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            input = bufferedReader.lines()
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e) {
            LOGGER.log(e.getMessage(), java.nio.file.FileSystem.class);
        }
        generateQueries(input).forEach(FileSystem::createStructureFromString);
    }

    public static void createStructureFromString(String input) {
        ArrayList<String> names = parseString(input);

        Folder currentFolder = ROOT;

        for (String name : names) {
            if (File.isFile(name)) {
                currentFolder.addContent(new File(name));
                break;
            } else if (currentFolder.hasFolder(name)) {
                currentFolder = currentFolder.getFolder(name);
            } else {
                Folder newFolder = new Folder(name);
                currentFolder.addContent(newFolder);
                currentFolder = newFolder;
            }
        }
    }

    private static ArrayList<String> generateQueries(ArrayList<String> input) {
        return generateQueriesRecursive(input, 1, INITIAL_INDENT + "  ", new StringBuilder(), new ArrayList<>(), false);
    }

    private static ArrayList<String> generateQueriesRecursive(ArrayList<String> input, int index, String indent, StringBuilder query, ArrayList<String> queries, boolean addedNew) {
        if (index == input.size()) {
            queries.add(query.toString());
            return queries;
        }

        String line = input.get(index);
        if (indent.equals(line.substring(0, indent.length()))) {
            query.append("/").append(line.replaceAll("\\s+", ""));
            return generateQueriesRecursive(input, index + 1, indent + "  ", query, queries, true);
        } else {
            if (addedNew) {
                queries.add(query.toString());
            }
            query = new StringBuilder(query.substring(0, query.lastIndexOf("/")));
            return generateQueriesRecursive(input, index, indent.substring(0, indent.length() - 2), query, queries, false);
        }
    }

    private static String getFormatedContent() {
        StringBuilder output = new StringBuilder();
        ROOT.displayFormatedContent(INITIAL_INDENT, output);
        return output.toString();
    }

    private static ArrayList<String> parseString(String input) {
        //input = input.replaceAll("\\s+","");
        ArrayList<String> names = new ArrayList<>(List.of(input.split("/")));
        names.removeIf(String::isEmpty);
        if (names.getFirst().equals("root")) {
            names.removeFirst();
        }
        return names;
    }
}
