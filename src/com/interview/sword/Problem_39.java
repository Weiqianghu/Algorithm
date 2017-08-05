package com.interview.sword;

public class Problem_39 {
    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null), new Node(5,
                        new Node(7, null,
                                new Node(8, null, null)),
                        null)),
                new Node(3,
                        null, new Node(6,
                        new Node(9, null, null),
                        null)));

        int[] depth = {0};

        printTree(root);
        System.out.println();
        System.out.println(getTheTreeDepth(root));
        System.out.println(isBalance(root, depth));
        System.out.println(depth[0]);
    }

    private static int getTheTreeDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.max(getTheTreeDepth(root.left), getTheTreeDepth(root.right));
    }

    private static boolean isBalance(Node root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        } else if (root.left == null && root.right == null) {
            depth[0] = 1;
            return true;
        }

        boolean leftBalance = isBalance(root.left, depth);
        int leftDepth = depth[0];

        depth[0] = 0;
        boolean rightBalance = isBalance(root.right, depth);
        int rightDepth = depth[0];

        depth[0] = 1 + Math.max(leftDepth, rightDepth);

        return leftBalance && rightBalance && Math.abs(leftDepth - rightDepth) <= 1;
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
}
