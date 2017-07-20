package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-20.
 */
public class Problem_1_1 {
    public static void main(String[] args) {
        System.out.println(isAllNotSame("ascc") + "," + isAllNotSameByBit("ascc"));
        System.out.println(isAllNotSame("abcd") + "," + isAllNotSameByBit("abcd"));
        System.out.println(isAllNotSame("aa") + "," + isAllNotSameByBit("aa"));
        System.out.println(isAllNotSame("axcx") + "," + isAllNotSameByBit("axcx"));
        System.out.println(isAllNotSame("aqwqwa") + "," + isAllNotSameByBit("aqwqwa"));

    }

    private static boolean isAllNotSame(String str) {
        if (str == null || str.length() < 2) {
            return true;
        }

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isAllNotSameByBit(String str) {
        if (str == null || str.length() < 2) {
            return true;
        }

        if (str.length() > 26) {
            return false;
        }

        char[] chars = str.toCharArray();

        int bits = 0;

        for (char c : chars) {
            int bit = c - 'a';
            if ((bits & (1 << bit)) > 0) {
                return false;
            }
            bits = bits | (1 << bit);
        }

        return true;
    }
}
