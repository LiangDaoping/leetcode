package com.code.leetcode.code3哈希表.code2有效的字母异位词;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode2_383赎金信 {
    public static void main(String[] args) {
        // ransomNote 小于等于magazine的元素
        //canConstruct1:自己
        //canConstruct2:标准解法
        //canConstruct1:看题解，优化2


        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct3(ransomNote, magazine));//false

        ransomNote = "aa"; magazine = "ab";
        System.out.println(canConstruct3(ransomNote, magazine));//false

        ransomNote = "aa"; magazine = "aab";
        System.out.println(canConstruct3(ransomNote, magazine));//true
    }

    public static boolean canConstruct1(String ransomNote, String magazine) {
        int smallLen = ransomNote.length();
        int bigLen = magazine.length();
        if (smallLen > bigLen) return false;

        int[] record = new int[26];
        for (int i = 0; i < smallLen; i++) {
            record[magazine.charAt(i) - 'a'] ++;
            record[ransomNote.charAt(i) - 'a'] --;
        }
        for (int i = smallLen; i < bigLen; i++) {
            record[magazine.charAt(i) - 'a'] ++;
        }
        for (int j : record) {
            if (j < 0) return false;
        }
        return true;
    }

    public static boolean canConstruct2(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] --;
        }
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] ++;
        }
        for (int i : record) {
            if (i < 0) return false;
        }
        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] ++;
        }
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] --;
            if (record[c - 'a'] < 0) return false;
        }
        return true;
    }
}
