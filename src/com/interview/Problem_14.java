package com.interview;

/**
 * Created by weiqianghu on 17-7-8.
 */
public class Problem_14 {

    public static void main(String[] args) {
//        int[] intArr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        int[] intArr = {1,1};
//        int[] intArr = {2};
//        int[] intArr = null;
        int[] intArr = {2,4,6,8,10};

        handleArr(intArr);
        for(int value:intArr){
            System.out.print(value+",");
        }
    }

    private static void handleArr(int[] intArr) {
        if (intArr == null || intArr.length < 1) {
            return;
        }
        int front = 0, behind = intArr.length - 1;
        while (front < behind) {
            while (intArr[front] % 2 != 0 && front < behind) {
                front++;
            }

            while (intArr[behind] % 2 == 0 && front < behind) {
                behind--;
            }

            if (front < behind && intArr[front] % 2 == 0 && intArr[behind] % 2 != 0) {
                int temp = intArr[front];
                intArr[front] = intArr[behind];
                intArr[behind] = temp;
            }
        }
    }
}
