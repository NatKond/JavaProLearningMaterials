package org.tel.ran.homework11;

import java.util.*;

public class Tender {

    private final Map<Boolean, TeamChecker> TEAM_CHECKER_MAP = Map.of(false, new RegularTeamChecker(), true, new AdvanceTeamChecker());

    private Set<Skill> requirements;

    public Tender() {
        this(new HashSet<>());
    }

    public Tender(Set<Skill> requirements) {
        this.requirements = requirements;
    }

    public void addRequirement(Skill... skills) {
        requirements.addAll(Arrays.asList(skills));
    }

    public Set<Skill> getRequirements() {
        return requirements;
    }

    public Team chooseTeam(boolean useAdvance, Team... teams) {
        TeamChecker teamChecker = TEAM_CHECKER_MAP.get(useAdvance);
        Team choosenTeam = null;
        double minBitAmount = Double.MAX_VALUE;

        for (Team team : teams) {
            if (team != null && teamChecker.meetsTeamRequirements(team, this) && team.getBidAmount() < minBitAmount) {
                choosenTeam = team;
                minBitAmount = team.getBidAmount();
            }
        }

        if (choosenTeam == null) {
            throw new NoSuitableTeamException("There is no suitable team.");
        }
        return choosenTeam;
    }
}
