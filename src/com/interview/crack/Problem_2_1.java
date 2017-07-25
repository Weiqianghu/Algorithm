package com.interview.crack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by weiqianghu on 17-7-25.
 */
public class Problem_2_1 {
    public static void main(String[] args) {
        Node head = new Node(2, new Node(1, new Node(1, new Node(2, new Node(1, null)))));
        printList(head);
        printList(deleteNode2(head));
    }

    private static Node deleteNode2(Node head) {
        Node current = head;
        Node run = null;
        Node pre = null;
        while (current != null) {
            run = current.next;
            pre = current;
            while (run != null) {
                if (run.value == current.value) {
                    pre.next = run.next;
                } else {
                    pre = run;
                }
                run = run.next;
            }
            current = current.next;
        }
        return head;
    }

    private static Node deleteNode(Node head) {
        Node node = head;
        Node pre = null;
        Map<Integer, Integer> map = new HashMap<>();

        while (node != null) {
            if (map.containsKey(node.value)) {
                pre.next = node.next;
            } else {
                map.put(node.value, node.value);
                pre = node;
            }
            node = node.next;
        }


        return head;
    }

    private static void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node);
            node = node.next;
        }
        System.out.println();
    }


    private static class Node {
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
    }
}
