package com.interview.sword;

public class Problem_41_A {
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 7, 11, 15};
        printTheNumsWithSum(ints, 15);
        printTheNumsWithSum(ints, 16);
        printTheNumsWithSum(ints, 0);
        printTheNumsWithSum(ints, 13);
    }

    private static void printTheNumsWithSum(int[] ints, int sum) {
        if (ints == null || ints.length < 2) {
            return;
        }

        int low = 0, high = ints.length - 1;
        while (ints[low] + ints[high] != sum && high > low) {
            if (ints[low] + ints[high] > sum) {
                high = high - 1;
            } else {
                low = low + 1;
            }
        }

        if (ints[low] + ints[high] == sum) {
            System.out.println(ints[low] + "," + ints[high]);
        }
    }
}
