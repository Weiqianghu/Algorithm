package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-23.
 */
public class Problem_30 {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 5, 4, 8, 2, 0, 7, 0};
        printNumbers(numbers);

        printNumbers(findTheKMin(numbers, 1));
        printNumbers(findTheKMin(numbers, 4));
        printNumbers(findTheKMin(numbers, 6));
    }

    private static int[] findTheKMin(int[] numbers, int k) {
        if (numbers == null || numbers.length < 1 || k > numbers.length - 1) {
            return numbers;
        }

        int start = 0, end = numbers.length - 1;
        int pivot = partition(numbers, start, end);
        while (pivot != k - 1) {
            if (pivot < k - 1) {
                start = pivot + 1;
            } else {
                end = pivot - 1;
            }

            pivot = partition(numbers, start, end);
        }
        return numbers;
    }


    private static int partition(int[] numbers, int start, int end) {
        if (numbers == null || start < 0 || start > end || end > numbers.length - 1) {
            return 0;
        }

        int pivot = numbers[end];
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (numbers[i] < pivot) {
                ++small;
                if (small != i) {
                    swap(numbers, small, i);
                }
            }
        }
        ++small;
        swap(numbers, small, end);
        return small;
    }

    private static int partition2(int[] numbers, int start, int end) {
        if (numbers == null || start < 0 || start > end || end > numbers.length) {
            return 0;
        }

        int pivot = numbers[start];
        while (start < end) {
            while (start < end && numbers[end] > pivot) {
                --end;
            }
            if (start < end) {
                numbers[start] = numbers[end];
                ++start;
            }

            while (start < end && numbers[start] < pivot) {
                ++start;
            }
            if (start < end) {
                numbers[end] = numbers[start];
                --end;
            }
        }

        numbers[start] = pivot;
        return start;
    }

    private static void swap(int[] numbers, int index1, int index2) {
        if (numbers == null || index1 < 0 || index1 > numbers.length - 1
                || index2 < 0 || index2 > numbers.length - 1 || index1 == index2) {
            return;
        }

        numbers[index1] ^= numbers[index2];
        numbers[index2] ^= numbers[index1];
        numbers[index1] ^= numbers[index2];

       /* int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;*/
    }

    private static void printNumbers(int[] numbers) {
        if (numbers == null) {
            return;
        }

        for (int i : numbers) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
