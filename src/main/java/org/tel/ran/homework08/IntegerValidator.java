package org.tel.ran.homework08;

public class IntegerValidator implements Validator<Integer>{

    @Override
    public void validate(Integer integer) {
        if (integer <1 || integer>10){
            throw new ValidationFailedException("The number " + integer + " is invalid.");
        }
    }
}
