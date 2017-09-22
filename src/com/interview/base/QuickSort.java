package com.interview.base;


/**
 * Created by huweiqiang on 2017/9/19.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 8, 2, 9, 7, 5, 0, 3};
        quickSort(numbers, 0, numbers.length - 1);
        printArr(numbers);
    }

    private static void quickSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left, j = right, pivot = numbers[i];
        while (i < j) {
            while (i < j && numbers[j] > pivot) {
                j--;
            }
            if (i < j) {
                numbers[i++] = numbers[j];
            }

            while (i < j && numbers[i] < pivot) {
                i++;
            }
            if (i < j) {
                numbers[j--] = numbers[i];
            }
        }
        numbers[i] = pivot;

        quickSort(numbers, left, i - 1);
        quickSort(numbers, i + 1, right);
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
