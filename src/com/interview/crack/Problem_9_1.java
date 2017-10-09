package com.interview.crack;

public class Problem_9_1 {
    public static void main(String[] args) {
        System.out.println(theMethods(10));
        System.out.println(theMethods(4));
        System.out.println(theMethods(5));
        System.out.println(theMethods(250));

    }

    private static int theMethods(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        }

        int m1 = 1, m2 = 2, m3 = 3, m = m1 + m2 + m3, index = 4;
        while (index < n) {
            m1 = m2;
            m2 = m3;
            m3 = m;
            m = m1 + m2 + m3;
            index++;
        }

        return m;
    }
}
