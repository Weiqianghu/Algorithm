package com.interview;

import java.util.Stack;

/**
 * Created by weiqianghu on 17-7-2.
 */
public class Problem_07 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());

        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());

        cQueue.appendTail(5);
        cQueue.appendTail(6);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());


    }

    private static class CQueue {
        void appendTail(int node) {
            stack1.push(node);
        }

        int deleteHead() {
            if (!stack2.empty()) {
                return stack2.pop();
            }


            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }

            if (stack2.empty()) {
                return -1;
            }

            return stack2.pop();
        }

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();
    }

}
