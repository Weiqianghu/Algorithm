package com.interview;

import java.util.Stack;

/**
 * Created by weiqianghu on 17-7-15.
 */
public class Problem_22 {
    public static void main(String[] args) {
        int[] in = {1};
//        int[] out = {4, 5, 3, 2, 1};
//        int[] out = {4, 3, 5, 1, 2};
        int[] out = {3};

        System.out.println(isPopOrder(in, out));
    }

    private static boolean isPopOrder(int[] in, int[] out) {
        if (in == null && out == null) {
            return true;
        }
        if (in == null || out == null) {
            return false;
        }

        int inLength = in.length, outLength = out.length;
        if (inLength != outLength) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int inIndex = 0;

        for (int anOut : out) {

            while (stack.empty() || stack.peek() != anOut) {
                if (inIndex < inLength) {
                    stack.push(in[inIndex++]);
                } else {
                    return false;
                }
            }

            stack.pop();
        }

        return true;
    }
}
