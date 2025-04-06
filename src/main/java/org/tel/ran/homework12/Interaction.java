package org.tel.ran.homework12;

import java.time.LocalDate;
import java.util.Objects;

public class Interaction {
    private InteractionType type;
    private User user;
    private Content content;
    private LocalDate localDate;
    private String comment;

    public Interaction(Builder builder) {
        this.type = builder.type;
        this.user = builder.user;
        this.content = builder.content;
        this.localDate = builder.localDate;
        this.comment = builder.comment;
    }

    public static Builder builder(User user, Content content, InteractionType type) {
        return new Builder(user, content, type);
    }

    public InteractionType getType() {
        return type;
    }

    public User getUser() {
        return user;
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
        return type == that.type && Objects.equals(user, that.user) && Objects.equals(content, that.content) && Objects.equals(localDate, that.localDate) && Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, user, content, localDate, comment);
    }

    @Override
    public String toString() {
        return type +
                ": " + user +
                ", " + content +
                ", date: " + localDate;
    }

    public static class Builder {
        private InteractionType type;
        private User user;
        private Content content;
        private LocalDate localDate;
        private String comment;

        public Builder(User user, Content content, InteractionType type) {
            this.user = user;
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
