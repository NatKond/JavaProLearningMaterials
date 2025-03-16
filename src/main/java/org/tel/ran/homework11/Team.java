package org.tel.ran.homework11;

import java.util.*;

public class Team {

    private List<Worker> workerList;
    private double bidAmount;

    public Team(double bidAmount) {
        this(new ArrayList<>(), bidAmount);
    }

    public Team(List<Worker> workerList, double bidAmount) {
        this.workerList = workerList;
        this.bidAmount = bidAmount;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount) {
        this.bidAmount = bidAmount;
    }

    public void addWorker(Worker... worker) {
        workerList.addAll(Arrays.asList(worker));
    }

    public boolean meetsRequirements(Set<Skill> requirements) {
        if (requirements == null || requirements.isEmpty()) {
            return false;
        }
        return getAllSkills().containsAll(requirements);
    }

    public boolean meetsRequirementsAdvanced(Set<Skill> requirements) {
        List<Worker> workerListCopy = new ArrayList<>(workerList);
        boolean hasAllSkills = true;
        for (Skill skill : requirements) {
            boolean containSkill = false;
            for (Worker worker: workerListCopy){
                if (worker.getSkills().contains(skill)){
                    containSkill = true;
                    workerListCopy.remove(worker);
                    break;
                }
            }
            if (!containSkill){
                hasAllSkills = false;
                break;
            }
        }
        return hasAllSkills;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Team team = (Team) object;
        return Double.compare(bidAmount, team.bidAmount) == 0 && Objects.equals(workerList, team.workerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerList, bidAmount);
    }

    @Override
    public String toString() {
        return workerList.toString() + "\nbitAmount = " + bidAmount;
    }

    private void resetSkills(){
        for (Worker worker: workerList){
            for (Skill skill: worker.getSkills()){
                skill.reset();
            }
        }
    }

    private Set<Skill> getAllSkills() {
        Set<Skill> skills = new HashSet<>();
        for (Worker worker : workerList) {
            skills.addAll(worker.getSkills());
        }
        return skills;
    }
}
