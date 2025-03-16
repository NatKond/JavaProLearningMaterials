package org.tel.ran._2025_03_13.lesson15;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OuterClass {
    private static String outerStaticField = "content of outer static field";
    private String outerField;

    public OuterClass(String outerField) {
        this.outerField = outerField;
    }

    public void anonymousClassExample() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int a = 5;
        SomeClass someClass = new SomeClass("Harry! ") {
            @Override
            public void doSomething() {
                System.out.println(someField + a);
            }

            public void method() {
                System.out.println("Hello " + a);
            }
        };
        someClass.doSomething();

        SomeClass someClass1 = new SomeClass("Ron");
    }

    public void localClassExample() {
        final int localOuter1 = 1;
        int localOuter2 = 2;

        class LocalClass {
            private static String localStaticField = "content of local static field";
            private String localField;

            public LocalClass(String localField) {
                this.localField = localField;
            }

            private static void localStaticMethod() {
                // нельзя обращаться к локальной переменной
            }

            private void localMethod() {
                // может обращатьяс к локальным перменным
                System.out.println(localOuter1);
                System.out.println(localOuter2);
            }

            LocalClass localClass1 = new LocalClass("content of local class");
            LocalClass localClass2 = new LocalClass("content of local class");


        }
    }

    public static void outerStaticMethod() {
        // обращение к полям и методам внешнего класса
        System.out.println(outerStaticField);
        // обращение к полям и методам вложенного статического класса
        System.out.println(NestedClass.nestedStaticField);
        NestedClass.nestedStaticMethod();

        NestedClass nestedClass = new NestedClass("content of nested field");
        System.out.println(nestedClass.nestedField);
        nestedClass.nestedMethod();
    }

    public void outerMethod() {
        System.out.println(outerStaticField);
        System.out.println(outerField);
        outerStaticMethod();

        // обращение к полям и методам внутреннего класса
        InnerClass innerClass = new InnerClass("content of inner class");
        innerClass.innerMethod();
    }

    public static class NestedClass {
        private static String nestedStaticField = "content of outer static class";
        private String nestedField;

        public NestedClass(String nestedField) {
            this.nestedField = nestedField;
        }

        private static void nestedStaticMethod() {
            // обращение к полям и методам внешнего класса
            System.out.println(outerStaticField);
            outerStaticMethod();
            OuterClass.outerStaticMethod();

            // обращение к полям и методам внутреннего класса
            OuterClass outerClass = new OuterClass("content of outer class");
            InnerClass.innerStaticMethod();

            // Нельзя создать экземплят внутреннего класса
        }

        private void nestedMethod() {
            // обращение к полям и методам внешнего класса
            System.out.println(outerStaticField);
            System.out.println(nestedStaticField);
            System.out.println(nestedField);
            outerStaticMethod();

            // обращение к полям и методам внутреннего класса
            OuterClass outerClass = new OuterClass("content of outer class");

            // Нельзя создать экземплят внутреннего класса
        }
    }

    public class InnerClass {
        private static String innerStaticField = "content of outer static class";
        private String innerField;

        public InnerClass(String innerField) {
            this.innerField = innerField;
        }

        private static void innerStaticMethod() {
            // обращение к полям и методам внешнего класса
            System.out.println(outerStaticField);
            outerStaticMethod();
            OuterClass.outerStaticMethod();
        }

        private void innerMethod() {
            System.out.println(outerStaticField);
            System.out.println(outerField);
            System.out.println(innerStaticField);
            System.out.println(innerField);
            outerStaticMethod();
        }
    }
}
