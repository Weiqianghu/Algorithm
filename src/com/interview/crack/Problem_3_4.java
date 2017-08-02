package com.interview.crack;

import java.util.ArrayList;
import java.util.List;

public class Problem_3_4 {
    public static void main(String[] args) {
        List<Integer> plate = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            plate.add(i);
        }
        hanoi(plate, "A", "B", "C");
    }

    private static void hanoi(List<Integer> plate, String start, String help, String end) {
        if (plate == null) {
            return;
        }
        if (plate.size() == 1) {
            System.out.println(plate.get(0) + " by " + start + " -> " + end);
            return;
        }

        hanoi(plate.subList(0, plate.size() - 1), start, end, help);
        hanoi(plate.subList(plate.size() - 1, plate.size()), start, help, end);
        hanoi(plate.subList(0, plate.size() - 1), help, start, end);
    }
}
