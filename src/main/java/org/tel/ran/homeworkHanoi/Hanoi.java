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
        System.out.println(GREY + "depthOfCallStack = " + callStackDepth + RESET);
        if (n == 1) {
            makeMove(start, end);
        } else {
            hanoiRecursion(n - 1, start, aux, end);
            callStackDepth--;
            System.out.println(GREY + "depthOfCallStack = " + callStackDepth + RESET);
            makeMove(start, end);
            hanoiRecursion(n - 1, aux, end, start);
            callStackDepth--;
            System.out.println(GREY + "depthOfCallStack = " + callStackDepth + RESET);
        }
    }

    private static void makeMove(String start, String end) {
        System.out.println(" " + start + " --> " + end);
        TOWER_MAP.get(start).moveRingToTower(TOWER_MAP.get(end));
        System.out.println(printTowerMap());
    }

    private static void hanoiIteration(int n, String start, String end, String aux) {
        createTowers(n, start, end, aux);
        while (TOWER_MAP.get(end).getSize() != n) {
            if (n % 2 == 0) {
                chooseAndMakeMove(start, aux);
                if (TOWER_MAP.get(end).getSize() != n) {
                    chooseAndMakeMove(start, end);
                }
            } else {
                chooseAndMakeMove(start, end);
                if (TOWER_MAP.get(end).getSize() != n) {
                    chooseAndMakeMove(start, aux);
                }
            }
            if (TOWER_MAP.get(end).getSize() != n) {
                chooseAndMakeMove(aux, end);
            }
        }
    }

    private static void chooseAndMakeMove(String nameTower1, String nameTower2) {
        if (TOWER_MAP.get(nameTower1).isMoveToTowerAllowed(TOWER_MAP.get(nameTower2))) {
            makeMove(nameTower1,nameTower2);
        } else if (TOWER_MAP.get(nameTower2).isMoveToTowerAllowed(TOWER_MAP.get(nameTower1))) {
            makeMove(nameTower2,nameTower1);
        }
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

        for (Map.Entry<String, Tower> entry : entries) {
            if (entry.getValue().getSize() > maxSize) {
                maxSize = entry.getValue().getSize();
            }
            sizes.add(entry.getValue().getSize());
            iterators.add(entry.getValue().getIterator());
            names.append(" ").append(entry.getKey()).append(" ");
        }
        output.append(BLUE);
        for (int i = maxSize; i > 0; i--) {
            for (int j = 0; j < entries.size(); j++) {
                if (sizes.get(j) >= i) {
                    output.append(" ").append(iterators.get(j).next()).append(" ");
                } else output.append("   ");
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

