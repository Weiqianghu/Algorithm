package com.interview.crack;

import java.util.Arrays;

public class Problem_11_1 {
    public static void main(String[] args) {
        int[] aArray = {1, 3, 5, 7, 8, 0, 0, 0, 0, 0};
        int[] bArray = {2, 4, 5, 6, 9};

        compactArr(aArray, bArray, 5, 5);

        for (int value : aArray) {
            System.out.print(value + ",");
        }
    }

    private static void compactArr(int[] aArray, int[] bArray, int lengthA, int lengthB) {
        int indexA = lengthA - 1, indexB = lengthB - 1;
        int indexMerged = lengthA + lengthB - 1;
        while (indexA >= 0 && indexB >= 0) {
            if (aArray[indexA] > bArray[indexB]) {
                aArray[indexMerged--] = aArray[indexA--];
            } else {
                aArray[indexMerged--] = bArray[indexB--];
            }
        }

        while (indexB >= 0) {
            aArray[indexMerged--] = bArray[indexB--];
        }
    }
}
