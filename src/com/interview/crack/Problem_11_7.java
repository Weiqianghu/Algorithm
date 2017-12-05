package com.interview.crack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_11_7 {
    public static void main(String[] args) {

    }

    private static List<Person> getIncreasingSequence(List<Person> people) {
        Collections.sort(people);
        return longestIncreasingSubsequence(people);
    }

    private static List<Person> longestIncreasingSubsequence(List<Person> people) {
        ArrayList<Person>[] result = new ArrayList[people.size()];
        longestIncreasingSubsequence(people, result, 0);

        List<Person> bestSequence = null;
        for (int i = 0; i < people.size(); i++) {
            bestSequence = seqWithMaxLength(bestSequence, result[i]);
        }
        return bestSequence;
    }

    private static void longestIncreasingSubsequence(List<Person> people, ArrayList<Person>[] result, int currentIndex) {
        if (currentIndex < 0 || currentIndex >= people.size()) {
            return;
        }

        Person currentPerson = people.get(currentIndex);

        List<Person> bestSequence = null;
        for (int i = 0; i < currentIndex; i++) {
            if (people.get(i).isBefore(currentPerson)) {
                bestSequence = seqWithMaxLength(bestSequence, result[i]);
            }
        }

        ArrayList<Person> newResult = new ArrayList<>();
        if (bestSequence != null) {
            newResult.addAll(bestSequence);
        }
        newResult.add(currentPerson);

        result[currentIndex] = newResult;
        longestIncreasingSubsequence(people, result, currentIndex + 1);
    }

    private static List<Person> seqWithMaxLength(List<Person> seq1, List<Person> seq2) {
        if (seq1 == null) {
            return seq2;
        }
        if (seq2 == null) {
            return seq1;
        }

        return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    private static class Person implements Comparable<Person> {
        private int height;
        private int weight;

        @Override
        public int compareTo(Person o) {
            if (this.height != o.height) {
                return this.height - o.height;
            } else {
                return this.weight - o.weight;
            }
        }

        boolean isBefore(Person other) {
            return this.height < other.height && this.weight < other.weight;
        }
    }
}
