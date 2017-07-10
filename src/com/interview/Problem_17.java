package com.interview;

/**
 * Created by weiqianghu on 17-7-10.
 */
public class Problem_17 {
    public static void main(String[] args) {
        Node list1 = new Node(1, new Node(4, new Node(7, new Node(10, null))));
        Node list2 = new Node(-9, new Node(2, new Node(5, new Node(7, new Node(12, null)))));
        printNode(list1);
        printNode(list2);
        printNode(merge(list1, list2));
        printNode(merge(null, new Node(2, null)));
        printNode(merge(new Node(0, null), new Node(2, null)));
        printNode(merge(new Node(0, null), null));
        printNode(merge(null, null));
    }

    private static Node merge(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }


        Node p1 = list1;
        Node p2 = list2;
        Node result;

        if (p1.value < p2.value) {
            result = p1;
            p1 = p1.next;
        } else {
            result = p2;
            p2 = p2.next;
        }
        Node p = result;


        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        while (p1 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }

        while (p2 != null) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        p.next = null;

        return result;
    }

    private static void printNode(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
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
