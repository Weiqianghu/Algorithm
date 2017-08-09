package com.interview.crack;

public class Problem_4_3 {
    public static void main(String[] ags) {
        int[] sortedInts = {1, 3, 4, 5, 6, 7, 8, 9};
        Node root = makeTree(sortedInts);
        printTree(root);
    }

    private static Node makeTree(int[] sortedInts) {
        if (sortedInts == null || sortedInts.length < 1) {
            return null;
        }

        int middle = sortedInts.length / 2;

        return new Node(sortedInts[middle],
                makeTree(sliceArray(sortedInts, 0, middle)),
                makeTree(sliceArray(sortedInts, middle + 1, sortedInts.length)));
    }


    private static class Node {
        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "{" + value + "}";
        }
    }


    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root);
            printTree(root.left);
            printTree(root.right);
        }
    }

    private static int[] sliceArray(int[] array, int start, int end) {
        if (array == null || start < 0 || start >= array.length || end < start || end > array.length) {
            return null;
        }

        int[] result = new int[end - start];

        for (int i = start, j = 0; i < end; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }
}
