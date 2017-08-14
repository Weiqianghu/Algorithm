package com.interview.crack;

public class Problem_4_7 {
    public static void main(String[] args) {
        Node node1 = new Node(1,
                null, null);

        Node node2 = new Node(5,
                null, null);

        Node root = new Node(4,
                new Node(2,
                        node1,
                        new Node(3,
                                null, null)),
                new Node(6,
                        node2,
                        new Node(7,
                                null, null)));

        Result result = findTheAncestor(root, node1, node2);
        System.out.println(result);
    }

    private static Result findTheAncestor(Node root, Node node1, Node node2) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == node1 && root == node2) {
            return new Result(root, true);
        }

        Result leftResult = findTheAncestor(root.left, node1, node2);
        if (leftResult.isAncestor) {
            return leftResult;
        }

        Result rightResult = findTheAncestor(root.right, node1, node2);
        if (rightResult.isAncestor) {
            return rightResult;
        }

        if (rightResult.node != null && leftResult.node != null) {
            return new Result(root, true);
        } else if (root == node1 || root == node2) {
            boolean isAncestor = leftResult.node != null || rightResult.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(leftResult.node != null ? leftResult.node : rightResult.node, false);
        }
    }

    private static class Result {
        Node node;
        boolean isAncestor;

        public Result() {
        }

        Result(Node node, boolean isAncestor) {
            this.node = node;
            this.isAncestor = isAncestor;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "node=" + node +
                    ", isAncestor=" + isAncestor +
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
}
