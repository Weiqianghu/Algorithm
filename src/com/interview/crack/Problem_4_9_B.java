package com.interview.crack;

public class Problem_4_9_B {

    public static void main(String[] args) {
        Node root = new Node(2,
                new Node(4,
                        new Node(3, null, null),
                        new Node(5, null, null)),
                new Node(3,
                        new Node(6, null, null),
                        new Node(4, null, null)));
        printThePath(root, 11);
        printThePath(root, 9);

        printThePath(new Node(1, new Node(2, null, null), null), 1);
        printThePath(new Node(1, new Node(2, null, null), null), 3);
        printThePath(new Node(1, new Node(2, null, null), null), 5);
        printThePath(new Node(1, new Node(2, null, null), null), 2);

        printThePath(new Node(1, new Node(2, null, new Node(-1, null, null)), null), 2);
    }

    private static void printThePath(Node root, int sum) {
        if (root == null) {
            return;
        }

        int depth = depth(root);
        Node[] path = new Node[depth];
        findSum(root, sum, path, 0);
    }

    private static void findSum(Node root, int sum, Node[] path, int level) {
        if (root == null || path == null || level < 0) {
            return;
        }

        path[level] = root;

        int t = 0;
        for (int i = level; i >= 0; i--) {
            t += path[i].value;
            if (t == sum) {
                printPath(path, i, level);
            }
        }

        findSum(root.left, sum, path, level + 1);
        findSum(root.right, sum, path, level + 1);
    }

    private static void printPath(Node[] path, int start, int end) {
        if (path == null || start < 0 || start > end || end > path.length - 1) {
            return;
        }

        for (int i = start; i <= end; i++) {
            System.out.print(path[i]);
        }
        System.out.println();
    }

    private static int depth(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
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
}
