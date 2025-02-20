package org.tel.ran.homework08;

public class StringValidator extends Validator<String> {
    @Override
    public void validate(String s) {
        if (!s.matches("^[A-Z].*")) {
            throw new ValidationFailedException("The string " + s + " is invalid.");
        }
    }
}
