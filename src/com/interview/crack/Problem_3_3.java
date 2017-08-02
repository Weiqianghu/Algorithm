package com.interview.crack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_3_3 {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();

        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        System.out.println(setOfStacks);

        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println(setOfStacks);

        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        System.out.println(setOfStacks);

        setOfStacks.pop();
        setOfStacks.push(9);
        setOfStacks.push(10);
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println(setOfStacks);

        setOfStacks.pop();
        setOfStacks.pop();
        setOfStacks.pop();
        System.out.println(setOfStacks);

        setOfStacks.push(11);
        setOfStacks.push(12);
        setOfStacks.push(13);
        setOfStacks.push(14);
        System.out.println(setOfStacks);

        setOfStacks.push(15);
        setOfStacks.push(16);
        setOfStacks.push(17);
        setOfStacks.push(18);
        System.out.println(setOfStacks);

    }


    private static class SetOfStacks {
        private static final int SIZE = 3;
        private List<Stack<Integer>> stacks = new ArrayList<>();
        private int currentIndex = 0;

        public SetOfStacks() {
            stacks.add(new Stack<>());
        }

        public int push(int value) {
            expand();
            return currentStack().push(value);
        }

        public int pop() {
            if (currentStack().size() <= 0) {
                currentIndex--;
            }
            if (currentIndex < 0) {
                throw new IllegalStateException();
            }
            return currentStack().pop();
        }


        private void expand() {
            if (lastStack().size() >= SIZE) {
                stacks.add(new Stack<>());
                currentIndex++;
            } else if (currentStack().size() >= SIZE) {
                currentIndex++;
            }
        }


        private Stack<Integer> currentStack() {
            return stacks.get(currentIndex);
        }

        private Stack<Integer> lastStack() {
            return stacks.get(stacks.size() - 1);
        }

        @Override
        public String toString() {
            return stacks.toString();
        }
    }
}
