package org.tel.ran.homework11;

import java.util.*;

public class AdvanceTeamCheckerIterative implements TeamChecker{

    @Override
    public boolean meetsTeamRequirements(Team team, Tender tender) {
        if (tender.getRequirements() == null || tender.getRequirements().isEmpty()
                || !team.getAllSkills().containsAll(tender.getRequirements())
                || team.getWorkerList().size() < tender.getRequirements().size()) {
            return false;
        }

        Set<Skill> requirements = tender.getRequirements();
        List<Worker> workers = team.getWorkerList();

        Queue<Set<Skill>> queue = new LinkedList<>();
        queue.add(new HashSet<>());

        for (Worker worker : workers) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Skill> currentSkillSet = queue.poll();

                for (Skill skill : worker.getSkills()) {
                    if (requirements.contains(skill) && !currentSkillSet.contains(skill)) {
                        Set<Skill> newSkillSet = new HashSet<>(currentSkillSet);
                        newSkillSet.add(skill);

                        if (newSkillSet.size() != workers.size()) {
                            queue.add(newSkillSet);
                        } else if (newSkillSet.containsAll(requirements)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
