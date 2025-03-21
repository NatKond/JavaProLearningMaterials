package org.tel.ran.homework11;

import java.util.*;

public class AdvanceTeamCheckerMap implements TeamChecker{

    @Override
    public boolean meetsTeamRequirements(Team team, Tender tender) {
        if (tender.getRequirements() == null || tender.getRequirements().isEmpty()
                || !team.getAllSkills().containsAll(tender.getRequirements())
                || team.getWorkerList().size() < tender.getRequirements().size()) {
            return false;
        }

        List<Worker> workerListCopy = new ArrayList<>(team.getWorkerList());
        Set<Skill> requirementsCopy = new HashSet<>(tender.getRequirements());
        Map<Boolean, List<Worker>> countNumberOfSkills = Map.of(true, new ArrayList<>(), false, new ArrayList<>());
        do
        { // строим мапу  со значениями true - если у работника только один нужный навык, false - если у работника больше одного нужного навыка
            countNumberOfSkills.get(true).clear();
            countNumberOfSkills.get(false).clear();
            for (Worker worker : workerListCopy) {
                int countSkills = 0;
                for (Skill requirement : requirementsCopy) {
                    if (worker.getSkills().contains(requirement)) {
                        countSkills++;
                    }
                }
                if (countSkills != 0) {
                    countNumberOfSkills.get(countSkills == 1).add(worker);
                }
            } // работников с одним нужным навыком удаляем из списка работников, навык так же удаляем из списка требований
            for (Worker worker : countNumberOfSkills.get(true)) {
                for (Skill requirement : requirementsCopy) {
                    if (worker.getSkills().contains(requirement)) {
                        requirementsCopy.remove(requirement);
                        break;
                    }
                }
            }
            workerListCopy.clear();
            workerListCopy.addAll(countNumberOfSkills.get(false));
        } while (!requirementsCopy.isEmpty() && !countNumberOfSkills.get(true).isEmpty());

        // создаем мапу, в которой работники распределены по уменям
        Map<Skill, List<Worker>> skillWorkerMap = new HashMap<>();
        for (Skill requirement : requirementsCopy) {
            skillWorkerMap.put(requirement, new ArrayList<>());
            for (Worker worker : workerListCopy) {
                if (worker.getSkills().contains(requirement)) {
                    skillWorkerMap.get(requirement).add(worker);
                }
            }
        }

        // проверям все комбинации работников, очередь используем для промежуточного хранения комбинаций
        Queue<Set<Worker>> queue = new LinkedList<>();
        queue.add(new HashSet<>());
        for (Map.Entry<Skill, List<Worker>> skillListEntry : skillWorkerMap.entrySet()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Set<Worker> currentWorkerSet = queue.poll();
                for (Worker worker : skillListEntry.getValue()) {
                    if (!currentWorkerSet.contains(worker)){
                        Set<Worker> newWorkerSet = new HashSet<>(currentWorkerSet);
                        newWorkerSet.add(worker);
                        queue.add(newWorkerSet);
                        if (newWorkerSet.size() == skillWorkerMap.size()){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
