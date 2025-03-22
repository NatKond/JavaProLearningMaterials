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

        return checkCombinations(team.getWorkerList(), 0, tender);
    }

    private boolean checkCombinations(List<Worker> workers, int index, Tender tender) {
        if (index == workers.size()) {
            return true;
        }

        for (Skill skill : workers.get(index).getSkills()) {
            if (tender.getRequirements().contains(skill) && !skill.hasBeenChecked()) {
                skill.check();
                if (checkCombinations(workers, index + 1, tender)) {
                    return true;
                }
                skill.reset();
            }
        }
        return false;
    }
}
