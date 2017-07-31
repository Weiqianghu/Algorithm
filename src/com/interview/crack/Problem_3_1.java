package com.interview.crack;

public class Problem_3_1 {

    public static void main(String[] args) {
        AStack aStack = new AStack();

        aStack.push1(0);
        aStack.push1(2);
        aStack.push1(6);
        aStack.push1(4);
        System.out.println(aStack);

        aStack.pop1Index();
        aStack.pop1Index();

        System.out.println(aStack);

        aStack.push2(3);
        aStack.push2(6);
        aStack.push2(9);
        System.out.println(aStack);

    }


    private static class AStack {
        private static final int SIZE = 16;
        int[] data = new int[SIZE];

        int push1Index = 0;
        int push2Index = SIZE - 1;

        public int push1(int value) {
            if (push1Index == push2Index) {
                throw new IllegalStateException();
            }

            data[push1Index++] = value;
            return value;
        }

        public int push2(int value) {
            if (push1Index == push2Index) {
                throw new IllegalStateException();
            }

            data[push2Index--] = value;
            return value;
        }

        public int pop1Index() {
            if (push1Index < 0) {
                throw new IllegalStateException();
            }
            return data[push1Index--];
        }

        public int pop2Index() {
            if (push2Index > SIZE - 1) {
                throw new IllegalStateException();
            }
            return data[push2Index++];
        }

        @Override
        public String toString() {
            System.out.println("stack1:");
            for (int i = 0; i < push1Index; i++) {
                System.out.print(data[i] + ",");
            }
            System.out.println();

            System.out.println("stack2:");
            for (int i = SIZE - 1; i > push2Index; i--) {
                System.out.print(data[i] + ",");
            }
            return "";
        }
    }
}
