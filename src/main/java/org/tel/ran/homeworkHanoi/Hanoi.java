package org.tel.ran.homeworkHanoi;

import java.util.*;

import static org.tel.ran.textFormatting.*;

public class Hanoi {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<String, Tower> TOWER_MAP = new HashMap<>();
    private static int callStackDepth;
    private static int countMoves;

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
                            countMoves = 0;
                            createTowers(input, "A", "C", "B");
                            hanoiRecursion(input, "A", "C", "B");
                            System.out.println("countMoves = " + countMoves);
                        } else {
                            countMoves = 0;
                            hanoiIteration(input, "A", "C", "B");
                            System.out.println("countMoves = " + countMoves);
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
//        callStackDepth = 0;
//        createTowers(4, "A", "C", "B");
//        hanoiRecursion(4, "A", "C", "B");
//        hanoiIteration(3, "A", "C", "B");
    }

    private static void hanoiRecursion(int n, String start, String end, String aux) {
        callStackDepth++;
        System.out.println(printCallInfo(n, start, end, aux));
        if (n == 1) {
            makeMove(start, end);
        } else {
            hanoiRecursion(n - 1, start, aux, end);
            callStackDepth--;
            System.out.println(printCallInfo(n, start, end, aux));
            makeMove(start, end);
            hanoiRecursion(n - 1, aux, end, start);
            callStackDepth--;
            System.out.println(printCallInfo(n, start, end, aux));
        }
    }

    private static void makeMove(String start, String end) {
        System.out.println(start + "  -->  " + end);
        TOWER_MAP.get(start).moveRing(TOWER_MAP.get(end));
        System.out.println(printTowerMap());
        countMoves++;
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
        while (!isSolved(n, end)) {
            makeDirectOrReverseMove(start, n % 2 == 0 ? aux : end);
            if (isSolved(n, end)) break;
            makeDirectOrReverseMove(start, n % 2 == 0 ? end : aux);
            if (isSolved(n, end)) break;
            makeDirectOrReverseMove(aux, end);
        }
    }

    private static boolean isSolved(int n, String end) {
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

    private static String printCallInfo(int n, String start, String end, String aux) {
        return GREY + "hanoiRecursion(n = " + n + ", start = " + start + ", end = " + end + ", aux = " + aux + "), callStackDepth = " + callStackDepth + RESET;
    }

    private static String printTowerMap() {
        StringBuilder output = new StringBuilder();
        StringBuilder names = new StringBuilder();
        List<Iterator<Integer>> iterators = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        Integer maxSize = 0;
        String indent = "\t";

        for (Map.Entry<String, Tower> entry : TOWER_MAP.entrySet()) {
            if (entry.getValue().getSize() > maxSize) {
                maxSize = entry.getValue().getSize();
            }
            sizes.add(entry.getValue().getSize());
            iterators.add(entry.getValue().getIterator());
            names.append(entry.getKey()).append(indent);
        }

        output.append(CYAN);
        for (int i = maxSize; i > 0; i--) {
            for (int j = 0; j < iterators.size(); j++) {
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

