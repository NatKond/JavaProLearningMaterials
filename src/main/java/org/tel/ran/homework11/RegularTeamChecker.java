package org.tel.ran.homework11;

import java.util.List;
import java.util.Set;

public class RegularTeamChecker implements TeamChecker{
    @Override
    public boolean meetsTeamRequirements(Team team, List<Skill> requirements) {
        if (requirements == null || requirements.isEmpty()) {
            return false;
        }
        return team.getAllSkills().containsAll(requirements);
    }
}
