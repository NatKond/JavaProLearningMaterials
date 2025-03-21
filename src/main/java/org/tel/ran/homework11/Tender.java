package org.tel.ran.homework11;

import java.util.*;

public class Tender {

    private final Map<TeamCheck, TeamChecker> TEAM_CHECKER_MAP = Map.of(TeamCheck.REGULAR, new RegularTeamChecker(),
            TeamCheck.ADVANCE_RECURSIVE, new AdvanceTeamCheckerRecursive(),
            TeamCheck.ADVANCE_ITERATIVE, new AdvanceTeamCheckerIterative(),
            TeamCheck.ADVANCE_MAP, new AdvanceTeamCheckerMap());

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

    public Team chooseTeam(TeamCheck teamCheck, Team... teams) {
        TeamChecker teamChecker = TEAM_CHECKER_MAP.get(teamCheck);
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
