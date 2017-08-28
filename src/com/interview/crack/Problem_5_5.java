package com.interview.crack;

public class Problem_5_5 {
    public static void main(String[] args) {
        printTheNotSameBits(31, 14);
        printTheNotSameBits(31, 30);
        printTheNotSameBits(23, 14);

    }

    private static void printTheNotSameBits(int num1, int num2) {
        System.out.print(Integer.toBinaryString(num1) + "  " + Integer.toBinaryString(num2));
        int sum = 0;
        for (int i = num1 ^ num2; i != 0; i = (i - 1) & i) {
            sum++;
        }
        System.out.println(" " + sum);
    }
}
