package org.tel.ran._2025_03_13.lesson15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        OuterClass outerClass = new OuterClass("content of outer class");
        OuterClass.NestedClass nestedClass = new OuterClass.NestedClass("content of nested class");
        OuterClass.InnerClass innerClass = outerClass.new InnerClass("content of inner class");
        outerClass.anonymousClassExample();
        int a = 5;

        SomeClass anonymousObject1 = new SomeClass("some field") {
            @Override
            public void doSomething() {
                System.out.println(a);
            }
        };

        SomeClass anonymousObject2 = new SomeClass("some field") {
            @Override
            public void doSomething() {
                System.out.println(a);
            }

            public void method() {
                System.out.println("do method stuff");
            }
        };

        anonymousObject1.doSomething();
        System.out.println(anonymousObject1.getClass());
        System.out.println(anonymousObject2.getClass());

        System.out.println(anonymousObject1 instanceof SomeClass);


        Class<?> myAnonymousClass = anonymousObject2.getClass();
        Method methods = myAnonymousClass.getMethod("method", null);
        methods.invoke(anonymousObject2, null);
    }
}
