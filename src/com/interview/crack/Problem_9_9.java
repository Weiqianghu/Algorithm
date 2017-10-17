package com.interview.crack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Problem_9_9 {
    public static void main(String[] args) {
        queens();
    }

    private static void queens() {
        List<Integer> arr = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> mixResult = mix(arr);

        int count = 0;
        for (List<Integer> mix : mixResult) {
            if (check(mix)) {
                System.out.println((++count) + ":" + mix);
            }
        }
    }

    private static boolean check(List<Integer> mix) {
        if (mix == null || mix.size() < 1) {
            return false;
        }

        for (int i = 1, length = mix.size(); i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (Objects.equals(mix.get(i), mix.get(j)) || ((i - j) == Math.abs(mix.get(i) - mix.get(j)))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static List<List<Integer>> mix(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();

        if (arr == null || arr.size() < 1) {
            return result;
        } else if (arr.size() == 1) {
            result.add(arr);
            return result;
        }

        List<List<Integer>> sons = mix(arr.subList(0, arr.size() - 1));
        int current = arr.get(arr.size() - 1);
        for (List<Integer> son : sons) {
            for (int i = 0; i <= son.size(); i++) {
                List<Integer> mix = new ArrayList<>();
                mix.addAll(son.subList(0, i));
                mix.add(current);
                mix.addAll(son.subList(i, son.size()));
                result.add(mix);
            }
        }
        return result;
    }
}
