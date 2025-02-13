package org.tel.ran._2025_02_13.lesson09;

public class Main {
    public static void main(String[] args) {
        Example<Integer,String> example = new Example<>();
        example.setField1(1);
        example.setField2("Cat");
        System.out.println("example = " + example);
        Example<Integer,Integer> example1 = new Example<>(1,2);
        System.out.println("example1 = " + example1);
    }
}
