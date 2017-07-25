package com.interview.sword;

/**
 * Created by weiqianghu on 17-7-25.
 */
public class Problem_32 {
    public static void main(String[] args) {
        System.out.println(numberOf1(123) + " " + numbersOf1sFrom1ToN(123));
        System.out.println(numberOf1(12) + " " + numbersOf1sFrom1ToN(12));
        System.out.println(numberOf1(9) + " " + numbersOf1sFrom1ToN(9));
    }

    private static int numbersOf1sFrom1ToN(int number) {
        int currentNum = number;
        int sum = 0;
        int quotient;
        int remainder;
        int mult = 1;

        while (currentNum > 0) {
            quotient = currentNum / 10;
            remainder = currentNum % 10;

            sum += quotient * mult;
            if (remainder > 1) {
                sum += mult;
            } else if (remainder == 1) {
                sum += number - currentNum * mult + 1;
            }
            currentNum = currentNum / 10;
            mult = mult * 10;
        }
        return sum;
    }

    private static int numberOf1(int number) {
        int sum = 0;

        for (int i = 1; i < number + 1; i++) {
            sum += num(i);
        }

        return sum;
    }

    private static int num(int number) {
        int sum = 0;

        while (number > 0) {
            if (number % 10 == 1) {
                sum++;
            }
            number = number / 10;
        }

        return sum;
    }
}
