package com.code.leetcode.日志易;

import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/22
 */
public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "abaa";
        System.out.println(dosth(s));

        s = "abba";
        System.out.println(dosth(s));

        s = "aaabbaabbbaaa";
        System.out.println(dosth(s));

    }

    public static String dosth(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                checkString(s, i, j + 1);
            }
        }
        return "";
    }

    public static String checkString(String s, int begin, int end) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(begin));
        int resBegin = begin;
        int resEnd = end;
        int max = 0;
        String ans = "";
        for (int i = begin + 1; i < end; i++) {
            if (s.charAt(i) == stack.peek()) {
                resBegin--;
                resEnd++;
                stack.pop();
            } else {
                ans = resEnd - resBegin > max ? s.substring(begin, end) : ans;
                stack.add(s.charAt(i));
            }
        }
        return ans;
    }

}
