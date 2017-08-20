package com.interview.sword;

public class Problem_55 {
    public static void main(String[] args) {
        printTheChar("google");
        printTheChar("go");
        printTheChar("huweiqiang");
        printTheChar("hanyangyang");

    }

    private static void printTheChar(String google) {
        if (google == null || google.length() < 1) {
            return;
        }

        int[] map = new int[256];
        char[] chars = google.toCharArray();
        for (char ch : chars) {
            map[ch]++;
        }

        for (char ch : chars) {
            if (map[ch] == 1) {
                System.out.println(ch);
                return;
            }
        }
    }
}
