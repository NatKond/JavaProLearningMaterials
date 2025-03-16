package org.tel.ran.homework11;

import org.junit.jupiter.api.Assertions;
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
    void addWorker() {
        // given
        Team expected = new Team(List.of(
                new Worker("John Smith", Set.of(Skill.ARCHITECT, Skill.CIVIL_ENGINEER)),
                new Worker("Alice Johnson", Set.of(Skill.ROOFER, Skill.CARPENTER, Skill.PAINTER_PLASTERER)),
                new Worker("Michael Brown", Set.of(Skill.ECONOMIST)),
                new Worker("Emma Davis", Set.of(Skill.CONCRETE_WORKER)),
                new Worker("Robert Wilson", Set.of(Skill.TECHNOLOGIST, Skill.MASTER_OF_CONSTRUCTION_AND_INSTALLATION_WORKS))),
                1500);

        // when
        TEAM.addWorker( new Worker("Robert Wilson", Set.of(Skill.TECHNOLOGIST, Skill.MASTER_OF_CONSTRUCTION_AND_INSTALLATION_WORKS)));
        //then
        Assertions.assertEquals(expected,TEAM);
    }

    @Test
    void meetsRequirements() {
        Assertions.assertTrue(TEAM.meetsRequirements(Set.of(Skill.ROOFER,Skill.CARPENTER,Skill.CONCRETE_WORKER)));
    }
}