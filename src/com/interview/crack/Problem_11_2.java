package com.interview.crack;

import java.util.*;

public class Problem_11_2 {
    public static void main(String[] args) {
        String[] strings = {"hello", "heoll", "apple", "helol", "ppale", "good"};
        sort(strings);
        for (String string : strings) {
            System.out.print(string + " ");
        }
    }

    private static void sort(String[] strings) {
        if (strings == null || strings.length < 1) {
            return;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            String key = getTheKey(str);
            List<String> value = map.get(key);

            List<String> newValue = new ArrayList<>();
            newValue.add(str);
            if (value != null) {
                newValue.addAll(value);
            }
            map.put(key, newValue);
        }

        int arrayIndex = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            for (String string : value) {
                strings[arrayIndex++] = string;
            }
        }
    }

    private static String getTheKey(String str) {
        if (str == null || str.length() < 1) {
            return str;
        }

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}
