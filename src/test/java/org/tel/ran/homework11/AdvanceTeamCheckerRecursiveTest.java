package org.tel.ran.homework11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

class AdvanceTeamCheckerRecursiveTest {

    private final TeamChecker ADVANCE_TEAM_CHECKER = new AdvanceTeamCheckerRecursive();

    private final Team TEAM = new Team(new ArrayList<>(Arrays.asList(
            new Worker("John Smith", Set.of(Skill.ROOFER, Skill.CONCRETE_WORKER)),
            new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
            new Worker("Michael Brown", Set.of(Skill.CARPENTER, Skill.CONCRETE_WORKER)),
            new Worker("Emma Davis", Set.of(Skill.CRANE_OPERATOR)))), 1500
    );

    private final Tender TENDER = new Tender();

    @BeforeEach
    void init() {
        TENDER.addRequirement(Skill.ROOFER, Skill.CARPENTER, Skill.CONCRETE_WORKER, Skill.CRANE_OPERATOR);
    }
    @Test
    void meetsTeamRequirementsPositiveCaseTest(){
        Assertions.assertTrue(ADVANCE_TEAM_CHECKER.meetsTeamRequirements(TEAM,TENDER));
    }

    @Test
    void meetsTeamRequirementsNoSkillCaseTest() {
        TENDER.addRequirement(Skill.ARCHITECT);
        Assertions.assertFalse(ADVANCE_TEAM_CHECKER.meetsTeamRequirements(TEAM,TENDER));
    }

    @Test
    void meetsTeamRequirementsNoWorkerCaseTest() {
        TENDER.addRequirement(Skill.PAINTER_PLASTERER);
        Assertions.assertFalse(ADVANCE_TEAM_CHECKER.meetsTeamRequirements(TEAM,TENDER));
    }

    @Test
    void meetsTeamRequirementsNoWorkerWithSkillCaseTest() {
        TENDER.addRequirement(Skill.PAINTER_PLASTERER);
        TEAM.addWorker(new Worker("Robert Wilson", Set.of(Skill.TECHNOLOGIST)));
        Assertions.assertFalse(ADVANCE_TEAM_CHECKER.meetsTeamRequirements(TEAM,TENDER));
    }
}
