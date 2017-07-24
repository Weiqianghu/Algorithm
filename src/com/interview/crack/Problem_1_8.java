package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-24.
 */
public class Problem_1_8 {
    public static void main(String[] args) {
        System.out.println(isRotate("abc", "abc"));
        System.out.println(isRotate("abc", "bca"));
        System.out.println(isRotate("abcd", "abcs"));
    }

    private static boolean isRotate(String str1, String str2) {
        return str1 == null && str2 == null ||
                !(str1 == null || str2 == null) &&
                        str1.length() == str2.length() &&
                        isSubstring(str1 + str1, str2);
    }

    private static boolean isSubstring(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() < str2.length()) {
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int i, j;
        for (i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                for (j = 0; j < chars2.length && i + j < chars1.length; j++) {
                    if (chars1[i + j] != chars2[j]) {
                        break;
                    }
                }
                if (j == chars2.length) {
                    return true;
                }
            }
        }

        return false;
    }
}
