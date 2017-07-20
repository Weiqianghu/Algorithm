package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-8.
 */
public class Problem_16 {

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        printList(reverseList(head));
        printList(reverseList(null));
        printList(reverseList(new Node(1,null)));
    }

    private static void printList(Node head) {
        Node p = head;
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.println();
    }

    private static Node reverseList(Node head) {
        Node pre = null;
        Node p = head;


        while (p != null) {
            Node next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }

        return pre;
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
            return "["  + value + "]->";
        }
    }
}
