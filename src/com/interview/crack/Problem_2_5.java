package com.interview.crack;

public class Problem_2_5 {
    public static void main(String[] args) {
        Node node1 = new Node(7, new Node(9, new Node(6, null)));
        Node node2 = new Node(9, new Node(2, null));

        printNode(node1);
        printNode(node2);

        printNode(add(node1, node2));

        printNode(add2(node1, node2));
    }

    private static Node add2(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        int length1 = length(node1);
        int length2 = length(node2);

        if (length1 > length2) {
            node2 = fillNode(node2, length1 - length2);
        } else if (length2 > length1) {
            node1 = fillNode(node1, length2 - length1);
        }

        Node current = new Node(0, null);
        current.value = addStep(node1, node2, current);
        return current;
    }

    private static Node fillNode(Node head, int length) {
        Node result = null;
        Node node = null;
        for (int i = 0; i < length; i++) {
            if (result == null) {
                result = new Node(0, null);
                node = result;
            } else {
                node.next = new Node(0, null);
                node = node.next;
            }
        }
        if (node != null) {
            node.next = head;
        } else {
            result = head;
        }

        return result;
    }

    private static int length(Node node1) {
        int length = 0;
        while (node1 != null) {
            length++;
            node1 = node1.next;
        }
        return length;
    }

    private static int addStep(Node node1, Node node2, Node current) {
        if (node1 == null && node2 == null) {
            current.next = null;
            return 0;
        }

        if (node1 == null || node2 == null) {
            current.next = node1 == null ? node2 : node1;
            return 0;
        }

        if (node1.next == null && node2.next == null) {
            int resultValue = node1.value + node2.value;
            current.next = new Node(resultValue % 10, null);
            return resultValue / 10;
        }


        Node currentNode = new Node(0, null);
        int over = addStep(node1.next == null ? node1 : node1.next, node2.next == null ? node2 : node2.next, currentNode);

        int currentValue = node1.value + node2.value + over;
        currentNode.value = currentValue % 10;

        current.next = currentNode;

        return currentValue / 10;
    }

    private static Node add(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        if (node1 == null || node2 == null) {
            return node1 == null ? node2 : node1;
        }

        Node result = null;
        int over = 0;
        Node p = null;
        Node p1 = node1;
        Node p2 = node2;

        while (p1 != null && p2 != null) {
            int resultValue = p1.value + p2.value + over;
            over = resultValue / 10;
            if (result == null) {
                result = new Node(resultValue % 10, null);
                p = result;
            } else {
                p.next = new Node(resultValue % 10, null);
                p = p.next;
            }

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int resultValue = p1.value + over;
            over = resultValue / 10;
            p.next = new Node(resultValue % 10, null);
            p = p.next;
            p1 = p1.next;
        }

        while (p2 != null) {
            int resultValue = p2.value + over;
            over = resultValue / 10;
            p.next = new Node(resultValue % 10, null);
            p = p.next;
            p2 = p2.next;
        }

        return result;
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
