package org.tel.ran.homework11;

import java.util.Set;

public class RegularTeamChecker implements TeamChecker{
    @Override
    public boolean meatsTeamRequirements(Team team, Tender tender) {
        Set<Skill> requirements = tender.getRequirements();
        if (requirements == null || requirements.isEmpty()) {
            return false;
        }
        return team.getAllSkills().containsAll(requirements);
    }
}
