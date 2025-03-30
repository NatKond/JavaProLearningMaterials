package org.tel.ran.homework11;

import java.util.*;

public class Tender {

    private List<Skill> requirements;

    public Tender() {
        this(new ArrayList<>());
    }

    public Tender(List<Skill> requirements) {
        this.requirements = requirements;
    }

    public void addRequirement(Skill... skills) {
        requirements.addAll(Arrays.asList(skills));
    }

    public List<Skill> getRequirements() {
        return requirements;
    }

    public Team chooseTeam(CheckType checkType, Team... teams) {
        TeamChecker teamChecker = checkType.getTeamChecker();
        Team choosenTeam = null;
        double minBitAmount = Double.MAX_VALUE;

        for (Team team : teams) {
            if (team != null && teamChecker.meetsTeamRequirements(team, requirements) && team.getBidAmount() < minBitAmount) {
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
