package com.interview.crack;

import java.util.Stack;

public class Problem_3_2 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(2);
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.push(3);
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.push(1);
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.push(5);
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack);
        System.out.println(minStack.min());

        minStack.push(-10);
        System.out.println(minStack);
        System.out.println(minStack.min());
    }

    private static class MinStack {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> helpStack = new Stack<>();

        public int push(int value) {
            if (helpStack.empty()) {
                helpStack.push(value);
            } else if (helpStack.peek() > value) {
                helpStack.push(value);
            } else {
                helpStack.push(helpStack.peek());
            }

            return dataStack.push(value);
        }

        public int pop() {
            helpStack.pop();
            return dataStack.pop();
        }

        public int min() {
            return helpStack.peek();
        }

        @Override
        public String toString() {
            return dataStack.toString();
        }
    }
}
