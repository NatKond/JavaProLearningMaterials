package org.tel.ran.homework11;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Team team = new Team(Arrays.asList(
                new Worker("John Smith", Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER)),
                new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
                new Worker("Michael Brown", Set.of(Skill.CARPENTER, Skill.CONCRETE_WORKER)),
                new Worker("Emma Davis", Set.of(Skill.CRANE_OPERATOR))), 1500);

        Tender tender = new Tender(Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.CONCRETE_WORKER, Skill.CRANE_OPERATOR));

        System.out.println("meetsTeamRequirements(team, tender) = " + meetsTeamRequirements(team, tender));

        Team team1 = new Team(List.of(
                new Worker("John Smith", Set.of(Skill.ARCHITECT, Skill.CIVIL_ENGINEER)),
                new Worker("Alice Johnson", Set.of(Skill.ROOFER,  Skill.CONCRETE_WORKER)),
                new Worker("Michael Brown", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill. MASTER_OF_CONSTRUCTION_AND_INSTALLATION_WORKS)),
                new Worker("Emma Davis", Set.of(Skill.CARPENTER, Skill.CONCRETE_WORKER)),
                new Worker("Robert Wilson", Set.of(Skill.TECHNOLOGIST, Skill.PAINTER_PLASTERER))),
                1500);

        Team team2 = new Team(List.of(
                new Worker("Sophia Miller", Set.of(Skill.SURVEYOR, Skill.CONCRETE_WORKER)),
                new Worker("James Anderson", Set.of(Skill.ARCHITECT)),
                new Worker("Olivia Thomas", Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER)),
                new Worker("William Martinez", Set.of(Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
                new Worker("Charlotte Taylor", Set.of(Skill.ECONOMIST))),
                1300);

        Tender tender1 = new Tender(Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER, Skill.ARCHITECT, Skill.CARPENTER, Skill.PAINTER_PLASTERER));

        System.out.println("meetsTeamRequirements(team1,tender1) = " + meetsTeamRequirements(team1, tender1));
        System.out.println("meetsTeamRequirements(team2,tender1) = " + meetsTeamRequirements(team2, tender1));
    }

    public static boolean meetsTeamRequirements(Team team, Tender tender) {
        // создаем мапу, в которой работники распределены по уменям
        Map<Skill, List<Worker>> skillWorkerMap = new HashMap<>();
        for (Skill requirement : tender.getRequirements()) {
            skillWorkerMap.put(requirement, new ArrayList<>());
            for (Worker worker : team.getWorkerList()) {
                if (worker.getSkills().contains(requirement)) {
                    skillWorkerMap.get(requirement).add(worker);
                }
            }
        }

        // проверям все комбинации работников, очередь используем для промежуточного хранения комбинаций
        Queue<Set<Worker>> queue = new LinkedList<>();
        queue.add(new HashSet<>());
        for (Map.Entry<Skill, List<Worker>> skillListEntry : skillWorkerMap.entrySet()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Worker> currentWorkerSet = queue.poll();
                for (Worker worker : skillListEntry.getValue()) {
                    if (!currentWorkerSet.contains(worker)){
                        Set<Worker> newWorkerSet = new HashSet<>(currentWorkerSet);
                        newWorkerSet.add(worker);
                        queue.add(newWorkerSet);
                        if (newWorkerSet.size() == skillWorkerMap.size()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}