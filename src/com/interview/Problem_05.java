package com.interview;

/**
 * Created by weiqianghu on 17-7-1.
 */
public class Problem_05 {
    public static void main(String[] args) {
        Node head = new Node(10, new Node(15, new Node(23, new Node(13, new Node(89, new Node(67, null))))));
        reversePrintNode(head);
    }

    private static void reversePrintNode(Node head) {
        if (head.next == null) {
            System.out.print(head);
            return;
        }
        reversePrintNode(head.next);
        System.out.print(head);
    }


    private static class Node {
        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }

        int key;
        Node next;

        @Override
        public String toString() {
            return " [" + key + "] ";
        }
    }
}
