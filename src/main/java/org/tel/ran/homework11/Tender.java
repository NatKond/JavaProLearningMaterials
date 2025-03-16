package org.tel.ran.homework11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tender {

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

    public Team chooseTeam(Team... teams) {
        if (teams.length == 0) {
            throw new NoSuitableTeamException("There are no teams in the list.");
        }

        Team choosenTeam = null;
        double minBitAmount = Double.MAX_VALUE;
        for (Team team : teams) {
            if (team != null && team.meetsRequirements(requirements) && team.getBidAmount() < minBitAmount) {
                choosenTeam = team;
                minBitAmount = team.getBidAmount();
            }
        }
        if (choosenTeam == null) {
            throw new NoSuitableTeamException("There is no suitable team.");
        }
        return choosenTeam;
    }

    public Team chooseTeamAdvanced(Team... teams) {
        if (teams.length == 0) {
            throw new NoSuitableTeamException("There are no teams in the list.");
        }
        Team choosenTeam = null;
        double minBitAmount = Double.MAX_VALUE;
        for (Team team : teams) {
            if (team != null && team.meetsRequirementsAdvanced(requirements) && team.getBidAmount() < minBitAmount) {
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
