package com.interview.crack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-24.
 */
public class Problem_1_7 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 0},
                {2, 5, 0},
                {8, 5, 9}
        };
        printMatrix(matrix);
        printMatrix(convert(matrix));
    }

    private static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] convert(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return matrix;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    columnList.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rowList.contains(i) || columnList.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}
