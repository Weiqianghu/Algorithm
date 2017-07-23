package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-23.
 */
public class Problem_1_5 {
    public static void main(String[] args) {
        System.out.println(compress("aabccccccaa"));
        System.out.println(compress("abcd"));
        System.out.println(compress("aaccaacc"));
    }

    private static String compress(String sourceStr) {

        if (sourceStr == null || sourceStr.length() < 2) {
            return sourceStr;
        }

        char[] chars = sourceStr.toCharArray();
        StringBuilder result = new StringBuilder();

        int sum = 1;
        char currentChar = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (currentChar == chars[i]) {
                sum++;
            } else {
                result.append(currentChar);
                result.append(sum);

                currentChar = chars[i];
                sum = 1;
            }
        }
        result.append(currentChar);
        result.append(sum);

        if (result.toString().length() >= sourceStr.length()) {
            return sourceStr;
        }

        return result.toString();
    }
}
