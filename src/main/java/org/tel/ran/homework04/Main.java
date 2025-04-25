package org.tel.ran.homework04;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        String input;
        boolean flag = true;

        while (flag) {
            printActions();
            answer = scanner.nextLine();
            switch (answer) {
                case "1" -> {
                    System.out.println("Enter content:");
                    input = scanner.nextLine();
                    FileSystem.createStructureFromString(input);
                }
                case "2" -> FileSystem.displayFormatedContent();
                case "3" -> FileSystem.saveToFileFormatedContent("files/FileSystem.txt");
                case "4" -> FileSystem.readFileSystemFromFileFormatedContent("files/FileSystem.txt");
                case "0" -> flag = false;
            }
        }
    }


    private static void printActions() {
        String textBlock = """
                Available actions:
                1 - add content;
                2 - print FileSystem;
                3 - save FileSystem to file;
                4 - read FileSystem from file;
                0 - stop program;
                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}
