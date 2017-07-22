package com.interview.hy;

import java.util.Stack;

/**
 * Created by weiqianghu on 17-7-22.
 */
public class Problem_01 {
    public static void main(String[] args) {
        int[] ints = {2, 4, 1, 4, 3, 6, 8, 5, 9};
        printIntArr(theBigger(ints));
        printIntArr(theMinBigger(ints));
    }

    private static void printIntArr(int[] ints) {
        if (ints == null) {
            return;
        }
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static int[] theBigger(int[] ints) {
        if (ints == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[ints.length];
        stack.push(-1);

        for (int i = ints.length - 1; i >= 0; i--) {
            int top = stack.peek();
            while (top != -1 && ints[i] >= top) {
                stack.pop();
                top = stack.peek();
            }
            result[i] = top;
            stack.push(ints[i]);
        }

        return result;
    }

    private static int[] theMinBigger(int[] ints) {
        if (ints == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        int[] result = new int[ints.length];
        stack.push(-1);

        for (int i = ints.length - 1; i >= 0; i--) {
            int top = stack.peek();
            while (top != -1 && ints[i] >= top) {
                helpStack.push(stack.pop());
                top = stack.peek();
            }

            result[i] = top;
            stack.push(ints[i]);

            while (helpStack.size() > 0) {
                stack.push(helpStack.pop());
            }
        }

        return result;
    }
}
