package org.tel.ran.homework08;

public class CharacterValidator extends Validator<Character> {
    @Override
    public void validate(Character character) {
        if (character < 48 || character > 57) {
            throw new ValidationFailedException("The character " + character + " is invalid.");
        }
    }
}
