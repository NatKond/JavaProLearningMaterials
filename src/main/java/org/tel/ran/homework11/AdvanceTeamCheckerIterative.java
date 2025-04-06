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

        List<Worker> workerListCopy = new ArrayList<>(team.getWorkerList());
        List<Skill> requirementsCopy = new ArrayList<>(requirements);
        Map<Boolean, List<Worker>> countNumberOfSkills = Map.of(true, new ArrayList<>(), false, new ArrayList<>());
        do
        { // строим мапу  со значениями true - если у работника только один нужный навык, false - если у работника больше одного нужного навыка
            countNumberOfSkills.get(true).clear();
            countNumberOfSkills.get(false).clear();
            for (Worker worker : workerListCopy) {
                int countSkills = 0;
                for (Skill requirement : requirementsCopy) {
                    if (worker.getSkills().contains(requirement)) {
                        countSkills++;
                    }
                }
                if (countSkills != 0) {
                    countNumberOfSkills.get(countSkills == 1).add(worker);
                }
            } // работников с одним нужным навыком удаляем из списка работников, навык так же удаляем из списка требований
            for (Worker worker : countNumberOfSkills.get(true)) {
                for (Skill requirement : requirementsCopy) {
                    if (worker.getSkills().contains(requirement)) {
                        requirementsCopy.remove(requirement);
                        break;
                    }
                }
            }
            workerListCopy.clear();
            workerListCopy.addAll(countNumberOfSkills.get(false));
        } while (!requirementsCopy.isEmpty() && !countNumberOfSkills.get(true).isEmpty());

        Queue<List<Skill>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (Worker worker : workerListCopy) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<Skill> currentSkillSet = queue.poll();

                for (Skill skill : worker.getSkills()) {
                    if (requirementsCopy.contains(skill)) {
                        List<Skill> newSkillSet = new ArrayList<>(Objects.requireNonNull(currentSkillSet));
                        newSkillSet.add(skill);

                        if (newSkillSet.size() != workerListCopy.size()) {
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
