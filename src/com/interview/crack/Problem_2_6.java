package com.interview.crack;

import java.util.HashMap;
import java.util.Map;

public class Problem_2_6 {
    public static void main(String[] args) {
        Node circleHead = new Node(3, new Node(4, new Node(5, null)));
        circleHead.next.next.next = circleHead;

        Node head = new Node(1, new Node(2, circleHead));

        printNode(head);

        printNode(findCircleHead(head));
    }

    private static Node findCircleHead(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        Node fast = head.next.next;
        Node slow = head.next;

        while (fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    private static void printNode(Node head) {
        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while (node != null && !map.containsKey(node)) {
            System.out.print(node);
            map.put(node, node);
            node = node.next;
        }

        System.out.println();

        if (node != null) {
            System.out.println("circle head:" + node);
        }
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
