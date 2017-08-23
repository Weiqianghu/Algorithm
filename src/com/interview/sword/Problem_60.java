package com.interview.sword;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_60 {

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(3, null, null),
                        new Node(4, null, null)),
                new Node(2,
                        new Node(4, null, null),
                        new Node(3, null, null)));
        printTree(root);
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int toBePrint = 1;
        int nextLevel = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node + " ");
            toBePrint--;

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel++;
            }
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
