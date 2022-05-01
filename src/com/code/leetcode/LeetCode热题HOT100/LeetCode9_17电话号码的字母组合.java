package com.code.leetcode.LeetCode热题HOT100;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode9_17电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits)); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        digits = "";
        System.out.println(letterCombinations(digits)); // []

        digits = "2";
        System.out.println(letterCombinations(digits)); // ["a","b","c"]
    }

    public static List<String> letterCombinations1(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> ans = new ArrayList<>();
        if ("".equals(digits)) {
            return ans;
        }
        letter(digits, 0, "", ans, phoneMap);
        return ans;
    }

    public static void letter(String digits, int index, String s, List<String> ans, Map<Character, String> phoneMap) {
        if (index >= digits.length()) {
            ans.add(s);
            return;
        }
        String temp = phoneMap.get(digits.charAt(index));
        for (int i = 0; i < temp.length(); i++) {
            letter(digits, index + 1, s + temp.charAt(i), ans, phoneMap);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if ("".equals(digits)) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        Queue<String> queue = new ArrayDeque<>();
        extracted(digits, phoneMap, queue);
        while (queue.peek().length() < digits.length()) {
            extracted(digits, phoneMap, queue);
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    private static void extracted(String digits, Map<Character, String> phoneMap, Queue<String> queue) {
        String s;
        String poll = queue.poll();
        if (poll == null) {
            poll = "";
        }
        s = phoneMap.get(digits.charAt(poll.length()));
        for (int j = 0; j < s.length(); j++) {
            queue.add(poll + s.charAt(j));
        }
    }
}
