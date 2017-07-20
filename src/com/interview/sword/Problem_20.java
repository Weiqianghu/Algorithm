package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-13.
 */
public class Problem_20 {

    public static void main(String[] args) {
     /*   int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };*/

        /*int[][] matrix = {
                {1, 2, 3, 4},
        };*/

        /*int[][] matrix = {
                {1},
                {5},
                {9}
        };*/

        /*int[][] matrix = {
                {1}
        };*/

        int[][] matrix = null;

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        int startX = 0, startY = 0;

        while (rows > startY * 2 && columns > startX * 2) {
            printCircle(matrix, startX, startY, rows, columns);
            ++startX;
            ++startY;
        }
    }

    private static void printCircle(int[][] matrix, int startX, int startY, int rows, int columns) {
        int endX = (columns - 1 - startX);
        int endY = (rows - 1 - startY);

        int indexX = startX;
        int indexY = startY;

        while (indexX <= endX) {
            System.out.print(matrix[startY][indexX++] + ",");
        }

        indexY = startY + 1;
        while (indexY <= endY) {
            System.out.print(matrix[indexY++][endX] + ",");
        }

        indexX = endX - 1;
        indexY = endY;
        while (indexX >= startX && indexY > startY) {
            System.out.print(matrix[endY][indexX--] + ",");
        }

        indexY = endY - 1;
        while (indexY > startY && startX != endX) {
            System.out.print(matrix[indexY--][startX] + ",");
        }
    }
}
