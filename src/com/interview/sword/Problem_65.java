package com.interview.sword;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_65 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        printTheMaxNum(arr, 3);
        printTheMaxNum(arr, 1);
        printTheMaxNum(arr, 2);

        printTheMaxNumByBetter(arr, 3);
        printTheMaxNumByBetter(arr, 1);
        printTheMaxNumByBetter(arr, 2);

    }

    private static void printTheMaxNum(int[] arr, int size) {
        if (arr == null || size < 1) {
            return;
        }

        if (size > arr.length) {
            size = arr.length;
        }

        for (int i = 0, length = arr.length - size; i <= length; i++) {
            int maxNum = Integer.MIN_VALUE;
            for (int j = i; j < size + i; j++) {
                if (arr[j] > maxNum) {
                    maxNum = arr[j];
                }
            }
            System.out.print(maxNum + ",");
        }
        System.out.println();
    }

    private static void printTheMaxNumByBetter(int[] arr, int size) {
        if (arr == null || size < 1) {
            return;
        }

        if (size > arr.length) {
            size = arr.length;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.pollLast();
            }

            queue.addLast(i);
        }

        for (int i = size; i < arr.length; i++) {
            System.out.print(arr[queue.peekFirst()] + ",");
            while (!queue.isEmpty() && arr[i] >= arr[queue.peekLast()]) {
                queue.pollLast();
            }
            if (!queue.isEmpty() && queue.peekFirst() <= (i - size)) {
                queue.pollFirst();
            }
            queue.addLast(i);
        }
        System.out.print(arr[queue.peekFirst()] + ",");
        System.out.println();
    }
}
