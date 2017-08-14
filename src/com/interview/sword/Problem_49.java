package com.interview.sword;

import java.util.ArrayList;
import java.util.List;

public class Problem_49 {
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

        Node parent = findTheParent(root, node1, node2);
        System.out.println(parent);
    }

    private static Node findTheParent(Node root, Node node1, Node node2) {
        if (root == null || node1 == null || node2 == null) {
            return root;
        }

        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();

        getThePath(root, node1, path1);
        getThePath(root, node2, path2);

        Node parent = null;

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                parent = path1.get(i);
            }
        }

        return parent;
    }

    private static boolean getThePath(Node root, Node target, List<Node> result) {
        if (root == null || target == null) {
            return false;
        }

        result.add(root);

        if (root == target) {
            return true;
        }

        boolean isTarget = getThePath(root.left, target, result);
        if (isTarget) {
            return true;
        } else {
            result.remove(root);
        }

        result.add(root);

        isTarget = getThePath(root.right, target, result);
        if (isTarget) {
            return true;
        } else {
            result.remove(root);
        }

        return false;
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
