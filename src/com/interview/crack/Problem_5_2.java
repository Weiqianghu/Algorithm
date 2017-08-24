package com.interview.crack;

public class Problem_5_2 {
    public static void main(String[] args) {
        System.out.println(_2to10(0.5) + " " + _2to10_2(0.5));
        System.out.println(_2to10(0.92) + " " + _2to10_2(0.92));
        System.out.println(_2to10(0.22) + " " + _2to10_2(0.22));
        System.out.println(_2to10(0.62) + " " + _2to10_2(0.62));

    }

    private static String _2to10(double _10d) {
        StringBuilder result = new StringBuilder("0.");

        double num = _10d;
        while (num > 0) {
            double r = num * 2;
            if (r >= 1) {
                result.append(1);
                num = r - 1;
            } else {
                result.append(0);
                num = r;
            }
        }

        return result.toString();
    }

    private static String _2to10_2(double _10d) {
        StringBuilder result = new StringBuilder("0.");

        double num = _10d;
        double frac = 0.5;
        while (num > 0) {
            if (num >= frac) {
                result.append(1);
                num = num - frac;
            } else {
                result.append(0);
            }
            frac = frac / 2;
        }

        return result.toString();
    }
}
