package org.tel.ran.homework11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

class AdvanceTeamCheckerTest {

    private final TeamChecker ADVANCE_TEAM_CHECKER = new AdvanceTeamChecker();

    private final List<Worker> WORKERS = Arrays.asList(
            new Worker("John Smith", Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER)),
            new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
            new Worker("Michael Brown", Set.of(Skill.CARPENTER, Skill.CONCRETE_WORKER)),
            new Worker("Emma Davis", Set.of(Skill.CRANE_OPERATOR))
    );

    private final Tender TENDER = new Tender(Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.CONCRETE_WORKER, Skill.CRANE_OPERATOR));

    @Test
    void meetsTeamRequirements(){
        Team team = new Team(WORKERS, 1500);
        Assertions.assertTrue(ADVANCE_TEAM_CHECKER.meetsTeamRequirements(team,TENDER));
    }

}