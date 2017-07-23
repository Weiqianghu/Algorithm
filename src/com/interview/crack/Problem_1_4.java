package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-23.
 */
public class Problem_1_4 {
    public static void main(String[] args) {
        char[] source = {'M', 'r', ' ', 'h', ' ', ' ', ' ', ' ', ' '};
//        System.out.println(String.valueOf(replaceBlank(source, 5)));
//        System.out.println(String.valueOf(replaceBlank(source, 4)));
//        System.out.println(String.valueOf(replaceBlank(source, 6)));
        System.out.println(String.valueOf(replaceBlank(source, 3)));
    }

    private static char[] replaceBlank(char[] source, int length) {
        if (source == null || source.length < length) {
            return source;
        }

        int blankNum = 0;

        for (int i = 0; i < length; i++) {
            if (' ' == source[i]) {
                blankNum++;
            }
        }

        if (length + blankNum * 2 > source.length) {
            return source;
        }

        int oldIndex = length - 1, newIndex = length + blankNum * 2 - 1;
        while (oldIndex >= 0) {
            if (source[oldIndex] == ' ') {
                source[newIndex--] = '0';
                source[newIndex--] = '2';
                source[newIndex--] = '%';
            } else {
                source[newIndex--] = source[oldIndex];
            }
            oldIndex--;
        }

        return source;
    }
}
