package org.tel.ran._2025_03_11.lesson14practice;

import static org.tel.ran.textFormatting.*;

public enum Status {
    TODO("The task is planned but has not been started yet") {
        @Override
        public String toString() {
            return BLUE + this.name() + " (" + this.getDescription() + ")" + RESET;
        }
    },
    IN_PROGRESS("The task is currently being worked on") {
        @Override
        public String toString() {
            return YELLOW + this.name() + " (" + this.getDescription() + ")" + RESET;
        }
    },
    COMPLETED("The task has been successfully finished and closed") {
        @Override
        public String toString() {
            return GREEN + this.name() + " (" + this.getDescription() + ") " + RESET ;
        }
    };

    private String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public abstract String toString();
}


