package com.interview.sword;

public class Problem_41_B {
    public static void main(String[] args) {
        printTheNumbersOfSum(15);
        printTheNumbersOfSum(9);
        printTheNumbersOfSum(19);
        printTheNumbersOfSum(3);

    }

    private static void printTheNumbersOfSum(int sum) {
        if (sum < 3) {
            return;
        }

        int low = 1, high = 2;
        while (high < sum) {
            int s = 0;
            for (int i = low; i <= high; i++) {
                s += i;
            }

            if (s == sum) {
                for (int i = low; i <= high; i++) {
                    System.out.print(i + ",");
                }
                System.out.println();

                low++;
                high++;

            } else if (s < sum) {
                high++;
            } else {
                low++;
            }
        }
    }
}
