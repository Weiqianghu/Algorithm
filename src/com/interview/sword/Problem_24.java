package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-16.
 */
public class Problem_24 {
    public static void main(String[] args) {
//        int[] intArray = {5, 7, 6, 9, 11, 10, 8};
//        int[] intArray = {7,5};
        int[] intArray = {9, 11, 10, 8};
//        int[] intArray = {5, 7, 6, 9, 11};
//        int[] intArray = {7, 4, 6, 5};

        System.out.println(isOrderTree(intArray));
    }

    private static boolean isOrderTree(int[] intArray) {
        if (intArray == null || intArray.length < 1) {
            return false;
        }

        int length = intArray.length;

        if (length == 1) {
            return true;
        }

        int root = intArray[length - 1];
        int rightStartIndex = -1;
        for (int i = 0; i < length - 1; i++) {
            if (intArray[i] > root) {
                rightStartIndex = i;
                break;
            }
        }

        if (rightStartIndex == -1) {
            return isOrderTree(sliceArray(intArray, 0, length - 1));
        }

        for (int i = rightStartIndex; i < length - 1; i++) {
            if (intArray[i] < root) {
                return false;
            }
        }


        return isOrderTree(sliceArray(intArray, 0, rightStartIndex)) && isOrderTree(sliceArray(intArray, rightStartIndex, length - 1));
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

}
