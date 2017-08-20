package com.interview.sword;

public class Problem_54 {
    public static void main(String[] args) {
        printAnswer("100");
        printAnswer("5e2");
        printAnswer("-123");
        printAnswer("3.1416");
        printAnswer("-1e-16");
        printAnswer("12e");
        printAnswer("1a3.14");
        printAnswer("1.2.3");
        printAnswer("+-5");
        printAnswer("12e+5.4");
    }

    private static void printAnswer(String str) {
        System.out.println(str + (isNumber(str.toCharArray()) ? " 是" : " 不是") + "数字");
    }

    private static boolean isNumber(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }

        int pos = 0;
        if (str[pos] == '+' || str[pos] == '-') {
            pos++;
        }

        if (pos == str.length) {
            return false;
        }

        int noDigitPos = scanDigits(str, pos);

        if (noDigitPos == str.length) {
            return true;
        }

        if (str[noDigitPos] == '.') {
            noDigitPos = scanDigits(str, noDigitPos + 1);
        }

        if (noDigitPos == str.length) {
            return true;
        }

        if (str[noDigitPos] == 'e' || str[noDigitPos] == 'E') {
            return isExponential(str, noDigitPos);
        }

        return false;
    }

    private static boolean isExponential(char[] str, int pos) {
        if (str == null || pos > str.length - 2) {
            return false;
        }

        if (str[pos] != 'e' && str[pos] != 'E') {
            return false;
        }

        if (str[++pos] == '+' || str[pos] == '-') {
            pos++;
        }

        return pos < str.length && str.length == scanDigits(str, pos);
    }

    private static int scanDigits(char[] str, int pos) {
        if (str == null || pos >= str.length) {
            return pos;
        }

        for (int i = pos; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return i;
            }
        }

        return str.length;
    }
}
