package com.interview.crack;

public class Problem_4_1 {
    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null), new Node(5,
                        new Node(7, null, null),
                        null)),
                new Node(3,
                        null, new Node(6,
                        null, null)));

        printTree(root);
        System.out.println();
        System.out.println(isBalance(root));
    }

    private static BalanceResult isBalance(Node root) {
        if (root == null) {
            return new BalanceResult(true, 0);
        } else if (root.left == null && root.right == null) {
            return new BalanceResult(true, 1);
        }

        BalanceResult leftBalance = isBalance(root.left);
        BalanceResult rightBalance = isBalance(root.right);

        return new BalanceResult(leftBalance.isBalance &&
                rightBalance.isBalance &&
                Math.abs(leftBalance.depth - rightBalance.depth) < 2,
                1 + Math.max(leftBalance.depth, rightBalance.depth));
    }

    private static class BalanceResult {
        private boolean isBalance;
        private int depth;

        BalanceResult(boolean isBalance, int depth) {
            this.isBalance = isBalance;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "BalanceResult{" +
                    "isBalance=" + isBalance +
                    ", depth=" + depth +
                    '}';
        }
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
