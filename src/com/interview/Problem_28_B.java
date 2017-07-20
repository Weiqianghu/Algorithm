package com.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-20.
 */
public class Problem_28_B {
    public static void main(String[] args) {
        int[] ints = {3, 6, 7, 8, 1, 6, 5, 3};
        List<Integer> integers = arr2List(ints);
        List<List<Integer>> result = mixInts(integers);
        System.out.println(result);
    }

    private static List<List<Integer>> mixInts(List<Integer> integers) {
        List<List<Integer>> result = new ArrayList<>();

        if (integers == null) {
            return result;
        }

        if (integers.size() == 1) {
            result.add(new ArrayList<>(integers));
            return result;
        }

        List<List<Integer>> part = mixInts(integers.subList(0, integers.size() - 1));

        for (List<Integer> integerList : part) {
            integerList.add(integers.get(integers.size() - 1));
            for (int j = 0, size = integerList.size(); j < size; j++) {
                swap(integerList, j, size - 1);
                result.add(new ArrayList<>(integerList));
                swap(integerList, size - 1, j);
            }
        }

        return result;
    }

    private static void swap(List<Integer> integers, int index1, int index2) {
        if (integers == null || index1 < 0 || index1 > integers.size() - 1 || index2 < 0 || index2 > integers.size() - 1) {
            return;
        }

        Integer temp = integers.get(index1);
        integers.set(index1, integers.get(index2));
        integers.set(index2, temp);
    }


    private static List<Integer> arr2List(int[] ints) {
        if (ints == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        for (int i : ints) {
            result.add(i);
        }

        return result;
    }


}
