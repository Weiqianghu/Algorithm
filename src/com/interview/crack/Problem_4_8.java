package com.interview.crack;

public class Problem_4_8 {

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

        System.out.println(isTheChild(
                new Node(8, new Node(7, new Node(9, null, null), null), null),
                new Node(8, new Node(7, new Node(9, null, null), null), null)));
    }

    private static boolean isTheChild(Node parent, Node child) {
        if (parent == null && child == null) {
            return true;
        }

        if (parent == null || child == null) {
            return false;
        }

        if (parent.left == null && parent.right == null && child.left == null && child.right == null) {
            return parent.value == child.value;
        }

        if (parent.value == child.value) {
            boolean isLeft = isTheChild(parent.left, child.left);
            boolean isRight = isTheChild(parent.right, child.right);
            return isLeft && isRight;
        }

        return isTheChild(parent.left, child) || isTheChild(parent.right, child);
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
