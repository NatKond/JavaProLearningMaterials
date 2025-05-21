package org.tel.ran.homework14;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // System.out.println((0.1 + 0.2));

        Card card = new Card("John Doh", 500,1500);
        Class<?> clazz1 = Class.forName("org.tel.ran.homework14.Card");
        Class<?> clazz2 = Card.class;
        Class<? extends Card> clazz = card.getClass();

        Field name = clazz.getDeclaredField("name");

        System.out.println(name);

        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            System.out.println(declaredField);
//        }

        Method methodGetName = clazz.getMethod("getName");
        System.out.println("Return type: " + methodGetName.getReturnType() + ", parameter types = " + Arrays.toString(methodGetName.getParameterTypes()));

        Method methodSetName = clazz.getMethod("setName", String.class);
        System.out.println("Return type: " + methodSetName.getReturnType() + ", parameter types = " + Arrays.toString(methodSetName.getParameterTypes()));

        Method[] methods = clazz.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }

        Annotation[] annotations = clazz.getAnnotations();
//        for (Annotation annotation : annotations) {
//            System.out.println(annotation);
//        }

    }
}
