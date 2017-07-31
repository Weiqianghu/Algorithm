package com.interview.sword;

public class Problem_34 {
    public static void main(String[] args) {
        printArr(getUglyNumber(30));
        printArr(getUglyNumber(10));
    }

    private static void printArr(int[] uglyNumber) {
        if (uglyNumber == null) {
            return;
        }

        for (int i : uglyNumber) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static int[] getUglyNumber(int n) {
        if (n < 1) {
            return null;
        }

        int[] result = new int[n];
        result[0] = 1;
        int next2Index = 0;
        int next3Index = 0;
        int next5Index = 0;
        int nextIndex = 1;

        while (nextIndex < n) {
            result[nextIndex] = min(result[next2Index] * 2, result[next3Index] * 3, result[next5Index] * 5);

            while (result[next2Index] * 2 <= result[nextIndex]) {
                next2Index++;
            }

            while (result[next3Index] * 3 <= result[nextIndex]) {
                next3Index++;
            }

            while (result[next5Index] * 5 <= result[nextIndex]) {
                next5Index++;
            }

            ++nextIndex;
        }

        return result;
    }

    private static int min(int num1, int num2, int num3) {
        return Math.min(num3, Math.min(num1, num2));
    }
}
