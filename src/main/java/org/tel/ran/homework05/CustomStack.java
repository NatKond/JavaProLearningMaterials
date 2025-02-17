package org.tel.ran.homework05;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * На основе библиотечного класса LinkedList реализовать такую структуру данных, как стек:
 * Создать класс CustomStack с методами push(), pop(), peek(). Протестировать работу класса.
 */

public class CustomStack <T>{

    private LinkedList <T> data = new LinkedList<>();

    public void push(T element){
        data.addFirst(element);
    }

    public T pop(){
        if (data.isEmpty())
            throw new NoSuchElementException();
        return data.pop();
    }

    public T peek(){
        if (data.isEmpty())
            throw new NoSuchElementException();
        return data.peek();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
