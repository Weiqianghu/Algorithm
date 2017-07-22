package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-22.
 */
public class Problem_29 {
    public static void main(String[] args) {
//        int[] intArr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] intArr = {4, 4, 4, 4, 4, 1, 2};
//        int[] intArr = {1, 2, 3, 3, 2, 3, 3, 2, 2, 2, 2};

        System.out.println(findTheMostNumber(intArr));
        System.out.println(findMostNumberByPartition(intArr));
    }

    private static int findMostNumberByPartition(int[] intArr) {
        if (intArr == null || intArr.length < 1) {
            return -1;
        }

        int middle = intArr.length >>> 1;
        int start = 0, end = intArr.length - 1;
        int partition = partition2(intArr, start, end);

        while (partition != middle) {
            if (partition > middle) {
                end = partition - 1;
            } else {
                start = partition + 1;
            }
            partition = partition(intArr, start, end);
        }

        return intArr[middle];
    }

    private static int partition(int[] intArr, int start, int end) {
        if (intArr == null || intArr.length < 1 || start < 0 || end >= intArr.length) {
            throw new IllegalArgumentException();
        }

        int pivot = intArr[start];

        while (start < end) {
            while (start < end && intArr[end] > pivot) {
                --end;
            }
            if (start < end) {
                intArr[start] = intArr[end];
                ++start;
            }

            while (start < end && intArr[start] < pivot) {
                ++start;
            }
            if (start < end) {
                intArr[end] = intArr[start];
                --end;
            }
        }

        intArr[start] = pivot;

        return start;
    }

    private static int partition2(int[] ints, int start, int end) {
        if (ints == null || ints.length < 1 || start < 0 || end >= ints.length) {
            throw new IllegalArgumentException();
        }

        int pivot = ints[end];
        int small = start - 1;
        for (int index = start; index < end; index++) {
            if (ints[index] < pivot) {
                ++small;
                if (small != index) {
                    swap(ints, small, index);
                }
            }
        }
        ++small;
        swap(ints, small, end);
        return small;
    }

    private static void swap(int[] ints, int index1, int index2) {
        if (ints == null || ints.length < 1 || index1 < 0 || index2 >= ints.length) {
            throw new IllegalArgumentException();
        }

        int temp = ints[index1];
        ints[index1] = ints[index2];
        ints[index2] = temp;
    }

    private static int findTheMostNumber(int[] intArr) {
        if (intArr == null || intArr.length < 1) {
            return -1;
        }

        int number = intArr[0];
        int times = 1;

        for (int i = 1; i < intArr.length; i++) {
            if (number == intArr[i]) {
                times++;
            } else {
                times--;
            }

            if (times == 0) {
                number = intArr[i];
                times++;
            }
        }

        return number;
    }
}
