package com.interview;

/**
 * Created by weiqianghu on 17-7-2.
 */
public class Problem_08 {

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(findMinNumber(numbers));
    }

    private static int findMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return 0;
        }

        int first = 0, last = numbers.length - 1;
        int minIndex = first;
        while (numbers[first] >= numbers[last]) {
            if (last - first == 1) {
                minIndex = last;
                break;
            }

            int middle = (last + first) / 2;

            if (numbers[middle] >= numbers[first]) {
                first = middle;
            } else if (numbers[middle] < numbers[first]) {
                last = middle;
            }
        }

        return numbers[minIndex];
    }
}
