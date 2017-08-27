package com.interview.sword;

public class Problem_62 {

    private static String serialize;

    public static void main(String[] args) {
        Node root = new Node(1,
                new Node(2,
                        new Node(4, null, null),
                        new Node(5, null, null)),
                /*new Node(3,
                        new Node(6, null, null),
                        new Node(7, null, null))*/null);
        printTree(root);
        System.out.println();

        serialize = serialize(root);
        System.out.println(serialize);

        printTree(deSerialize(serialize));
    }

    private static String serialize(Node root) {
        if (root == null) {
            return "$";
        }

        String result = root.value + ",";
        result += serialize(root.left) + ",";
        result += serialize(root.right);
        return result;
    }

    private static Node deSerialize(String[] serialize) {
        if (serialize == null || serialize.length < 1) {
            return null;
        }

        if (serialize[0].equals("$")) {
            return null;
        }

        int middle = (serialize.length - 1) / 2;

        return new Node(Integer.valueOf(serialize[0]),
                deSerialize(sliceArray(serialize, 1, middle + 1)),
                deSerialize(sliceArray(serialize, middle + 1, serialize.length)));
    }

    private static Node deSerialize(String serialize) {
        if (serialize == null) {
            return null;
        }

        String[] split = serialize.split(",");
        if (split.length < 3) {
            return null;
        }
        return deSerialize(split);
    }

    private static String[] sliceArray(String[] array, int start, int end) {
        if (array == null || start < 0 || start >= array.length || end < start || end > array.length) {
            return null;
        }

        String[] result = new String[end - start];

        for (int i = start, j = 0; i < end; i++, j++) {
            result[j] = array[i];
        }
        return result;
    }


    private static void printTree(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root);
        printTree(root.left);
        printTree(root.right);
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
