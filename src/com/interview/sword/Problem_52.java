package com.interview.sword;

public class Problem_52 {
    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5};
        printArr(src);
        int[] dst = getTheDst(src);
        printArr(dst);
    }

    private static int[] getTheDst(int[] src) {
        if (src == null || src.length < 1) {
            return src;
        }

        int[] help1 = new int[src.length];
        int[] help2 = new int[src.length];

        int mult = 1;
        for (int i = 0; i < src.length; i++) {
            if (i == 0) {
                help1[i] = mult;
            } else {
                help1[i] = mult * src[i - 1];
            }
            mult = help1[i];
        }

        mult = 1;
        for (int i = src.length - 1; i >= 0; i--) {
            if (i == src.length - 1) {
                help2[i] = mult;
            } else {
                help2[i] = mult * src[i + 1];
            }
            mult = help2[i];
        }

        int[] dst = new int[src.length];
        for (int i = 0; i < dst.length; i++) {
            dst[i] = help1[i] * help2[i];
        }

        return dst;
    }

    private static void printArr(int[] arr) {
        if (arr == null || arr.length < 1) {
            return;
        }

        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
