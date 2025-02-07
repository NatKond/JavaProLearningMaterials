package org.tel.ran.homework04;


import java.util.*;

public class Main {

    public static final Folder ROOT = new Folder("root");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String answer;
        String input;

        do {
            System.out.println("Enter number:\n" +
                    "1 - add content; 2 - print FileSystem; 3 - stop program");
            answer = scanner.nextLine();
            if (answer.equals("1")){
                System.out.println("Enter content:");
                input = scanner.nextLine();
                createStructureFromString(input);
            } else if (answer.equals("2")) {
                ROOT.displayFormatedContent("");
            }
        } while (!answer.equals("3"));
    }

    public static void createStructureFromString(String input){
        ArrayList<String> names = parseString(input);

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

    private static ArrayList<String> parseString(String input){
        //input = input.replaceAll("\\s+","");
        ArrayList<String> names = new ArrayList<>(List.of(input.split("/")));
        Iterator<String> iterator = names.iterator();

        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).isEmpty()) names.remove(i);
        }

        if (names.getFirst().equals("root")) {
            names.removeFirst();
        }
        return names;
    }

    private static boolean isFile(String name){
        if (name.length() - 4 < 0) return false;
        return name.indexOf(".") == (name.length() - 4);
    }
}
