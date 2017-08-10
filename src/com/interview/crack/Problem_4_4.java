package com.interview.crack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem_4_4 {
    public static void main(String[] args) {
        /*Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null), new Node(5,
                        new Node(7, null, null),
                        null)),
                new Node(3,
                        null, new Node(6,
                        null, null)));*/

//        Node root = new Node(1, null, null);

        Node root = new Node(1,
                new Node(2,
                        new Node(3,
                                new Node(4,
                                        new Node(5,
                                                null, null),
                                        null),
                                null),
                        null),
                null);

        List<Node> list = makeList(root);
        for (Node node : list) {
            printList(node);
            System.out.println();
        }
    }

    private static List<Node> makeList(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new ArrayDeque<>();
        List<Node> result = new ArrayList<>();

        queue.add(root);
        queue.add(createSplit());
        Node current = null;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (isSplit(node) && queue.isEmpty()) {
                break;
            }

            if (isSplit(node)) {
                queue.add(createSplit());
                current.left = null;
                current.right = null;
                current = null;
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

            if (current == null) {
                result.add(node);
                current = node;
            } else {
                current.left = null;
                current.right = node;
                current = node;
            }
        }

        return result;
    }

    private static Node createSplit() {
        return new Node(-0x110, null, null);
    }

    private static boolean isSplit(Node node) {
        return node != null && node.value == (-0x110) && node.left == null && node.right == null;
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


    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root);
            printTree(root.left);
            printTree(root.right);
        }
    }
}
