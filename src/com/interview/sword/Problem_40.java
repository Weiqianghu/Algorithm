package com.interview.sword;

public class Problem_40 {
    public static void main(String[] args) {
        int[] ints = {2, 4, 3, 6, 3, 2, 5, 5, 4, 8};
        for (int i : ints) {
            System.out.print(i + ",");
        }
        System.out.println();
        printTheOnlyOnce(ints);
    }

    private static void printTheOnlyOnce(int[] ints) {
        if (ints == null) {
            return;
        }

        int xorResult = 0;
        for (int i : ints) {
            xorResult ^= i;
        }

        int index = 1;
        while ((xorResult & index) != index) {
            index = index << 1;
        }


        int theNum1 = 0;
        int theNum2 = 0;
        for (int i : ints) {
            if ((i & index) == index) {
                theNum1 = theNum1 ^ i;
            } else {
                theNum2 = theNum2 ^ i;
            }
        }

        System.out.println(theNum1 + "," + theNum2);
    }
}
