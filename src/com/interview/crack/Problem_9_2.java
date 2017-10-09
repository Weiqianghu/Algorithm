package com.interview.crack;

public class Problem_9_2 {
    public static void main(String[] args) {
        System.out.println(theRoutes(1, 1));
        System.out.println(theRoutes(1, 4));
        System.out.println(theRoutes(4, 3));
        System.out.println(theRoutes(0, 9));

        int[][] arr = {
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 1, 0}
        };
        int[][] route = new int[4][4];
        findTheRoute(arr, 3, 3, route);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(route[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static int theRoutes(int x, int y) {
        if (x < 0 || y < 0) {
            return -1;
        } else if (x == 0) {
            return y;
        } else if (y == 0) {
            return x;
        }

        int[][] arr = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[x][y];
    }

    private static boolean findTheRoute(int[][] arr, int x, int y, int[][] route) {
        if (arr == null || arr.length <= x || arr[0].length <= y
                || route == null || route.length <= x || route[0].length <= y
                || x < 0 || y < 0) {
            return false;
        }

        if (arr[x][y] == 1) {
            return false;
        } else if (x == 0 && y == 0) {
            route[x][y] = 1;
            return true;
        }

        route[x][y] = 1;
        if (findTheRoute(arr, x - 1, y, route) || findTheRoute(arr, x, y - 1, route)) {
            return true;
        }
        route[x][y] = 0;
        return false;
    }
}
