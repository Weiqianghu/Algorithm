package com.interview.crack;

public class Problem_9_3 {
    public static void main(String[] args) {
        int[] numbers = {0};
        System.out.println(theMagicIndex(numbers));

        int[] nums = {-120, 1, 1, 1, 1, 1, 8, 10, 20, 30, 40};
        System.out.println(theMagicIndex(numbers,0,numbers.length-1));

    }

    private static int theMagicIndex(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return Integer.MIN_VALUE;
        }

        int start = 0, end = numbers.length - 1, middle;
        while (start <= end) {
            middle = (start + end) / 2;
            if (middle == numbers[middle]) {
                return middle;
            } else if (middle < numbers[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return Integer.MIN_VALUE;
    }

    private static int theMagicIndex(int[] numbers, int start, int end) {
        if (numbers == null || start < 0 || end > numbers.length - 1 || start > end) {
            return -1;
        }

        int middleIndex = (start + end) / 2;
        int middleValue = numbers[middleIndex];
        if (middleIndex == middleValue) {
            return middleIndex;
        }

        int leftIndex = Math.min(middleIndex - 1, middleValue);
        int left = theMagicIndex(numbers, start, leftIndex);
        if (left >= 0) {
            return left;
        }

        int rightIndex = Math.max(middleIndex + 1, middleValue);
        return theMagicIndex(numbers, rightIndex, end);
    }
}
