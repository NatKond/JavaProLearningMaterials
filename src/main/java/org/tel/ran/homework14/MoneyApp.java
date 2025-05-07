package org.tel.ran.homework14;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MoneyApp {
    public static void main(String[] args) {
        Card card = new Card("John Doh", 500,1500);

        Class<? extends Card> clazz = card.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
