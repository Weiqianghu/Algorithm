package com.interview.sword;

public class Problem_43 {
    public static void main(String[] args) {
        showProbabilities(3);
    }

    private static void showProbabilities(int number) {
        int[] probabilities = new int[5 * number + 1];
        for (int i = number; i <= 6 * number; i++) {
            probabilities[i - number] = probabilities(number, i);
        }

        double sum = Math.pow(6, number);

        for (int prp : probabilities) {
            System.out.println((double) prp / sum + ",");
        }
    }

    private static int probabilities(int number, int sum) {
        if (sum < number || sum > 6 * number) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            int result = 0;
            for (int i = 1; i <= 6; i++) {
                result += probabilities(number - 1, sum - i);
            }
            return result;
        }
    }
}
