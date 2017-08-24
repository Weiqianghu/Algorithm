package com.interview.crack;

public class Problem_5_3 {
    public static void main(String[] args) {
        printThe2Number(21);
        printThe2Number(20);
        printThe2Number(0);

    }

    private static void printThe2Number(int iValue) {
        System.out.println(Integer.toBinaryString(iValue));
        System.out.println(Integer.toBinaryString(getNext(iValue)));
        System.out.println(Integer.toBinaryString(getPre(iValue)));
    }

    private static int getPre(int iValue) {
        int n = iValue;
        int c0 = 0;
        int c1 = 0;

        while ((n & 1) == 1) {
            n = n >> 1;
            c1++;
        }

        if (n == 0) {
            return -1;
        }

        while ((n & 1) == 0 && n != 0) {
            n = n >> 1;
            c0++;
        }

        int p = c0 + c1;

        iValue = iValue & (~((1 << (p + 1)) - 1));
        int mask = ((1 << (c1 + 1)) - 1);
        iValue = iValue | (mask << (c0 - 1));
        return iValue;
    }

    private static int getNext(int iValue) {
        int n = iValue;
        int c0 = 0;
        int c1 = 0;

        while (n != 0 && (n & 1) == 0) {
            n = n >> 1;
            c0++;
        }

        while ((n & 1) == 1) {
            n = n >> 1;
            c1++;
        }

        if (c0 + c1 >= 31 || c0 + c1 == 0) {
            return -1;
        }

        int p = c0 + c1;

        iValue = iValue | (1 << p);
        iValue = iValue & (~((1 << p) - 1));
        iValue = iValue | ((1 << (c1 - 1)) - 1);
        return iValue;
    }
}
