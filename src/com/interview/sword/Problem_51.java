package com.interview.sword;

public class Problem_51 {
    public static void main(String[] args) {
        int[] ints = {0,1,2,3,4};
        System.out.println(findTheRepeatNumber(ints));
        System.out.println(findTheRepeatNumberByBetter(ints));
    }

    private static int findTheRepeatNumberByBetter(int[] ints) {
        if (ints == null || ints.length < 1) {
            return Integer.MAX_VALUE;
        }

        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == i) {
                //empty
            } else if (ints[i] == ints[ints[i]]) {
                return ints[i];
            } else {
                swap(ints, i, ints[i]);
            }
        }

        return Integer.MAX_VALUE;
    }

    private static void swap(int[] arr, int index1, int index2) {
        if (arr == null || index1 < 0 || index2 < 0 || index1 >= arr.length || index2 >= arr.length) {
            return;
        }

        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static int findTheRepeatNumber(int[] ints) {
        if (ints == null || ints.length < 1) {
            return Integer.MAX_VALUE;
        }

        int[] help = new int[ints.length];

        for (int i : ints) {
            help[i]++;
        }

        for (int i : help) {
            if (i > 1) {
                return i;
            }
        }

        return Integer.MAX_VALUE;
    }
}
