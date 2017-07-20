package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-20.
 */
public class Problem_28_A {
    public static void main(String[] args) {
        System.out.println(mixStr("abc"));
        System.out.println(mixStr("1"));
        System.out.println(mixStr("1234"));
        System.out.println(mixStr(null));
    }

    private static List<String> mixStr(String source) {
        List<String> result = new ArrayList<>();

        if (source == null || source.length() < 2) {
            result.add(source);
            return result;
        }

        for (int i = 1, length = source.length(); i < length + 1; i++) {
            result.addAll(mixM(source, i));
        }

        return result;
    }

    private static List<String> mixM(String source, int m) {
        List<String> result = new ArrayList<>();


        if (source == null || m > source.length()) {
            return result;
        }

        if (m == 1) {
            char[] chars = source.toCharArray();
            for (char c : chars) {
                result.add(String.valueOf(c));
            }
            return result;
        }

        List<String> stringsContainFirst = mixM(source.substring(1, source.length()), m - 1);
        for (String string : stringsContainFirst) {
            result.add(source.substring(0, 1) + string);
        }

        result.addAll(mixM(source.substring(1, source.length()), m));
        return result;
    }
}
