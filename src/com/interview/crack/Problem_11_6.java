package com.interview.crack;

public class Problem_11_6 {
    public static void main(String[] args) {

    }

    private static boolean find(int[][] vector, int target) {
        if (vector == null || vector.length < 1 || vector[0].length < 1) {
            return false;
        }

        int rows = 0;
        int columns = vector[0].length - 1;
        while (rows < vector.length && columns >= 0) {
            if (vector[rows][columns] == target) {
                return true;
            } else if (vector[rows][columns] > target) {
                columns--;
            } else {
                rows++;
            }
        }
        return false;
    }
}
