package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-4.
 */
public class Problem_11 {

    public static void main(String[] args) {
        System.out.println(power(3.0, -2) + " " + powerPlus(3.0, -2));
        System.out.println(power(2, 0) + " " + powerPlus(2, 0));
        System.out.println(power(4, 2) + " " + powerPlus(4, 2));
        System.out.println(power(0, 0) + " " + powerPlus(0, 0));
        System.out.println(power(-4, 3) + " " + powerPlus(-4, 3));
        System.out.println(power(-4, -2) + " " + powerPlus(-4, -2));
    }

    private static double power(double base, int exponent) {
        boolean isNegative = false;

        if (exponent < 0) {
            isNegative = true;
            exponent = -exponent;
        } else if (exponent == 0) {
            return 1;
        } else if (base == 0) {
            return 1;
        }

        double result = 1;

        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }

        return isNegative ? 1 / result : result;
    }

    private static double powerPlus(double base, int exponent) {
        if (equalsDouble(base, 0.0)) {
            return 0;
        }
        if (exponent > 0) {
            return powerWithUnsignedExponent(base, exponent);
        }
        return 1 / powerWithUnsignedExponent(base, -exponent);
    }

    private static boolean equalsDouble(double num1, double num2) {
        return (num1 - num2 > 0.0000000001) && (num2 - num1 > 0.00000001);
    }


    private static double powerWithUnsignedExponent(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }

}
