package com.interview.crack;

import java.util.Stack;

public class Problem_3_6 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(9);
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(5);
        stack.push(8);
        System.out.println(stack);
        sort(stack);
        System.out.println(stack);
    }

    private static void sort(Stack<Integer> stack) {
        if (stack == null || stack.size() < 2) {
            return;
        }

        Stack<Integer> helpStack = new Stack<>();
        while (!stack.empty()) {
            Integer temp = stack.pop();
            while (!helpStack.empty() && temp > helpStack.peek()) {
                stack.push(helpStack.pop());
            }
            helpStack.push(temp);
        }

        while (!helpStack.empty()) {
            stack.push(helpStack.pop());
        }

    }
}
