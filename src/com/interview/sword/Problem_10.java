package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-3.
 */
public class Problem_10 {
    public static void main(String[] args) {
        System.out.println(getNumberOfOne(-1034) + " " + Integer.toBinaryString(-1034));
        System.out.println(getNumberOfOne(9) + " " + Integer.toBinaryString(9));
        System.out.println(getNumberOfOne(10) + " " + Integer.toBinaryString(10));
        System.out.println(getNumberOfOne(16) + " " + Integer.toBinaryString(16));
        System.out.println(getNumberOfOne(63) + " " + Integer.toBinaryString(63));

    }

    private static int getNumberOfOne(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = (number - 1) & number;
        }
        return count;
    }
}
