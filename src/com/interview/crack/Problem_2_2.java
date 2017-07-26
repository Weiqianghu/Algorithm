package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-26.
 */
public class Problem_2_2 {
    public static void main(String[] args) {
        Node head = new Node(2, new Node(3, new Node(4, new Node(5, null))));
        printNode(head);
        printNode(findLastK(head, 3));
        printNode(findLastK(head, 1));
        printNode(findLastK(head, 4));
        printNode(findLastK(head, 5));
    }

    private static Node findLastK(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node slow = head, fast = head;

        int step = 1;
        while (fast != null && step < k) {
            fast = fast.next;
            ++step;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return new Node(slow.value, null);
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
