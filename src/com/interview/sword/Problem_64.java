package com.interview.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem_64 {
    public static void main(String[] args) {
        printTheMiddleValue();
    }

    private static void printTheMiddleValue() {
        Scanner scanner = new Scanner(System.in);
        int value;
        List<Integer> integers = new ArrayList<>();
        while ((value = scanner.nextInt()) != -1) {
            int size = integers.size();
            for (int i = size - 1; i >= 0; i--) {
                if (integers.get(i) <= value && i < size - 1) {
                    integers.add(i + 1, value);
                    break;
                } else if (integers.get(i) <= value) {
                    integers.add(value);
                    break;
                }
            }

            if (integers.size() == size && size != 0) {
                integers.add(0, value);
            } else if (integers.size() == 0) {
                integers.add(value);
            }

            System.out.println(integers + "  " + integers.get(integers.size() / 2));
        }
    }
}
