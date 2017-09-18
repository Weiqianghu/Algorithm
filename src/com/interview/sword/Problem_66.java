package com.interview.sword;

public class Problem_66 {


    private static boolean hasPath(char[][] matrix, String str) {
        if (matrix == null || str == null || matrix.length < 1) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[rows - 1].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                State state = new State();
                state.str = str;
                state.matrix = matrix;
                state.rows = rows;
                state.cols = cols;
                state.row = row;
                state.col = col;
            }
        }
        return false;
    }

    private static boolean hasPathCore(State state) {
        if (state.str.length() == state.pathLength) {
            return true;
        }

        boolean hasPath = false;
        if (state.row >= 0 && state.row < state.rows && state.col >= 0 && state.col < state.cols
                && state.matrix[state.row][state.col] == state.str.charAt(state.pathLength)
                && !state.visited[state.row][state.col]) {
            hasPath = hasPathCore(state.colMinus())
                    || hasPathCore(state.colAdd())
                    || hasPathCore(state.rowMinus())
                    || hasPathCore(state.rowAdd());
        }

        if (!hasPath) {
            --state.pathLength;
            state.visited[state.row][state.col] = false;
        }
        return hasPath;
    }

    private static class State {
        char[][] matrix;
        int rows;
        int cols;
        int row;
        int col;
        String str;
        int pathLength;
        boolean[][] visited;

        State colMinus() {
            State newState = copy();
            newState.col--;
            return newState;
        }

        State rowMinus() {
            State newState = copy();
            newState.row--;
            return newState;
        }

        State colAdd() {
            State newState = copy();
            newState.col++;
            return newState;
        }

        State rowAdd() {
            State newState = copy();
            newState.row++;
            return newState;
        }

        State copy() {
            State newState = new State();
            newState.matrix = matrix.clone();
            newState.rows = rows;
            newState.cols = cols;
            newState.row = row;
            newState.col = col;
            newState.str = str;
            newState.pathLength = pathLength;
            newState.visited = visited.clone();
            return newState;
        }
    }
}
