package com.interview.sword;

public class Problem_37 {

    public static void main(String[] args) {
        Node theSameNode = new Node(3, new Node(4, new Node(5, null)));
        Node list1 = new Node(1, new Node(2, theSameNode));
        Node list2 = new Node(6, new Node(9, new Node(8, theSameNode)));

        printNode(list1);
        printNode(list2);
        printNode(findTheSameNode(list1, list2));

        printNode(findTheSameNode(list1, list1));

        printNode(findTheSameNode(list1, new Node(7, null)));


    }

    private static Node findTheSameNode(Node list1, Node list2) {
        if (list1 == null || list2 == null) {
            return null;
        }

        int length1 = getTheLength(list1);
        int length2 = getTheLength(list2);
        int different = Math.abs(length1 - length2);

        Node longer = length1 > length2 ? list1 : list2;
        Node shorter = length1 > length2 ? list2 : list1;

        while (different > 0) {
            longer = longer.next;
            different--;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
    }

    private static int getTheLength(Node list) {
        int length = 0;
        Node node = list;
        while (node != null) {
            node = node.next;
            length++;
        }

        return length;
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
