package com.interview.sword;

public class Problem_63 {
    public static void main(String[] args) {
        Node root = new Node(6,
                new Node(4,
                        new Node(1, null, null),
                        new Node(5, null, null)),
                new Node(8,
                        new Node(7, null, null),
                        new Node(9, null, null)));

        System.out.println(printTheKNode(root, 5));
    }

    private static Node printTheKNode(Node root, int k) {
        if (root == null || k < 1) {
            return null;
        }
        int[] tmp = {k};
        return theKNode(root, tmp);
    }

    private static Node theKNode(Node root, int[] k) {
        Node result = null;
        if (root.left != null) {
            result = theKNode(root.left, k);
        }
        if (result == null) {
            if (k[0] == 1) {
                result = root;
            } else {
                k[0]--;
            }
        }
        if (result == null && root.right != null) {
            result = theKNode(root.right, k);
        }
        return result;
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
