package com.interview.sword;

import java.util.HashMap;
import java.util.Map;

public class Problem_56 {

    public static void main(String[] args) {
        Node circleHead = new Node(3, new Node(4, new Node(5, null)));
        circleHead.next.next.next = circleHead;

        Node head = new Node(1, new Node(2, circleHead));

        printNode(head);

        System.out.println(findCircleHead(head));
        System.out.println(findCircleHead(circleHead.next.next.next));
    }

    private static Node findCircleHead(Node head) {
        int circleLength = getTheCircleLength(head);
        if (circleLength == 0) {
            return null;
        }

        Node front = head;
        while (circleLength > 0) {
            front = front.next;
            circleLength--;
        }

        Node behind = head;
        while (behind != front) {
            front = front.next;
            behind = behind.next;
        }

        return behind;
    }

    private static int getTheCircleLength(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return 0;
        }

        Node fast = head.next.next;
        Node slow = head.next;

        while (fast != slow && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast == null || fast.next == null) {
            return 0;
        }

        int circleLength = 1;
        Node node = fast.next;
        while (node != fast) {
            node = node.next;
            circleLength++;
        }
        return circleLength;
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
