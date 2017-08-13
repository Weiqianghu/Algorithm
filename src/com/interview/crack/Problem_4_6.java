package com.interview.crack;

public class Problem_4_6 {
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
    }

    private static Node findTheNext(Node root, Node node) {
        if (root == null || node == null) {
            return null;
        }

        if (node.right != null) {
            return findTheRightMin(node);
        }

        Node p = node;
        while (p != null) {
            Node parent = p.parent;
            if (parent != null && parent.value >= p.value) {
                return parent;
            }
            p = p.parent;
        }

        return null;
    }

    private static Node findTheRightMin(Node root) {
        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return root;
        }

        return left(root.right);
    }

    private static Node left(Node left) {
        if (left == null) {
            return null;
        }

        if (left.left == null) {
            return left;
        }

        return left(left.left);
    }

    private static void linkToParent(Node root, Node parent) {
        if (root == null) {
            return;
        }

        root.parent = parent;
        linkToParent(root.left, root);
        linkToParent(root.right, root);
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

    private static void printList(Node root) {
        Node node = root;
        while (node != null) {
            System.out.print(node);
            node = node.right;
        }
    }
}
