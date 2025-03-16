package org.tel.ran.homework11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class TenderTest {
    private final Team TEAM_1 = new Team(List.of(
            new Worker("John Smith", Set.of(Skill.ARCHITECT, Skill.CIVIL_ENGINEER)),
            new Worker("Alice Johnson", Set.of(Skill.ROOFER)),
            new Worker("Michael Brown", Set.of(Skill.CARPENTER)),
            new Worker("Emma Davis", Set.of(Skill.CONCRETE_WORKER)),
            new Worker("Robert Wilson", Set.of(Skill.TECHNOLOGIST, Skill.PAINTER_PLASTERER))),
            1500);

    private final Team TEAM_2 = new Team(List.of(
            new Worker("Sophia Miller", Set.of(Skill.SURVEYOR, Skill.CONCRETE_WORKER)),
            new Worker("James Anderson", Set.of(Skill.ARCHITECT)),
            new Worker("Olivia Thomas", Set.of(Skill.ROOFER)),
            new Worker("William Martinez", Set.of(Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
            new Worker("Charlotte Taylor", Set.of(Skill.ECONOMIST))),
            1300);

    private final Tender TENDER = new Tender();

    @BeforeEach
    void init() {
        TENDER.addRequirement(Skill.ROOFER, Skill.CONCRETE_WORKER, Skill.ARCHITECT, Skill.CARPENTER, Skill.PAINTER_PLASTERER);
    }

    @Test
    void chooseTeamPositiveTest() {
        Assertions.assertEquals(TEAM_2, TENDER.chooseTeam(TEAM_1, TEAM_2));
    }

    @Test
    void chooseTeamNegativeTestNoSuitableTeams() {
        TENDER.addRequirement(Skill.CRANE_OPERATOR);
        RuntimeException runtimeException = Assertions.assertThrows(NoSuitableTeamException.class, () -> TENDER.chooseTeam(TEAM_1, TEAM_2));
        Assertions.assertEquals("There is no suitable team.", runtimeException.getMessage());
    }

    @Test
    void chooseTeamNegativeTestNoTeams() {
        RuntimeException runtimeException = Assertions.assertThrows(NoSuitableTeamException.class, () -> TENDER.chooseTeam());
        Assertions.assertEquals("There are no teams in the list.", runtimeException.getMessage());
    }

    @Test
    void chooseTeamAdvancedPositiveTest() {
        Assertions.assertEquals(TEAM_1, TENDER.chooseTeamAdvanced(TEAM_1, TEAM_2));
    }

    @Test
    void chooseTeamAdvancedNegativeTestNoSuitableTeams() {
        TENDER.addRequirement(Skill.CRANE_OPERATOR);
        RuntimeException runtimeException = Assertions.assertThrows(NoSuitableTeamException.class, () -> TENDER.chooseTeamAdvanced(TEAM_1, TEAM_2));
        Assertions.assertEquals("There is no suitable team.", runtimeException.getMessage());
    }

    @Test
    void chooseTeamAdvancedNegativeTestNoTeams() {
        RuntimeException runtimeException = Assertions.assertThrows(NoSuitableTeamException.class, () -> TENDER.chooseTeamAdvanced());
        Assertions.assertEquals("There are no teams in the list.", runtimeException.getMessage());
    }

}