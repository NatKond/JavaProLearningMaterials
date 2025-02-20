package org.tel.ran.homework08;

public class ValidationSystem{
    public static <T> void validate(T t) {
        if (t instanceof String){
            Validator<String> stringValidator = new StringValidator();
            stringValidator.validate((String) t);
        } else if (t instanceof Integer) {
            Validator<Integer> stringValidator = new IntegerValidator();
            stringValidator.validate((Integer) t);
        } else if (t instanceof Character) {
            Validator<Character> stringValidator = new CharacterValidator();
            stringValidator.validate((Character) t);
        }
    }
}
