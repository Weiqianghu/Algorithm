package com.interview.sword;

public class Problem_38 {
    public static void main(String[] args) {
        int[] sortedInts = {1, 1, 3, 3, 3, 3, 3, 4, 5, 9, 9};
        System.out.println(findNumbers(sortedInts, 9));
        System.out.println(findNumbers(sortedInts, 1));
        System.out.println(findNumbers(sortedInts, 3));
        System.out.println(findNumbers(sortedInts, 5));
        System.out.println(findNumbers(sortedInts, 10));
        System.out.println(findNumbers(sortedInts, 8));
    }

    private static int findNumbers(int[] sortedInts, int number) {
        int numbers = 0;
        if (sortedInts == null || sortedInts.length < 1) {
            return numbers;
        }

        int firstIndex;
        int lastIndex;

        int start = 0, end = sortedInts.length - 1, middle = (end + start) / 2;

        while ((sortedInts[middle] != number || !(middle == 0 || sortedInts[middle - 1] != number)) && start <= end) {
            if (sortedInts[middle] >= number) {
                end = middle - 1;
            } else if (sortedInts[middle] < number) {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        firstIndex = middle;

        start = firstIndex;
        end = sortedInts.length - 1;
        middle = (end + start) / 2;

        while ((sortedInts[middle] != number || !(middle == sortedInts.length - 1 || sortedInts[middle + 1] != number)) && start <= end) {
            if (sortedInts[middle] > number) {
                end = middle - 1;
            } else if (sortedInts[middle] <= number) {
                start = middle + 1;
            }
            middle = (start + end) / 2;
        }
        lastIndex = middle;

        numbers = lastIndex - firstIndex + 1;
        if (sortedInts[lastIndex] != number) {
            numbers = 0;
        }

        return numbers;
    }


}
