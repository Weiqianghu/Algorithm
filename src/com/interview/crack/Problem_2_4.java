package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-27.
 */
public class Problem_2_4 {
    public static void main(String[] args) {
        Node node = new Node(4, new Node(2, new Node(6, new Node(5, new Node(1, new Node(7, null))))));
        printNode(node);
        printNode(sliceList(node, node));
    }

    private static Node sliceList(Node head, Node node) {
        if (head == null || node == null) {
            return head;
        }

        Node big = null;
        Node bigP = null;
        Node smallP = null;
        Node small = null;
        Node p = head;

        while (p != null) {
            if (p.value >= node.value) {
                if (big == null) {
                    big = p;
                    bigP = big;
                } else {
                    bigP.next = p;
                    bigP = bigP.next;
                }
            } else {
                if (small == null) {
                    small = p;
                    smallP = small;
                } else {
                    smallP.next = p;
                    smallP = smallP.next;
                }
            }
            Node next = p.next;
            p.next = null;
            p = next;
        }

        if (small != null) {
            smallP.next = big;
        } else {
            small = big;
        }

        return small;
    }

    private static void printNode(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.println();
    }

    private static class Node implements Cloneable {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + value + "] -> ";
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}
