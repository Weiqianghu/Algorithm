package com.interview;

/**
 * Created by weiqianghu on 17-7-16.
 */
public class Problem_26 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Node e = new Node('E', null, null);
        Node d = new Node('D', e, null);
        Node c = new Node('C', d, null);
        Node b = new Node('B', c, e);
        Node a = new Node('A', b, c);
        printNode(a);

        printNode(copyNode(a));
        printNode((Node) a.clone());
    }

    private static Node copyNode(Node head) {
        if (head == null) {
            return null;
        }

        Node node = head;
        Node copyNode = null;

        while (node != null) {
            copyNode = new Node(node.value, null, null);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode.next;
        }

        node = head;
        while (node != null) {
            copyNode = node.next;
            copyNode.sibling = node.sibling;
            node = copyNode.next;
        }

        node = head;
        Node copyHead = node.next;
        copyNode = node.next;

        while (copyNode.next != null) {
            node.next = copyNode.next;
            copyNode.next = node.next.next;
            node = node.next;
            copyNode = node.next;
        }

        return copyHead;
    }

    private static void printNode(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.println();
    }

    private static class Node implements Cloneable {
        int value;
        Node next;
        Node sibling;

        public Node(int value, Node next, Node sibling) {
            this.value = value;
            this.next = next;
            this.sibling = sibling;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + (next == null ? "null" : next.value) +
                    ", sibling=" + (sibling == null ? "null" : sibling.value) +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            Node node;
            node = (Node) super.clone();
            node.next = next == null ? null : (Node) next.clone();
            node.sibling = sibling == null ? null : (Node) sibling.clone();
            return node;
        }
    }
}
