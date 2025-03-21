package org.tel.ran.homework11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvanceTeamCheckerRecursive implements TeamChecker {

    @Override
    public boolean meetsTeamRequirements(Team team, Tender tender) {
        if (tender.getRequirements() == null || tender.getRequirements().isEmpty()
                || !team.getAllSkills().containsAll(tender.getRequirements())
                || team.getWorkerList().size() < tender.getRequirements().size()) {
            return false;
        }

        return checkCombinations(team.getWorkerList(), 0, new HashSet<>(), tender.getRequirements());
    }

    private boolean checkCombinations(List<Worker> workers, int index, Set<Skill> currentSet, Set<Skill> requirements) {
        if (index == workers.size()) {
            return currentSet.containsAll(requirements);
        }

        for (Skill skill : workers.get(index).getSkills()) {
            if (requirements.contains(skill) && !currentSet.contains(skill)) {
                currentSet.add(skill);
                if (checkCombinations(workers, index + 1, currentSet, requirements)) return true;
                currentSet.remove(skill);
            }
        }
        return false;
    }
}
