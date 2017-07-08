package com.interview;

/**
 * Created by weiqianghu on 17-7-8.
 */
public class Problem_13 {


    public static void main(String[] args) {
        Node toBeDeleteNode = new Node(5,/* new Node(6, null)*/null);

        Node head = new Node(1, new Node(2, new Node(3, new Node(4, toBeDeleteNode))));
        deleteNode(toBeDeleteNode, toBeDeleteNode);
        printList(toBeDeleteNode);
    }

    private static void deleteNode(Node head, Node toBeDeleteNode) {
        if (toBeDeleteNode == null || toBeDeleteNode.next == null) {
            normalDeleteNode(head, toBeDeleteNode);
            return;
        }

        toBeDeleteNode.value = toBeDeleteNode.next.value;
        toBeDeleteNode.next = toBeDeleteNode.next.next;
    }

    private static void normalDeleteNode(Node head, Node toBeDeleteNode) {
        Node p = head, pre = null;
        while (p != null && p != toBeDeleteNode) {
            pre = p;
            p = p.next;
        }

        if (p != toBeDeleteNode || toBeDeleteNode == null) {
            throw new IllegalArgumentException("con't find " + toBeDeleteNode);
        }

        if (pre != null) {
            pre.next = p.next;
        } else {
            head = null;
        }
    }

    private static void printList(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
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
            return "[" + value + "]->";
        }
    }
}
