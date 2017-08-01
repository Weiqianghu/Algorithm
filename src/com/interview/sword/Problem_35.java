package com.interview.sword;

public class Problem_35 {
    public static void main(String[] args) {
        System.out.println(theFirstNotRepeatChar("asdahgsfkjhgytiu"));
    }

    private static char theFirstNotRepeatChar(String str) {
        if (str == null) {
            return 0;
        }

        int[] ints = new int[256];

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            ints[c]++;
        }

        for (char c : charArray) {
            if (ints[c] == 1) {
                return c;
            }
        }

        return 0;
    }
}
