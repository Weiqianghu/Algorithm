package com.interview.crack;

public class Problem_4_5 {

    public static void main(String[] args) {
        Node root = new Node(4,
                new Node(2,
                        new Node(19,
                                null, null),
                        new Node(3,
                                null, null)),
                new Node(6,
                        new Node(5,
                                null, null),
                        new Node(7,
                                null, null)));

//        Node root = new Node(4, new Node(3, null, null), new Node(6, null, null));

        System.out.println(isSearchTree(root));
    }

    private static Result isSearchTree(Node root) {
        if (root == null) {
            return new Result(true, 0, 0);
        }

        if (root.left == null && root.right == null) {
            return new Result(true, root.value, root.value);
        }

        Result result = new Result();
        Result leftResult = null, rightResult = null;

        if (root.left != null) {
            leftResult = isSearchTree(root.left);
        }

        if (root.right != null) {
            rightResult = isSearchTree(root.right);
        }

        if (leftResult != null) {
            result.minValue = leftResult.minValue < root.value ? leftResult.minValue : root.value;
            result.isSearchTree = leftResult.isSearchTree && root.value >= leftResult.maxValue;
        } else {
            result.minValue = root.value;
        }

        if (rightResult != null) {
            if (leftResult == null || result.isSearchTree) {
                result.isSearchTree = rightResult.isSearchTree && root.value <= rightResult.minValue;
            }
            result.maxValue = rightResult.maxValue > root.value ? rightResult.maxValue : root.value;
        } else {
            result.maxValue = root.value;
        }

        return result;
    }

    private static class Result {
        Result() {
        }

        Result(boolean isSearchTree, int maxValue, int minValue) {
            this.isSearchTree = isSearchTree;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }

        boolean isSearchTree;
        int maxValue;
        int minValue;

        @Override
        public String toString() {
            return "Result{" +
                    "isSearchTree=" + isSearchTree +
                    ", maxValue=" + maxValue +
                    ", minValue=" + minValue +
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

    private static void printList(Node root) {
        Node node = root;
        while (node != null) {
            System.out.print(node);
            node = node.right;
        }
    }
}
