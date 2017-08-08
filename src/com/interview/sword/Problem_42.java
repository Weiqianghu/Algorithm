package com.interview.sword;

public class Problem_42 {
    public static void main(String[] args) {
        String sentence = " I am hwq , who are you ? ";
        System.out.println(reverseSentence(sentence));
        System.out.println(leftShift("abcdefg", 2));
        System.out.println(leftShift("abcdefg", -2));
        System.out.println(leftShift("abcdefg", 0));
        System.out.println(leftShift("abcdefg", 10));

    }

    private static String reverseSentence(String sentence) {
        if (sentence == null) {
            return null;
        }

        String[] strings = sentence.split("\\s+");

        String[] temps = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            temps[i] = reverseStr(strings[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < temps.length; i++) {
            result.append(temps[i]);
            if (i != temps.length - 1) {
                result.append(" ");
            }
        }

        return reverseStr(result.toString());
    }

    private static String reverseStr(String str) {
        if (str == null) {
            return null;
        }

        char[] chars = str.toCharArray();
        for (int i = 0, length = chars.length / 2; i < length; i++) {
            swap(chars, i, chars.length - 1 - i);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int index1, int index2) {
        if (chars == null || index1 < 0 || index1 >= chars.length || index2 < 0 || index2 >= chars.length) {
            return;
        }

        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }

    private static String leftShift(String str, int left) {
        if (str == null || left < 0) {
            return str;
        }

        left = left % str.length();

        String reverseStr = reverseStr(str);
        String leftStr = reverseStr(reverseStr.substring(0, str.length() - left));
        String rightStr = reverseStr(reverseStr.substring(str.length() - left));
        return leftStr + rightStr;
    }
}
