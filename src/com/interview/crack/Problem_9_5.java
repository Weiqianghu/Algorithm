package com.interview.crack;

import java.util.ArrayList;
import java.util.List;

public class Problem_9_5 {
    public static void main(String[] args) {
        System.out.println(mixStr("ab"));
        System.out.println(mixStr("abc"));

//        System.out.println(insert("ba", "c"));

        System.out.println(comb("abc"));
    }

    private static List<String> mixStr(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() < 1) {
            return result;
        }

        if (str.length() == 1) {
            result.add(str);
            return result;
        }

        List<String> sons = mixStr(str.substring(0, str.length() - 1));
        String current = str.substring(str.length() - 1);
        for (String s : sons) {
            result.addAll(insert(s, current));
        }
        return result;
    }

    private static List<String> insert(String str, String toInsert) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() < 1) {
            result.add(toInsert);
            return result;
        }
        if (toInsert == null || toInsert.length() < 1) {
            result.add(str);
            return result;
        }

        for (int i = 0, length = str.length(); i <= length; i++) {
            result.add(str.substring(0, i) + toInsert + str.substring(i));
        }

        return result;
    }

    private static List<String> comb(String str) {
        List<String> result = new ArrayList<>();

        if (str == null || str.length() < 1) {
            result.add("");
            return result;
        }

        List<String> sons = comb(str.substring(0, str.length() - 1));

        String current = str.substring(str.length() - 1);
        result.addAll(sons);

        for (String son : sons) {
            result.add(son + current);
        }

        return result;
    }
}
