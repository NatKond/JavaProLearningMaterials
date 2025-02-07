package org.tel.ran.homework04;


import java.util.*;

public class Main {
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
                FileSystem.createStructureFromString(input);
            } else if (answer.equals("2")) {
                FileSystem.displayFormatedContent();
            }
        } while (!answer.equals("3"));
    }

}
