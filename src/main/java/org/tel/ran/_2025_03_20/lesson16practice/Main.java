package org.tel.ran._2025_03_20.lesson16practice;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Alice Johnson", 101);
        Student student2 = new Student("Bob Smith", 102);
        Student student3 = new Student("Charlie Brown", 103);

        Converter converter = new ConverterImp();
        System.out.println(converter.convert(student1));

        Converter converterAnonymous = new Converter() {
            @Override
            public String convert(Student student) {
                return "Hey, " + student.getName();
            }
        };
        System.out.println(converterAnonymous.convert(student2));

        Converter converterLambda = s -> "Howdy, " + s.getName();
        System.out.println(converterLambda.convert(student3));
    }
}
