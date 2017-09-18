package com.interview.crack;

public class Problem_7_4 {

    public static void main(String[] args) {
        System.out.println("12-3 " + minus(12, 3));
        System.out.println("-3-12 " + minus(-3, 12));
        System.out.println("0-23 " + minus(0, 23));

        System.out.println("0*23 " + mult(0, 23));
        System.out.println("1*2 " + mult(1, 2));
        System.out.println("-4*8 " + mult(-4, 8));
        System.out.println("-4*-2 " + mult(-4, -2));

        System.out.println("-4/-2 " + divide(-4, -2));
        System.out.println("0/-2 " + divide(0, -2));
        System.out.println("4/3 " + divide(4, 3));
        System.out.println("9/-2 " + divide(9, -2));


    }

    private static int negate(int num) {
        int neg = 0;
        int d = num > 0 ? -1 : 1;
        while (num != 0) {
            num += d;
            neg += d;
        }
        return neg;
    }

    private static int minus(int a, int b) {
        return a + negate(b);
    }

    private static int mult(int a, int b) {
        if (abs(a) < abs(b)) {
            return mult(b, a);
        }

        int result = 0;
        for (int i = abs(b); i > 0; i--) {
            result += a;
        }

        if (b < 0) {
            return abs(result);
        }
        return result;
    }

    private static int abs(int num) {
        if (num < 0) {
            return negate(num);
        }
        return num;
    }

    private static int divide(int a, int b) {
        if (b == 0) {
            throw new java.lang.ArithmeticException();
        }

        int absa = abs(a);
        int absb = abs(b);

        int product = 0;
        int x = 0;
        while (product + absb <= absa) {
            product += absb;
            x++;
        }

        if ((a > 0 && b > 0) || (a < 0 || b < 0)) {
            return x;
        }
        return negate(x);
    }
}
