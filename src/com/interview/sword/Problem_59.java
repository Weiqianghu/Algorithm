package com.interview.sword;

public class Problem_59 {
    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(3, null, null),
                        new Node(4, null, null)),
                new Node(2,
                        new Node(4, null, null),
                        new Node(3, null, null)));
        System.out.println(isSymmetric(root));
    }

    private static boolean isSymmetric(Node root) {
        return isSymmetric(root, root);
    }

    private static boolean isSymmetric(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
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

        Node parent;

        @Override
        public String toString() {
            return "{" + value + "}";
        }
    }
}
