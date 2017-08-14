package com.interview.sword;

public class Problem_48 {
    public static void main(String[] args) {
        System.out.println(str2Int("234"));
        System.out.println(str2Int("78657"));
        System.out.println(str2Int("0"));
        System.out.println(str2Int("-"));
        System.out.println(str2Int("-234"));

        System.out.println(_10hexTo2hex(16));
        System.out.println(_10hexTo2hex(-8));
        System.out.println(_10hexTo2hex(0));

    }

    private static int str2Int(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }

        char[] chars = str.toCharArray();

        boolean isNegative = chars[0] == '-';

        int start = isNegative ? 1 : 0;
        int number = 0;
        for (int i = start; i < chars.length; i++) {
            number = number * 10 + char2Int(chars[i]);
        }

        if (isNegative) {
            number = -number;
        }

        return number;
    }

    private static int char2Int(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        throw new IllegalArgumentException();
    }

    private static String _10hexTo2hex(int number) {
        if (number == 0) {
            return "0";
        }

        StringBuilder _2hexStr = new StringBuilder();
        while (number != 0) {
            _2hexStr.insert(0, number % 2);
            number = number / 2;
        }
        return _2hexStr.toString();
    }
}
