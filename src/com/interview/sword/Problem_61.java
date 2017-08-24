package com.interview.sword;

import java.util.Stack;

public class Problem_61 {

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null),
                        new Node(5, null, null)),
                new Node(3,
                        new Node(6, null, null),
                        new Node(7, null, null)));
        printTree(root);
        printTree(new Node(1, null, null));
        printTree(new Node(1, new Node(2, null, null), null));
        printTree(new Node(1, null, new Node(2, null, null)));
    }

    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> oddStack = new Stack<>();
        Stack<Node> evenStack = new Stack<>();
        oddStack.push(root);
        while (!oddStack.empty() || !evenStack.empty()) {

            while (!oddStack.empty()) {
                Node node = oddStack.pop();
                System.out.print(node);
                if (node.left != null) {
                    evenStack.push(node.left);
                }
                if (node.right != null) {
                    evenStack.push(node.right);
                }
            }

            System.out.println();

            while (!evenStack.empty()) {
                Node node = evenStack.pop();
                System.out.print(node);
                if (node.right != null) {
                    oddStack.push(node.right);
                }
                if (node.left != null) {
                    oddStack.push(node.left);
                }
            }

            System.out.println();
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
