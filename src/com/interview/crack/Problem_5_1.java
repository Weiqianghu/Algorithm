package com.interview.crack;

public class Problem_5_1 {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insert(23, 12, 2, 33)));
        System.out.println(Integer.toBinaryString(insert(23, 12, 2, 2)));
        System.out.println(Integer.toBinaryString(insert(12345, 12, 2, 6)));
        System.out.println(Integer.toBinaryString(insert(23, 123456, 2, 6)));

    }

    private static int insert(int n, int m, int i, int j) {
        System.out.println("n:" + Integer.toBinaryString(n) + ",m:" + Integer.toBinaryString(m) + ",i:" + i + ",j:" + j);

        if (j < i || j > 32) {
            return n;
        }

        int k = j - i;

        m = ((1 << (k + 1)) - 1) & m;

        m = m << i;

        for (int index = i; index <= j; index++) {
            n = n & (~(1 << index));
        }

        return n | m;
    }
}
