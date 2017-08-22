package com.interview.sword;

public class Problem_58 {
    public static void main(String[] args) {
        Node node = new Node(2,
                new Node(1,
                        null, null),
                new Node(3,
                        null, null));

        Node root = new Node(4,
                node,
                new Node(6,
                        new Node(5,
                                null, null),
                        new Node(7,
                                null, null)));
        linkToParent(root, null);
        System.out.println(findTheNext(root, node));

        Node node1 = new Node(1, null, null);
        linkToParent(node1, null);
        System.out.println(findTheNext(node1, node1));

        Node node2 = new Node(2, node1, null);
        linkToParent(node2, null);
        System.out.println(findTheNext(node2, node1));

        Node node3 = new Node(3, node2, new Node(4, null, null));
        linkToParent(node3, null);
        System.out.println(findTheNext(node3, node1));

        Node node4 = new Node(4, new Node(6, null, null), node3);
        linkToParent(node4, null);
        System.out.println(findTheNext(node4, node3));

        System.out.println(findTheNext(node4, node2));
        System.out.println(findTheNext(node4, node1));
    }

    private static Node findTheNext(Node root, Node node) {
        if (root == null || node == null) {
            return null;
        }

        if (node.parent == null || node.right != null) {
            return node.right;
        }

        while (node.parent != null && node == node.parent.left) {
            if (node.parent.right != null) {
                return node.parent.right;
            }
            node = node.parent;
        }

        if (node.parent == null) {
            return node.right;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }

        if (node.parent == null) {
            return node.right;
        }

        return node.parent.right;
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

    private static void linkToParent(Node root, Node parent) {
        if (root == null) {
            return;
        }

        root.parent = parent;
        linkToParent(root.left, root);
        linkToParent(root.right, root);
    }
}
