package com.interview.sword;

public class Problem_47 {
    public static void main(String[] args) {
        System.out.println(add(2, 3));
        System.out.println(add(3, 3));
        System.out.println(add(10, 20));
        System.out.println(add(-2, 3));
        System.out.println(add(-9, -10));
        System.out.println(add(3000, 6000));

    }

    private static int add(int num1, int num2) {
        int sum, carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (carry != 0);

        return sum;
    }
}
