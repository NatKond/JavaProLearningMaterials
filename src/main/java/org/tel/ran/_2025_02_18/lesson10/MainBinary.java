package org.tel.ran._2025_02_18.lesson10;

public class MainBinary {
    public static void main(String[] args) {
        short a = 5;  // 101 в двоичном виде
        short b = 7;  // 011 в двоичном виде

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        System.out.println("a & b  = " + (a & b) + " = " + Integer.toBinaryString(a & b));
        System.out.println("b & a  = " + (b & a) + " = " + Integer.toBinaryString(b & a));
        System.out.println("a | b  = " + (a | b) + " = " + Integer.toBinaryString(a | b));
        System.out.println("a ^ b  = " + (a ^ b) + " = " + Integer.toBinaryString(a ^ b));
        System.out.println("~a     = " + ~a + " = " + Integer.toBinaryString(~a));
        System.out.println("~b     = " + ~b + " = " + Integer.toBinaryString(~b));

        System.out.println("a << 1 = " + (a << 1) + " = " + Integer.toBinaryString(a << 1));
        System.out.println("b << 1 = " + (b << 1) + " = " + Integer.toBinaryString(b << 1));
        System.out.println("a >> 1 = " + (a >> 1) + " = " + Integer.toBinaryString(a >> 1));
        System.out.println("b >> 1 = " + (b >> 1) + " = " + Integer.toBinaryString(b >> 1));
        System.out.println("~a >> 1 = " + (~a >> 1) + " = " + Integer.toBinaryString(~a >> 1));
        System.out.println("~a >>> 1 = " + (~a >>> 1) + " = " + Integer.toBinaryString(~a >>> 1));
        System.out.println("~b >>> 1 = " + (~b >>> 16) + " = " + Integer.toBinaryString(~b >>> 16));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE + 1));
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE + Integer.MAX_VALUE));
    }
}
