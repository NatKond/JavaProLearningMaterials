package org.tel.ran.homework05;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        CustomStack<String> stringCustomStack = new CustomStack<>();
        stringCustomStack.push("Hello");
        stringCustomStack.push("Hi!");
        stringCustomStack.push("Goodbye");
        System.out.println("stringCustomStack = " + stringCustomStack);
        System.out.println("stringCustomStack.pop() = " + stringCustomStack.pop());
        System.out.println("stringCustomStack = " + stringCustomStack);
        System.out.println("stringCustomStack.peek() = " + stringCustomStack.peek());
        System.out.println("stringCustomStack = " + stringCustomStack);
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("Bye");
        stack.push("Hi!");
        System.out.println("stack = " + stack);
    }
}
