package com.code.leetcode.code3哈希表.code2有效的字母异位词;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode1_242有效的字母异位词 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram2(s, t));//true

        s = "rat"; t = "car";
        System.out.println(isAnagram2(s, t));//false
    }

    public static boolean isAnagram1(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        int len = s.length();
        if (len != t.length()) return false;

        int[] record = new int[26];
        for (int i = 0; i < len; i++) {
            record[s.charAt(i) - 'a'] ++;
            record[t.charAt(i) - 'a']--;
        }
        for (int i : record) {
            if (i != 0) return false;
        }
        return true;
    }
}
