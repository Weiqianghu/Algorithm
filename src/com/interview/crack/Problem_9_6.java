package com.interview.crack;

import java.util.ArrayList;
import java.util.List;

public class Problem_9_6 {
    public static void main(String[] args) {
        System.out.println(generateParens(1));
        System.out.println(generateParens(2));
        System.out.println(generateParens(3));
    }

    private static List<String> generateParens(int count) {
        if (count < 1) {
            return null;
        }
        char[] str = new char[count * 2];
        List<String> parens = new ArrayList<>();
        addParen(parens, str, count, count, 0);
        return parens;
    }

    private static void addParen(List<String> parens, char[] str, int leftRem, int rightRem, int index) {
        if (leftRem < 0 || rightRem < 0) {
            return;
        }
        if (leftRem == 0 && rightRem == 0) {
            parens.add(String.copyValueOf(str));
            return;
        }
        if (leftRem > 0) {
            str[index] = '(';
            addParen(parens, str, leftRem - 1, rightRem, index + 1);
        }
        if (rightRem > leftRem) {
            str[index] = ')';
            addParen(parens, str, leftRem, rightRem - 1, index + 1);
        }
    }
}
