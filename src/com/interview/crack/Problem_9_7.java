package com.interview.crack;

public class Problem_9_7 {
    public static void main(String[] args) {
        int[][] screen = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        print(screen);
        paintFill(screen, 1, 1, 0, 2);
        print(screen);
    }

    private static void paintFill(int[][] screen, int x, int y, int srcColor, int dstColor) {
        if (screen == null || x < 0 || y < 0 || screen.length < 1 || screen[0].length < 1
                || screen.length - 1 < x || screen[0].length - 1 < y) {
            return;
        }

        if (screen[x][y] != srcColor) {
            return;
        }

        screen[x][y] = dstColor;
        paintFill(screen, x - 1, y, srcColor, dstColor);
        paintFill(screen, x + 1, y, srcColor, dstColor);
        paintFill(screen, x, y - 1, srcColor, dstColor);
        paintFill(screen, x, y + 1, srcColor, dstColor);
    }

    private static void print(int[][] screen) {
        if (screen == null || screen.length < 1 || screen[0].length < 1) {
            return;
        }

        for (int i = 0, length = screen.length; i < length; i++) {
            for (int j = 0, size = screen[0].length; j < size; j++) {
                System.out.print(screen[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }
}
