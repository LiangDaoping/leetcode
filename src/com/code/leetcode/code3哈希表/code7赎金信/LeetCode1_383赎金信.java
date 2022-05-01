package com.code.leetcode.code3哈希表.code7赎金信;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_383赎金信 {
    public static void main(String[] args) {
        String ransomNote = "a", magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));//false

        ransomNote = "aa"; magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));//false

        ransomNote = "aa"; magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));//true
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) != 0) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
