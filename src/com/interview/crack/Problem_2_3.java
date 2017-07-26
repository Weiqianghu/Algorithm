package com.interview.crack;

/**
 * Created by weiqianghu on 17-7-26.
 */
public class Problem_2_3 {
    public static void main(String[] args) {
        Node toDelete = new Node(4, new Node(5, new Node(3, null)));
        Node head = new Node(1, new Node(2, new Node(3, toDelete)));
        printNode(head);
        printNode(delete(head, toDelete));
    }

    private static Node delete(Node head, Node toDelete) {
        if (head == null || toDelete == null || toDelete.next == null) {
            return head;
        }


        Node next = toDelete.next;
        toDelete.value = next.value;
        toDelete.next = next.next;

        return head;
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
