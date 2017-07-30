package com.interview.crack;

public class Problem_2_7 {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(2, null))));
        System.out.println(isPalindrome(head));
    }

    private static boolean isPalindrome(Node head) {
        Node copyHead = copyNode(head);

        Node reverse = reverseNode(copyHead);
        Node node = head;

        while (node != null && reverse != null) {
            if (node.value != reverse.value) {
                return false;
            }
            reverse = reverse.next;
            node = node.next;
        }

        return node == null && reverse == null;
    }

    private static Node copyNode(Node head) {
        Node node = head;
        Node result = null;
        Node p = null;
        while (node != null) {
            if (result == null) {
                result = new Node(node.value, null);
                p = result;
            } else {
                p.next = new Node(node.value, null);
                p = p.next;
            }
            node = node.next;
        }

        return result;
    }

    private static Node reverseNode(Node head) {
        Node node = head;
        Node pre = null;

        while (node != null) {
            Node next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }

        return pre;
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
