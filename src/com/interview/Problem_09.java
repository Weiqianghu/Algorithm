package com.interview;

/**
 * Created by weiqianghu on 17-7-3.
 */
public class Problem_09 {
    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }

    private static int fibonacci(int num) {
        int pre = 0, back = 1;

        if (num <= 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }

        int result = pre + back;

        for (int i = 2; i <= num; i++) {
            result = pre + back;
            System.out.print(result + " ");
            pre = back;
            back = result;
        }
        System.out.println();
        return result;
    }
}
