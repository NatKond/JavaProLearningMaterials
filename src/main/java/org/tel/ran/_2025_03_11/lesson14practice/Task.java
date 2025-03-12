package org.tel.ran._2025_03_11.lesson14practice;

public class Task {

    private String description;

    private Status status;

    private TaskPriority priority;

    public Task(String description, Status status, TaskPriority priority) {
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
            String trimmedDescription = description.length() > 32
            ? description.substring(0, 32)
            : description;

        return  String.format("%-34s %-16s %-16s",
                trimmedDescription,
                priority,
                status);
    }
}
