package com.interview.base;

/**
 * Created by huweiqiang on 2017/9/19.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 1, 8, 2, 9, 7, 5, 0, 3};
        mergeSort(numbers, 0, numbers.length - 1);
        printArr(numbers);
    }

    private static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right || numbers == null || numbers.length < 1) {
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(numbers, left, middle);
        mergeSort(numbers, middle + 1, right);

        int i = left, j = middle + 1;
        int[] temp = new int[right - left + 1];
        int k = 0;
        while (i <= middle && j <= right) {
            if (numbers[i] < numbers[j]) {
                temp[k++] = numbers[i++];
            } else {
                temp[k++] = numbers[j++];
            }
        }
        while (i <= middle) {
            temp[k++] = numbers[i++];
        }
        while (j <= right) {
            temp[k++] = numbers[j++];
        }

        for (i = 0; i < k; i++) {
            numbers[left + i] = temp[i];
        }
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
