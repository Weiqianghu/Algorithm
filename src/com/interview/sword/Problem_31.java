package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-24.
 */
public class Problem_31 {
    public static void main(String[] args) {
        int[] ints = {1, -2, 4, 3 - 6, 7, -8, 2, -10, 9, -6, 10};
        printArr(ints);
        printArr(subArr(ints));
    }

    private static int[] subArr(int[] ints) {
        if (ints == null || ints.length < 1) {
            return new int[0];
        }
        int start = 0, end = 0, sum = 0, max = 0;
        for (int i = 0; i < ints.length; i++) {
            if (sum < 0) {
                sum = ints[i];
                start = i;
            } else {
                sum += ints[i];
            }
            if (sum > max) {
                end = i + 1;
                max = sum;
            }
        }

        int[] result = new int[end - start];
        System.arraycopy(ints, start, result, 0, end - start);
        return result;
    }

    private static void printArr(int[] ints) {
        if (ints == null || ints.length < 1) {
            return;
        }
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
