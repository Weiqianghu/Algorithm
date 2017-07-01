package com.interview;

/**
 * Created by weiqianghu on 17-7-1.
 */
public class Problem_03 {


    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(searchNumber(1, array));
        System.out.println(searchNumber(15, array));
        System.out.println(searchNumber(12, array));
        System.out.println(searchNumber(7, array));
        System.out.println(searchNumber(23, array));
        System.out.println(searchNumber(0, array));
        System.out.println(searchNumber(5, array));
    }

    private static int searchNumber(int n, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return -1;
        }

        int width = array[0].length;
        int height = array.length;
        int rowIndex = width - 1;
        int columnIndex = 0;

        while (rowIndex >= 0 && columnIndex < height) {
            if (array[columnIndex][rowIndex] == n) {
                return n;
            } else if (array[columnIndex][rowIndex] < n) {
                columnIndex++;
            } else {
                rowIndex--;
            }
        }

        return -1;
    }
}
