package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-22.
 */
public class Problem_1_2 {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdef"));
        System.out.println(reverseStr("a   b c de f"));
        System.out.println(reverseStr("#a4 sy p"));
    }

    private static String reverseStr(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        int start = 0, end = chars.length - 1;

        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            ++start;
            --end;
        }
        return String.valueOf(chars);
    }
}
