package com.interview.crack;

public class Problem_9_8 {
    public static void main(String[] args) {
        System.out.println(methods(3, 25));
        System.out.println(methods(5, 25));
        System.out.println(methods(8, 25));
        System.out.println(methods(10, 25));
        System.out.println(methods(18, 25));
        System.out.println(methods(25, 25));
        System.out.println(methods(30, 25));
    }

    private static int methods(int sum, int denom) {
        int nextDenom = 0;
        switch (denom) {
            case 25:
                nextDenom = 10;
                break;
            case 10:
                nextDenom = 5;
                break;
            case 5:
                nextDenom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for (int i = 0; i * denom <= sum; i++) {
            ways += methods(sum - i * denom, nextDenom);
        }
        return ways;
    }
}
