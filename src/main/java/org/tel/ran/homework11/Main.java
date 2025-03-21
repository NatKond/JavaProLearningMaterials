package org.tel.ran.homework11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Worker> workers = Arrays.asList(
                new Worker("John Smith", Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER)),
                new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
                new Worker("Michael Brown", Set.of(Skill.CARPENTER, Skill.CONCRETE_WORKER)),
                new Worker("Emma Davis", Set.of(Skill.CRANE_OPERATOR))
        );

        Tender tender = new Tender(Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.CONCRETE_WORKER, Skill.CRANE_OPERATOR));

        List<Set<Skill>> uniqueSkillCombinations = findUniqueSkillCombinations(workers);

        for (Set<Skill> combination : uniqueSkillCombinations) {
            System.out.println(combination);
        }
    }

    public static List<Set<Skill>> findUniqueSkillCombinations(List<Worker> workers) {
        List<Set<Skill>> result = new ArrayList<>();
        Queue<Set<Skill>> queue = new LinkedList<>();

        queue.add(new HashSet<>()); // Начинаем с пустого множества

        for (Worker worker : workers) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Skill> currentSet = queue.poll(); // Достаем частичную комбинацию

                for (Skill skill : worker.getSkills()) {
                    if (!currentSet.contains(skill)) { // Проверяем уникальность
                        Set<Skill> newSet = new HashSet<>(currentSet);
                        newSet.add(skill);

                        if (newSet.size() == workers.size()) {
                            result.add(newSet); // Если длина совпадает с числом работников -> добавляем в результат
                        } else {
                            queue.add(newSet); // Иначе добавляем в очередь для дальнейшей обработки
                        }
                    }
                }
            }
        }

        return result;
    }
}