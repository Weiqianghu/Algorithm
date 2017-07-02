package com.interview;

import java.util.List;

/**
 * Created by weiqianghu on 17-7-2.
 */
public class Problem_06 {

    public static void main(String[] args) {
        /*int[] preOrder = {};
        int[] inOrder = {};
        printTree(reConstructor(preOrder, inOrder));*/

       /* int[] preOrder = {1};
        int[] inOrder = {4};
        printTree(reConstructor(preOrder, inOrder));*/

        /*int[] preOrder = {1, 2, 4};
        int[] inOrder = {4, 2, 1};
        printTree(reConstructor(preOrder, inOrder));*/
/*
        int[] preOrder = {1, 2, 4, 7};
        int[] inOrder = {4, 7, 2, 1};
        printTree(reConstructor(preOrder, inOrder));*/

        int[] preOrder = {4, 7};
        int[] inOrder = {4, 7};
        printTree(reConstructor(preOrder, inOrder));

        /*int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        printTree(reConstructor(preOrder, inOrder));*/
    }

    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root);
            printTree(root.left);
            printTree(root.right);
        }
    }

    private static Node reConstructor(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || preOrder.length < 1) {
            return null;
        }

        int rootIndex = -1;
        for (int i = 0, length = inOrder.length; i < length; i++) {
            if (inOrder[i] == preOrder[0]) {
                rootIndex = i;
            }
        }
        if (rootIndex == -1) {
            return null;
        }

        return new Node(preOrder[0], reConstructor(sliceArray(preOrder, 1, rootIndex + 1), sliceArray(inOrder, 0, rootIndex)),
                reConstructor(sliceArray(preOrder, rootIndex + 1, preOrder.length), sliceArray(inOrder, rootIndex + 1, inOrder.length)));
    }


    private static int[] sliceArray(int[] array, int start, int end) {
        if (array == null || start < 0 || start >= array.length || end < start || end > array.length) {
            return null;
        }

        int[] result = new int[end - start];

        for (int i = start, j = 0; i < end; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }

    private static class Node {
        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        private int value;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "{" + value + "}";
        }
    }
}

