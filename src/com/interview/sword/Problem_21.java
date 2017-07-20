package com.interview.sword;

import java.util.Stack;

/**
 * Created by weiqianghu on 17-7-15.
 */
public class Problem_21 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        System.out.println(minStack.min());

        minStack.push(4);
        System.out.println(minStack.min());

        minStack.push(2);
        System.out.println(minStack.min());

        minStack.push(2);
        System.out.println(minStack.min());

        minStack.pop();
        System.out.println(minStack.min());

        minStack.push(0);
        System.out.println(minStack.min());

        minStack.pop();
        minStack.pop();
        System.out.println(minStack.min());
    }


    private static class MinStack {
        private Stack<Integer> dataStack = new Stack<>();
        private Stack<Integer> helpStack = new Stack<>();

        public Integer push(Integer item) {
            if (helpStack.empty()) {
                helpStack.push(item);
            } else {
                helpStack.push(helpStack.peek() < item ? helpStack.peek() : item);
            }
            dataStack.push(item);

            return item;
        }

        public Integer pop() {
            helpStack.pop();
            return dataStack.pop();
        }

        public Integer peek() {
            return dataStack.peek();
        }

        public Integer min() {
            return helpStack.peek();
        }
    }
}
