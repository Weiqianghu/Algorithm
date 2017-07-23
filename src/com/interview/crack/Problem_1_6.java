package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-23.
 */
public class Problem_1_6 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        printMatrix(matrix);
        System.out.println();
        printMatrix(rotate(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }

        for (int[] aMatrix : matrix) {
            for (int value : aMatrix) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    private static int[][] rotate(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix.length != matrix[0].length) {
            return null;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0, length = rows / 2; i < length; i++) {
            for (int j = 0; j < columns; j++) {
                swap(matrix, i, j, rows - 1 - i, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }

        return matrix;
    }

    private static void swap(int[][] matrix, int row1, int column1, int row2, int column2) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1 || row1 < 0 || row2 < 0
                || row1 > matrix.length - 1 || row1 > matrix.length - 1
                || column1 < 0 || column2 < 0
                || column2 > matrix[0].length - 1 || column2 > matrix[0].length - 1) {
            return;
        }

        matrix[row1][column1] ^= matrix[row2][column2];
        matrix[row2][column2] ^= matrix[row1][column1];
        matrix[row1][column1] ^= matrix[row2][column2];
    }
}
