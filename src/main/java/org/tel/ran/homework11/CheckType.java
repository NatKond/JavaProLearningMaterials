package org.tel.ran.homework11;

public enum CheckType {
    REGULAR(new RegularTeamChecker()),
    ADVANCE_RECURSIVE(new AdvanceTeamCheckerRecursive()),
    ADVANCE_ITERATIVE(new AdvanceTeamCheckerIterative());

    final TeamChecker teamChecker;

    CheckType(TeamChecker teamChecker) {
        this.teamChecker = teamChecker;
    }

    TeamChecker getTeamChecker(){
        return teamChecker;
    }
}
