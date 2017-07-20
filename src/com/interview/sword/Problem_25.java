package com.interview.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weiqianghu on 17-7-16.
 */
public class Problem_25 {
    public static void main(String[] args) {
        Node root = new Node(10,
                new Node(5,
                        new Node(4, null, null), new Node(7, null, null)),
                new Node(6, null, new Node(3, null, null)));
        printPath(root, 19, new ArrayList<>());
        printPath(new Node(12, new Node(3, new Node(5, null, null), null), null), 15, new ArrayList<>());

    }

    private static void printPath(Node root, int count, List<Node> path) {
        if (root == null || path == null) {
            return;
        }

        if (root.left == null && root.right == null && root.value == count) {
            path.add(root);
            printNodes(path);
            path.remove(root);
            return;
        } else if (root.left == null && root.right == null) {
            return;
        }


        path.add(root);
        printPath(root.left, count - root.value, path);
        printPath(root.right, count - root.value, path);
        path.remove(root);
    }

    private static void printNodes(List<Node> path) {
        if (path == null) {
            return;
        }
        for (Node node : path) {
            System.out.print(node);
        }
        System.out.println();
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value, Node left, Node right) {
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
