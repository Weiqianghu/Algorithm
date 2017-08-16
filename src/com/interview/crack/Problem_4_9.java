package com.interview.crack;

import java.util.ArrayList;
import java.util.List;

public class Problem_4_9 {


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

        List<Node> paths = new ArrayList<>();
        getThePath(root, sum, paths);
    }

    private static void getThePath(Node root, int sum, List<Node> path) {
        if ((root == null && sum != 0) || path == null) {
            return;
        }

        if (root == null) {
            System.out.println(path);
            return;
        }

        path.add(root);

        if (root.left == null && root.right == null && root.value == sum) {
            System.out.println(path);
            path.remove(root);
            return;
        } else if (root.left == null && root.right == null) {
            path.remove(root);
            return;
        }

        if (root.left == null && root.value == sum) {
            System.out.println(path);
        }

        if (root.right == null && root.value == sum) {
            System.out.println(path);
        }

        if (root.left != null) {
            getThePath(root.left, sum - root.value, path);
        }

        if (root.right != null) {
            getThePath(root.right, sum - root.value, path);
        }

        path.remove(root);
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
