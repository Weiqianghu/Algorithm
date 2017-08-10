package com.interview.sword;

public class Problem_44 {
    public static void main(String[] args) {
        int[] cards = {0, 0, 3, 4, 4};
        System.out.println(isShunzi(cards));
    }

    private static boolean isShunzi(int[] cards) {
        int[] allCards = new int[14];
        for (int card : cards) {
            allCards[card]++;
        }

        int zeroCount = allCards[0];
        boolean start = false;
        int loseCount = 0;
        int sum = 0;
        for (int i = 1; i < 14; i++) {
            if (start && allCards[i] == 0) {
                loseCount++;
            } else if (!start && allCards[i] == 1) {
                start = true;
            } else if (allCards[i] > 1) {
                return false;
            }
            sum += allCards[i];
            if (sum + zeroCount == 5) {
                break;
            }
        }

        return loseCount <= zeroCount;
    }
}
