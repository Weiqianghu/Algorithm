package com.interview.crack;

public class Problem_5_6 {
    public static void main(String[] args) {
        swapBit(12);
        swapBit(23);
        swapBit(56);
        swapBit(25);

    }

    private static void swapBit(int num) {
        System.out.print(Integer.toBinaryString(num) + " ");

        num = ((0xaaaaaaaa & num) >> 1) | ((0x55555555 & num) << 1);

        System.out.println(Integer.toBinaryString(num));
    }
}
