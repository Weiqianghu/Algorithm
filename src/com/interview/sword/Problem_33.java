package com.interview.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-26.
 */
public class Problem_33 {
    public static void main(String[] args) {
        int[] arr = {3, 32, 321};
        System.out.println(minNumber(arr));
    }

    private static String minNumber(int[] arr) {
        if (arr == null || arr.length < 1) {
            return "0";
        }

        List<String> list = new ArrayList<>();
        for (int i : arr) {
            list.add(String.valueOf(i));
        }

        list.sort((o1, o2) -> {
            char[] chars1 = (o1 + o2).toCharArray();
            char[] chars2 = (o2 + o1).toCharArray();

            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    return chars1[i] - chars2[i];
                }
            }
            return 0;
        });

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }

}
