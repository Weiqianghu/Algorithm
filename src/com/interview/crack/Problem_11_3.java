package com.interview.crack;


public class Problem_11_3 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 2, 5, 7, 8, 9};
        System.out.print(search(arr, 0, 7, 10) + " ");
        System.out.print(search(arr, 0, 7, 9) + " ");
        System.out.print(search(arr, 0, 7, 5) + " ");
        System.out.print(search(arr, 0, 7, 2) + " ");
        System.out.print(search(arr, 0, 7, 40) + " ");
        System.out.print(search(arr, 0, 7, 12) + " ");
        System.out.print(search(arr, 0, 7, 1) + " ");
        System.out.print(search(arr, 0, 7, 3) + " ");

    }

    private static int search(int[] arr, int left, int right, int target) {
        if (arr == null || left > right || left < 0 || right >= arr.length) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (arr[middle] == target) {
            return middle;
        }

        if (arr[middle] >= arr[left] && arr[middle] <= arr[right] && target < arr[middle]) {
            return search(arr, left, middle - 1, target);
        } else if (arr[middle] >= arr[left] && arr[middle] <= arr[right] && target > arr[middle]) {
            return search(arr, middle + 1, right, target);
        }

        if (arr[middle] >= arr[left] && arr[middle] >= arr[right] && target > arr[middle]) {
            return search(arr, middle + 1, right, target);
        } else if (arr[middle] >= arr[left] && arr[middle] >= arr[right] && target >= arr[left]) {
            return search(arr, left, middle - 1, target);
        } else if (arr[middle] >= arr[left] && arr[middle] >= arr[right] && target <= arr[right]) {
            return search(arr, middle + 1, right, target);
        }

        if (arr[middle] <= arr[left] && arr[middle] <= arr[right] && target < arr[middle]) {
            return search(arr, left, middle - 1, target);
        } else if (arr[middle] <= arr[left] && arr[middle] <= arr[right] && target <= arr[right]) {
            return search(arr, middle + 1, right, target);
        } else if (arr[middle] <= arr[left] && arr[middle] <= arr[right] && target >= arr[left]) {
            return search(arr, left, middle - 1, target);
        }

        return -1;
    }
}
