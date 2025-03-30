package org.tel.ran.homework08;

import java.util.Map;

public class ValidationSystem {
    private static final Map<Class<?>, Validator<?>> VALIDATOR_MAP = Map.of(
            String.class, o -> {
                String s = (String) o;
                if (!s.matches("^[A-Z].*")) {
                    throw new ValidationFailedException("The string " + s + " is invalid.");
                }
            },
            Integer.class, o -> {
                Integer i = (Integer) o;
                if (i < 1 || i > 10) {
                    throw new ValidationFailedException("The number " + i + " is invalid.");
                }
            },
            Character.class, o -> {
                Character c = (Character) o;
                if (c < (int)'0' || c > (int)'9') {
                    throw new ValidationFailedException("The character " + c + " is invalid.");
                }
            });

    @SuppressWarnings("unchecked")
    public <T> void validate(T t) {
        Validator<T> consumer = (Validator<T>) VALIDATOR_MAP.get(t.getClass());
        consumer.validate(t);

        /*Validator<T> validator = (Validator<T>) VALIDATOR_MAP.get(t.getClass());
        validator.validate(t);
        */
    }
}
