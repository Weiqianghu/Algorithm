package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-22.
 */
public class Problem_1_3 {
    public static void main(String[] args) {
        System.out.println(isCharsSame("abcd", "abdc"));
        System.out.println(isCharsSame("aaa", "aac"));
        System.out.println(isCharsSame("aaaaaa", "aaaaaa"));
        System.out.println(isCharsSame("123", "231"));
        System.out.println(isCharsSame("1212", "1213"));
        System.out.println(isCharsSame("231 ", "23 1"));
    }

    private static boolean isCharsSame(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }

        if (str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }

        int[] map = new int[256];
        char[] chars1 = str1.toCharArray();
        for (char c : chars1) {
            map[c]++;
        }

        char[] chars2 = str2.toCharArray();
        for (char c : chars2) {
            map[c]--;
        }

        for (int i : map) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
