package com.interview.sword;

public class Problem_36 {
    public static void main(String[] args) {
        int[] ints = {7, 6, 4, 5, 8, 2, 9};
        printArr(ints);
        System.out.println(mergeSort(ints, 0, ints.length));
        printArr(ints);
    }

    private static void printArr(int[] ints) {
        if (ints == null) {
            return;
        }
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static int mergeSort(int[] ints, int start, int end) {
        if (ints == null || ints.length < 2 || end - start < 2) {
            return 0;
        }

        int middle = (end + start) / 2;

        int countLeft = mergeSort(ints, start, middle);
        int countRight = mergeSort(ints, middle, end);

        return merge(ints, start, middle, end) + countLeft + countRight;
    }

    private static int merge(int[] ints, int start, int middle, int end) {
        int[] copy = new int[ints.length];

        int i = middle - 1;
        int j = end - 1;
        int index = end - 1;
        int count = 0;

        while (i >= start && j >= middle) {
            if (ints[i] > ints[j]) {
                copy[index--] = ints[i--];
                count++;
            } else {
                copy[index--] = ints[j--];
            }
        }

        while (i >= start) {
            count++;
            copy[index--] = ints[i--];
        }

        while (j >= middle) {
            copy[index--] = ints[j--];
        }

        index = end - 1;
        while (index >= start) {
            ints[index] = copy[index];
            --index;
        }

        return count;
    }
}
