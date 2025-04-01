package org.tel.ran.homework08;

@FunctionalInterface
public interface Validator<E> {
    void validate(E e);
}
