package com.interview.crack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_9_4 {
    public static void main(String[] args) {
        System.out.println(theSons(Arrays.asList(1, 2)));
        System.out.println(theSons(Arrays.asList(1, 2, 3)));
        System.out.println(theSons(Arrays.asList(1, 2, 3,4)));

        System.out.println(theSonsPlus(Arrays.asList(1, 2)));
        System.out.println(theSonsPlus(Arrays.asList(1, 2, 3)));
        System.out.println(theSonsPlus(Arrays.asList(1, 2, 3,4)));
    }

    private static List<List<Integer>> theSons(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        if (list.size() == 1) {
            result.add(list);
            return result;
        }

        result.addAll(theSons(list.subList(0, list.size() - 1)));

        int current = list.get(list.size() - 1);
        for (int i = 0, length = result.size(); i < length; i++) {
            List<Integer> integers = copy(result.get(i));
            integers.add(current);
            result.add(integers);
        }
        result.add(Arrays.asList(current));

        return result;
    }

    private static List<Integer> copy(List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        if (integers == null) {
            return null;
        }

        result.addAll(integers);
        return result;
    }

    private static List<List<Integer>> theSonsPlus(List<Integer> list) {
        List<List<Integer>> sons = new ArrayList<>();
        if (list == null || list.size() < 1) {
            return sons;
        }

        int max = 1 << list.size();
        for (int i = 1; i < max; i++) {
            sons.add(convert(i, list));
        }

        return sons;
    }

    private static List<Integer> convert(int x, List<Integer> integers) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        for (int k = x; k > 0; k >>= 1) {
            if ((k & 1) == 1) {
                result.add(integers.get(index));
            }
            index++;
        }
        return result;
    }
}
