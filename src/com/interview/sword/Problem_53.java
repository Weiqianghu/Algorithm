package com.interview.sword;

public class Problem_53 {
    public static void main(String[] args) {
        System.out.println(match("aaa", "a.a", 0, 0));
        System.out.println(match("aaa", "ab*ac*a", 0, 0));
        System.out.println(match("aaa", "aa.a", 0, 0));
        System.out.println(match("aaa", "ab*a", 0, 0));
        System.out.println(match("aaa", "a*", 0, 0));
        System.out.println(match("a", "ab*", 0, 0));

    }

    private static boolean match(String str, String pattern, int currentStr, int currentPattern) {
        if (str == null || pattern == null) {
            return false;
        }

        if (currentStr == str.length() && currentPattern == pattern.length()) {
            return true;
        }

        if (currentStr < str.length() && currentPattern == pattern.length()) {
            return false;
        }

        if (currentStr == str.length() && currentPattern < pattern.length()) {
            return false;
        }

        char[] chars = str.toCharArray();
        char[] patterns = pattern.toCharArray();

        if (currentPattern < patterns.length - 1 && patterns[currentPattern + 1] == '*') {
            if (chars[currentStr] == patterns[currentPattern] || (patterns[currentPattern] == '.' && currentStr < str.length())) {
                return match(str, pattern, currentStr + 1, currentPattern + 2) ||
                        match(str, pattern, currentStr + 1, currentPattern) ||
                        match(str, pattern, currentStr, currentPattern + 2);
            } else {
                return match(str, pattern, currentStr, currentPattern + 2);
            }
        }

        if (chars[currentStr] == patterns[currentPattern] || (patterns[currentPattern] == '.' && currentStr < str.length())) {
            return match(str, pattern, currentStr + 1, currentPattern + 1);
        }

        return false;
    }
}
