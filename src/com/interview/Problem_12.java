package com.interview;

/**
 * Created by weiqianghu on 17-7-5.
 */
public class Problem_12 {
    public static void main(String[] args) {
        printNumber(2);
        printNumber(4);
    }

    private static void printNumber(int number) {
        if (number < 0) {
            return;
        }
        int[] numberArr = new int[number];
        for (int i = 0; i < number; i++) {
            numberArr[i] = 0;
        }

        for (int i = 0; i < 10; i++) {
            numberArr[0] = i;
            printToMax(numberArr, number, 0);
        }

    }

    private static void printToMax(int[] numberArr, int length, int index) {
        if (index == length - 1) {
            print(numberArr);
            return;
        }

        for (int i = 0; i < 10; i++) {
            numberArr[index + 1] = i;
            printToMax(numberArr, length, index + 1);
        }
    }


    private static void print(int[] numberArr) {
        if (numberArr == null) {
            return;
        }

        int startIndex = 0;

        for (int aNumberArr : numberArr) {
            if (aNumberArr != 0) {
                break;
            }
            startIndex++;
        }

        if (startIndex == numberArr.length) {
            System.out.println("0");
            return;
        }

        for (int i = startIndex; i < numberArr.length; i++) {
            System.out.print(numberArr[i]);
        }
        System.out.println();
    }
}
