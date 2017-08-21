package com.interview.sword;

public class Problem_57 {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        printNode(head);
        printNode(deleteRepeatNodes(head));
        printNode(deleteRepeatNodes(new Node(1, null)));
        printNode(deleteRepeatNodes(new Node(1, new Node(1, null))));
        printNode(deleteRepeatNodes(new Node(1, new Node(2, new Node(2, null)))));

    }

    private static Node deleteRepeatNodes(Node head) {
        if (head == null) {
            return null;
        }

        Node resultHead = head;
        Node pre = null, node = head;
        while (node != null && node.next != null) {
            if (node.value == node.next.value) {
                int repeatValue = node.value;
                if (pre == null) {
                    resultHead = node.next.next;
                } else {
                    pre.next = node.next.next;
                }

                node = resultHead;
                while (node != null && node.value == repeatValue) {
                    if (pre == null) {
                        resultHead = node.next;
                    } else {
                        pre.next = node.next;
                        pre = node;
                    }
                    node = node.next;
                }
            } else {
                pre = node;
                node = node.next;
            }
        }

        return resultHead;
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
