package com.interview.crack;

import java.util.Stack;

public class Problem_3_5 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.add(1);
        queue.add(2);
        System.out.println(queue);

        queue.add(3);
        queue.get();
        System.out.println(queue);

        queue.add(4);
        queue.get();
        System.out.println(queue);

        queue.add(5);
        queue.get();
        queue.get();
        queue.get();
        System.out.println(queue);

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        queue.get();
        System.out.println(queue);
    }

    private static class CQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public int add(int value) {
            return stack1.push(value);
        }

        public int get() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();

        }

        @Override
        public String toString() {
            return stack1.toString() + "|||" + stack2.toString();
        }
    }
}
