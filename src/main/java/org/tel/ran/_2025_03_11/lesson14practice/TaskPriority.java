package org.tel.ran._2025_03_11.lesson14practice;

import static org.tel.ran.textFormatting.*;

public enum TaskPriority {
    LOW {
        @Override
        public String toString() {
            return RED + this.name() + RESET;
        }
    },
    MEDIUM {
        @Override
        public String toString() {
            return BRIGHT_YELLOW + this.name() + RESET;
        }
    },
    HIGH {
        @Override
        public String toString() {
            return BRIGHT_GREEN + this.name() + RESET;
        }
    };

    @Override
    public abstract String toString();
}
