package com.interview;

/**
 * Created by weiqianghu on 17-7-12.
 */
public class Problem_19 {

    public static void main(String[] args) {
       /* Node root = new Node(8,
                new Node(6,
                        new Node(5, null, null), new Node(7, null, null)),
                new Node(10,
                        new Node(9, null, null), new Node(11, null, null)));*/
//        Node root = new Node(1, null, null);

//        Node root=null;

        Node root = new Node(1, new Node(2,null,null), null);
        printTree(root);
        System.out.println();

        mirror(root);

        printTree(root);
        System.out.println();
    }

    private static void mirror(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        Node tem = root.left;
        root.left = root.right;
        root.right = tem;

        mirror(root.left);
        mirror(root.right);
    }


    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root);
            printTree(root.left);
            printTree(root.right);
        }
    }

    private static class Node {
        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}
