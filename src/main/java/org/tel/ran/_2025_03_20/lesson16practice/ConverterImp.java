package org.tel.ran._2025_03_20.lesson16practice;

public class ConverterImp implements Converter {

    @Override
    public String convert(Student student) {
        return "Hello, " + student.getName();
    }
}
