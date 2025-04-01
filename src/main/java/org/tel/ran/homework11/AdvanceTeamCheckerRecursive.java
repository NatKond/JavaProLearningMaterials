package org.tel.ran.homework11;

import java.util.*;

public class AdvanceTeamCheckerRecursive implements TeamChecker {

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

        return checkCombinations(workerListCopy, 0, requirementsCopy, new ArrayList<>());
    }

    private boolean checkCombinations(List<Worker> workers, int index, List<Skill> requirements, List<Skill> skills) {
        if (index == workers.size()) {
            return skills.equals(requirements);
        }

        for (Skill skill : workers.get(index).getSkills()) {
            if (requirements.contains(skill)) {
                skills.add(skill);
                if (checkCombinations(workers, index + 1, requirements, skills)) {
                    return true;
                }
                skills.remove(skill);
            }
        }
        return false;
    }
}
