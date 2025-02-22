package org.tel.ran.homeworkHanoi;

import java.util.*;

import static org.tel.ran.textFormatting.*;

public class Hanoi {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<String, Tower> TOWER_MAP = new HashMap<>();
    private static int callStackDepth;

    public static void main(String[] args) {
        String answer;
        int input;
        boolean useRecursion = true;
        boolean flag = true;
        while (flag) {
            printActions();
            answer = SCANNER.nextLine();
            switch (answer) {
                case "0" -> flag = false;
                case "1" -> {
                    System.out.println("Enter enter the number of rings:");
                    try {
                        input = Integer.parseInt(SCANNER.nextLine());
                        if (useRecursion) {
                            callStackDepth = 0;
                            System.out.println(GREY + "depthOfCallStack = " + callStackDepth + RESET);
                            createTowers(input, "A", "C", "B");
                            hanoiRecursion(input, "A", "C", "B");
                        } else {
                            hanoiIteration(input, "A", "C", "B");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid number of rings.");
                    }
                }
                case "2" -> {
                    System.out.println("Enter enter the number of algorithm:");
                    try {
                        input = Integer.parseInt(SCANNER.nextLine());
                        if (input == 1) {
                            useRecursion = true;
                        } else if (input == 2) {
                            useRecursion = false;
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid number of algorithm.");
                    }
                }
            }
        }
        //depthOfCallStack = 0;
        //createTowers(4, "A", "C", "B");
        //hanoiRecursion(4, "A", "C", "B");
        //hanoiIteration(3, "A", "C", "B");
    }

    private static void hanoiRecursion(int n, String start, String end, String aux) {
        callStackDepth++;
        System.out.println(GREY + "callStackDepth = " + callStackDepth + ": n = " + n + ", start = " + start + ", end = " + end + ", aux = " + aux + RESET);
        if (n == 1) {
            makeMove(start, end);
        } else {
            hanoiRecursion(n - 1, start, aux, end);
            callStackDepth--;
            System.out.println(GREY + "callStackDepth = " + callStackDepth + RESET);
            makeMove(start, end);
            hanoiRecursion(n - 1, aux, end, start);
            callStackDepth--;
            System.out.println(GREY + "callStackDepth = " + callStackDepth + RESET);
        }
    }

    private static void makeMove(String start, String end) {
        System.out.println(start + "  -->  " + end);
        TOWER_MAP.get(start).moveRing(TOWER_MAP.get(end));
        System.out.println(printTowerMap());
    }

    private static void makeDirectOrReverseMove(String nameTower1, String nameTower2) {
        if (TOWER_MAP.get(nameTower1).isMoveAllowed(TOWER_MAP.get(nameTower2))) {
            makeMove(nameTower1, nameTower2);
        } else {
            makeMove(nameTower2, nameTower1);
        }
    }

    private static void hanoiIteration(int n, String start, String end, String aux) {
        createTowers(n, start, end, aux);
        while (!isTowerSolved(n, end)) {
            makeDirectOrReverseMove(start, n % 2 == 0 ? aux : end);
            if (isTowerSolved(n, end)) continue;
            makeDirectOrReverseMove(start, n % 2 == 0 ? end : aux);
            if (isTowerSolved(n, end)) continue;
            makeDirectOrReverseMove(aux, end);
        }
    }

    private static boolean isTowerSolved(int n, String end) {
        return TOWER_MAP.get(end).getSize() == n;
    }

    private static void createTowers(int n, String start, String end, String aux) {
        TOWER_MAP.clear();
        Tower startTower = new Tower(n);
        Tower endTower = new Tower();
        Tower auxTower = new Tower();
        TOWER_MAP.put(start, startTower);
        TOWER_MAP.put(end, auxTower);
        TOWER_MAP.put(aux, endTower);
        System.out.println(printTowerMap());
    }

    private static String printTowerMap() {
        StringBuilder output = new StringBuilder();
        Set<Map.Entry<String, Tower>> entries = TOWER_MAP.entrySet();
        StringBuilder names = new StringBuilder();
        List<Iterator<Integer>> iterators = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        Integer maxSize = 0;
        String indent = "\t";

        for (Map.Entry<String, Tower> entry : entries) {
            if (entry.getValue().getSize() > maxSize) {
                maxSize = entry.getValue().getSize();
            }
            sizes.add(entry.getValue().getSize());
            iterators.add(entry.getValue().getIterator());
            names.append(entry.getKey()).append(indent);
        }
        output.append(CYAN);
        for (int i = maxSize; i > 0; i--) {
            for (int j = 0; j < entries.size(); j++) {
                if (sizes.get(j) >= i) {
                    output.append(iterators.get(j).next()).append(indent);
                } else output.append(indent);
            }
            output.append("\n");
        }
        return output.append(RESET).append(YELLOW).append(names).append(RESET).append("\n").toString();
    }

    private static void printActions() {
        String textBlock = """
                Available actions:
                0 - to shutdown
                1 - to enter the number of rings on the tower to solve the Hanoi Tower problem
                2 - to enter algorithm: 1 - recursion (default), 2 - iteration
                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }
}

