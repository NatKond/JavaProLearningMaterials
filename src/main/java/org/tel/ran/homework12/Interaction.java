package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.Objects;

public class Interaction {
    private final InteractionType type;
    private final Content content;
    private final LocalDate localDate;
    private final String comment;

    public Interaction(Builder builder) {
        this.type = builder.type;
        this.content = builder.content;
        this.localDate = builder.localDate;
        this.comment = builder.comment;
    }

    public static Builder builder(Content content, InteractionType type) {
        return new Builder(content, type);
    }

    public InteractionType getType() {
        return type;
    }


    public Content getContent() {
        return content;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Interaction that = (Interaction) object;
        return type == that.type && Objects.equals(content, that.content) && Objects.equals(localDate, that.localDate) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, content, localDate, comment);
    }

    @Override
    public String toString() {
        return type +
                ": " +
                ", " + content +
                ", date: " + localDate;
    }

    public static class Builder {
        private final InteractionType type;
        private final Content content;
        private LocalDate localDate;
        private String comment;

        public Builder(Content content, InteractionType type) {
            this.content = content;
            this.type = type;
        }

        public Builder localDate(LocalDate localDate) {
            this.localDate = localDate;
            return this;
        }

        public Builder comment(String comment) {
            if (type.equals(InteractionType.COMMENT)) {
                this.comment = comment;
            }
            return this;
        }

        public Interaction build() {
            return new Interaction(this);
        }
    }
}
