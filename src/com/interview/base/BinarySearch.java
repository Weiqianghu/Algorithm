package com.interview.base;

/**
 * Created by huweiqiang on 2017/9/19.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(numbers, 1, 0, numbers.length - 1));
        System.out.println(binarySearch(numbers, 9, 0, numbers.length - 1));
        System.out.println(binarySearch(numbers, 4, 0, numbers.length - 1));
        System.out.println(binarySearch(numbers, 0, 0, numbers.length - 1));
        System.out.println(binarySearch(numbers, 10, 0, numbers.length - 1));

    }

    private static boolean binarySearch(int[] numbers, int num, int start, int end) {
        if (numbers == null || numbers.length < 1 || start > end) {
            return false;
        }

        int middle = (start + end) / 2;

        if (numbers[middle] > num) {
            return binarySearch(numbers, num, start, middle - 1);
        } else if (numbers[middle] < num) {
            return binarySearch(numbers, num, middle + 1, end);
        }

        return true;
    }


    private static void printArr(int[] numbers) {
        if (numbers == null) {
            return;
        }
        for (int number : numbers) {
            System.out.print(number + ",");
        }
        System.out.println();
    }
}
