package com.interview.crack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem_9_10 {


    private static List<Box> createStackR(List<Box> boxes, Box bottom) {
        int maxHeight = 0;
        List<Box> maxStack = null;
        for (int i = 0, length = boxes.size(); i < length; i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                List<Box> newStack = createStackR(boxes.subList(1, length), bottom);
                int newHeight = stacksHeight(newStack);
                if (newHeight > maxHeight) {
                    maxHeight = newHeight;
                    maxStack = newStack;
                }
            }
        }

        if (maxStack == null) {
            maxStack = new ArrayList<>();
        }
        if (bottom != null) {
            maxStack.add(0, bottom);
        }

        return maxStack;
    }

    private static List<Box> createStackDP(List<Box> boxes, Box bottom, HashMap<Box, List<Box>> stackMap) {
        if (bottom != null && stackMap.containsKey(bottom)) {
            return stackMap.get(bottom);
        }

        int maxHeight = 0;
        List<Box> maxStack = null;
        for (int i = 0, length = boxes.size(); i < length; i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                List<Box> newStack = createStackDP(boxes.subList(1, length), bottom, stackMap);
                int newHeight = stacksHeight(newStack);
                if (newHeight > maxHeight) {
                    maxHeight = newHeight;
                    maxStack = newStack;
                }
            }
        }

        if (maxStack == null) {
            maxStack = new ArrayList<>();
        }
        if (bottom != null) {
            maxStack.add(0, bottom);
        }

        stackMap.put(bottom, maxStack);
        return maxStack;
    }

    private static int stacksHeight(List<Box> stack) {
        int height = 0;
        if (stack == null || stack.size() < 1) {
            return height;
        }

        for (Box box : stack) {
            height += box.d;
        }

        return height;
    }


    private static class Box {
        private int w;
        private int h;
        private int d;

        boolean canBeAbove(Box other) {
            return other != null && this.w < other.w && this.h < other.h && this.d < other.d;
        }
    }
}
