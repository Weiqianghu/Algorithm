package com.interview.crack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_5_7 {
    public static void main(String[] args) {
        System.out.println(findMissing(Arrays.asList(new BitInteger(1), new BitInteger(3), new BitInteger(4))));
        System.out.println(findMissing(Arrays.asList(new BitInteger(1), new BitInteger(2), new BitInteger(4))));
        System.out.println(findMissing(Arrays.asList(new BitInteger(2), new BitInteger(3), new BitInteger(4))));

    }


    private static int findMissing(List<BitInteger> array) {
        return findMissing(array, 0);
    }

    private static int findMissing(List<BitInteger> array, int column) {
        if (column > BitInteger.INTEGER_SIZE) {
            return 0;
        }

        List<BitInteger> oneBits = new ArrayList<>(array.size() / 2);
        List<BitInteger> zeroBits = new ArrayList<>(array.size() / 2);

        for (BitInteger t : array) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }

        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return (v << 1) | 0;
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }

    private static class BitInteger {
        public BitInteger(int value) {
            this.value = value;
        }

        public static final int INTEGER_SIZE = 32;

        private int value;

        private int fetch(int column) {
            return (1 << column) & value;
        }
    }
}
