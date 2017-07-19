package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-19.
 */
public class Problem_28 {
    public static void main(String[] args) {
        printStrList(mixStr("abc"));
        printStrList(mixStr("23"));
        printStrList(mixStr("1"));
    }

    private static void printStrList(List<String> strings) {
        for (String string : strings) {
            System.out.print(string + ",");
        }
        System.out.println();
    }

    private static List<String> mixStr(String source) {
        List<String> result = new ArrayList<>();

        if (source == null || source.length() < 2) {
            result.add(source);
            return result;
        }

        List<String> fronts = mixStr(source.substring(0, source.length() - 1));
        char last = source.substring(source.length() - 1).toCharArray()[0];

        for (String string : fronts) {
            char[] chars = string.toCharArray();
            char[] copyChars = new char[chars.length + 1];

            System.arraycopy(chars, 0, copyChars, 0, chars.length);
            int lastIndex = copyChars.length - 1;
            copyChars[lastIndex] = last;


            for (int i = 0, length = copyChars.length; i < length; i++) {
                swap(copyChars, i, lastIndex);
                result.add(String.valueOf(copyChars));
                swap(copyChars, lastIndex, i);
            }
        }
        return result;
    }

    private static void swap(char[] chars, int index1, int index2) {
        if (chars == null || index1 < 0 || index1 > chars.length - 1 || index2 < 0 || index2 > chars.length - 1) {
            return;
        }

        char temp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = temp;
    }
}
