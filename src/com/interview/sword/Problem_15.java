package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-8.
 */
public class Problem_15 {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        printKNode(head, 3);
        printKNode(head, 6);
        printKNode(head, 7);
        printKNode(head, 0);
        printKNode(head, 1);
    }

    private static void printKNode(Node head, int k) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node fast = head;
        int num = 0;
        while (fast != null && num != k) {
            fast = fast.next;
            num++;
        }

        if (num != k) {
            System.out.println("null");
            return;
        }

        Node slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow);
    }


    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "value=" + value + '}';
        }
    }
}
