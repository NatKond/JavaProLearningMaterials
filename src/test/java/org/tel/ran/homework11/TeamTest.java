package org.tel.ran.homework11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    private final Team TEAM = new Team(List.of(
            new Worker("John Smith", Set.of(Skill.ARCHITECT, Skill.CIVIL_ENGINEER)),
            new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
            new Worker("Michael Brown", Set.of(Skill.ECONOMIST)),
            new Worker("Emma Davis", Set.of(Skill.CONCRETE_WORKER))),
            1500);

    @Test
    void meetsRequirementsPositiveTest() {
        Assertions.assertTrue(TEAM.meetsRequirements(Set.of(Skill.ROOFER,Skill.CARPENTER,Skill.CONCRETE_WORKER)));
    }

    @Test
    void meetsRequirementsNegativeTest() {
        Assertions.assertFalse(TEAM.meetsRequirements(Set.of(Skill.ROOFER,Skill.CARPENTER,Skill.CONCRETE_WORKER, Skill.CRANE_OPERATOR)));
    }

    @Test
    void meetsRequirementsAdvancedPositiveTest() {
        Assertions.assertTrue(TEAM.meetsRequirementsAdvanced(Set.of(Skill.ROOFER,Skill.CONCRETE_WORKER,Skill.ARCHITECT)));
    }

    @Test
    void meetsRequirementsAdvancedNegativeTest() {
        Assertions.assertFalse(TEAM.meetsRequirementsAdvanced(Set.of(Skill.ROOFER,Skill.CARPENTER,Skill.ARCHITECT)));
    }
}
