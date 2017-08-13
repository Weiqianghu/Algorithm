package com.interview.sword;

import java.util.ArrayList;
import java.util.List;

public class Problem_45 {
    public static void main(String[] args) {
        System.out.println(theLastNumber(5, 2));
        System.out.println(theLastNumber(5, 3));
        System.out.println(theLastNumber(3, 5));
        System.out.println(theLastNumber(0, 2));
        System.out.println(theLastNumber(4000, 2000));
    }

    private static int theLastNumber(int n, int m) {
        if (n < 1) {
            return -0x100;
        }

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }

        int index = 0;
        int count = 1;
        while (numbers.size() > 1) {
            while (count < m) {
                if (index < numbers.size() - 1) {
                    index++;
                } else {
                    index = 0;
                }
                count++;
            }
            count = 1;
            numbers.remove(index);

            if (index == numbers.size()) {
                index = 0;
            }
        }

        return numbers.get(0);
    }
}
