package com.code.leetcode.LeetCode热题HOT100;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode3_3无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s)); // 3

        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s)); // 1

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s)); // 3

        s = "abba";
        System.out.println(lengthOfLongestSubstring(s)); // 2
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        int begin = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            // 只有发现重复，同时begin位置后移，才重新赋值
            if (map.containsKey(charAt) && map.get(charAt) + 1 > begin) {
                begin = map.get(charAt) + 1;
            }
            map.put(charAt, i);
            max = Math.max(max, i - begin + 1);
        }
        return max;
    }
}
