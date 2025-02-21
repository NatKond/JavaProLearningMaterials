package org.tel.ran.homework08;

import java.util.Map;

public class ValidationSystem {
    private static final Map<Class<?>, Validator<?>> VALIDATOR_MAP = Map.of(String.class, new StringValidator(), Integer.class, new IntegerValidator(), Character.class, new CharacterValidator());

    @SuppressWarnings("unchecked")
    public static <T> void validate(T t) {
        Validator<T> validator = (Validator<T>) VALIDATOR_MAP.get(t.getClass());
        validator.validate(t);
        /*if (t instanceof String) {
            Validator<String> stringValidator = new StringValidator();
            stringValidator.validate((String) t);
        } else if (t instanceof Integer) {
            Validator<Integer> stringValidator = new IntegerValidator();
            stringValidator.validate((Integer) t);
        } else if (t instanceof Character) {
            Validator<Character> stringValidator = new CharacterValidator();
            stringValidator.validate((Character) t);
        }*/
    }
}
