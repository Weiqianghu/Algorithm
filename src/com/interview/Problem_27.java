package com.interview;

/**
 * Created by weiqianghu on 17-7-18.
 */
public class Problem_27 {
    public static void main(String[] args) {
        Node root = new Node(10,
                new Node(6,
                        new Node(4, null, null), new Node(8, null, null)),
                new Node(14,
                        new Node(12, null, null), new Node(16, null, null)));
        printTree(root);
        System.out.println();

        Node head = tree2List(root);
        printList(head);

        printList(tree2List(new Node(2, null, null)));
        printList(tree2List(new Node(2, new Node(1, null, null), null)));
        printList(tree2List(new Node(2, null, new Node(3, null, null))));
        printList(tree2List(null));
    }

    private static Node tree2List(Node root) {
        if (root == null) {
            return null;
        }

        Node head;

        if (root.left == null) {
            head = root;
        } else {
            Node pre = tree2List(root.left);
            head = pre;
            while (pre.right != null) {
                pre = pre.right;
            }

            pre.right = root;
            root.left = pre;
        }

        if (root.right != null) {
            Node next = tree2List(root.right);
            next.left = root;
            root.right = next;
        }

        return head;
    }


    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root);
        printTree(root.left);
        printTree(root.right);
    }

    private static void printList(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p);
            p = p.right;
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
