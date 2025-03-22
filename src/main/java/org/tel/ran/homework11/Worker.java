package org.tel.ran.homework11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Worker {
    private String name;
    private Set<Skill> skills;
    private boolean isAssigned = false;

    public Worker(String name) {
        this(name, new HashSet<>());
    }

    public Worker(String name, Set<Skill> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    public void assign (){
        isAssigned = true;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void reassign(){
        isAssigned = false;
    }

    public void addSkill(Skill... skillsToAdd) {
        skills.addAll(Arrays.asList(skillsToAdd));
    }

    public boolean hasSkill(Skill requiredSkill) {
        return skills.contains(requiredSkill);
    }

    @Override
    public String toString() {
        return "\n" + name + ": " + skills;
    }
}
