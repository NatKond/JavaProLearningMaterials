package org.tel.ran.homework11;

import java.util.*;

public class AdvanceTeamCheckerIterative implements TeamChecker{

    @Override
    public boolean meetsTeamRequirements(Team team, List<Skill> requirements) {
        if (requirements == null || requirements.isEmpty()
                || !team.getAllSkills().containsAll(requirements)
                || team.getWorkerList().size() < requirements.size()) {
            return false;
        }

        List<Worker> workers = team.getWorkerList();

        Queue<List<Skill>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (Worker worker : workers) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Skill> currentSkillSet = queue.poll();

                for (Skill skill : worker.getSkills()) {
                    if (requirements.contains(skill)) {
                        List<Skill> newSkillSet = new ArrayList<>(Objects.requireNonNull(currentSkillSet));
                        newSkillSet.add(skill);

                        if (newSkillSet.size() != workers.size()) {
                            queue.add(newSkillSet);
                        } else if (newSkillSet.equals(requirements)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
