package com.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by weiqianghu on 17-7-15.
 */
public class Problem_23 {
    public static void main(String[] args) {
        Node root = new Node(8,
                new Node(6,
                        new Node(5, null, null), new Node(7, null, null)),
                new Node(10,
                        new Node(9, null, null), new Node(11, null, null)));

        printLine(root);
        printLine(new Node(1, new Node(2, null, null), null));
        printLine(new Node(1, new Node(2, null, null), new Node(3, null, null)));
        printLine(new Node(1, null, new Node(2, null, null)));
        printLine(new Node(1, null, new Node(2, new Node(3, null, null), null)));
    }

    private static void printLine(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.peek() != null) {
            Node node = queue.remove();
            System.out.print(node);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }
}
