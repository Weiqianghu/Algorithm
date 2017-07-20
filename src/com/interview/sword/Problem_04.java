package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-1.
 */
public class Problem_04 {

    public static void main(String[] args) {
        System.out.println(replaceBlank("We are happy  !"));
        System.out.println(replaceBlank("We_are_happy! "));
        System.out.println(replaceBlank(" "));
        System.out.println(replaceBlank(" We_are_happy!"));
    }

    private static String replaceBlank(String res) {
        if (res == null || res.length() < 1) {
            return "";
        }
        char[] chars = res.toCharArray();
        int blankNumbers = 0;
        for (char c : chars) {
            if (c == ' ') {
                blankNumbers++;
            }
        }
        char[] resultChars = new char[chars.length + blankNumbers * 2];
        for (int i = 0, j = 0; i < chars.length && j < resultChars.length; ) {
            if (chars[i] == ' ') {
                resultChars[j++] = '%';
                resultChars[j++] = '2';
                resultChars[j++] = '0';
                i++;
            } else {
                resultChars[j++] = chars[i ++];
            }
        }
        return String.valueOf(resultChars);
    }
}
