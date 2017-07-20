package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-11.
 */
public class Problem_18 {

    public static void main(String[] args) {
        Node parent = new Node(8,
                new Node(8,
                        new Node(9, null, null), new Node(2,
                        new Node(4, null, null), new Node(7, null, null))),
                new Node(7, null, null));

        Node child = new Node(8,
                new Node(9, null, null), new Node(2, null, null));

        printTree(parent);
        System.out.println();
        printTree(child);
        System.out.println();

        System.out.println(isChild(parent, child));
    }

    private static boolean isChild(Node parent, Node child) {
        boolean result = false;

        if (parent != null && child != null) {
            if (parent.value == child.value) {
                result = isChild2(parent, child);
            }
            if (!result) {
                result = isChild(parent.left, child);
            }
            if (!result) {
                result = isChild(parent.right, child);
            }
        }

        return result;
    }

    private static boolean isChild2(Node parent, Node child) {
        return child == null || parent != null &&
                parent.value == child.value &&
                isChild2(parent.left, child.left) &&
                isChild2(parent.right, child.right);

    }

    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root);
            printTree(root.left);
            printTree(root.right);
        }
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
