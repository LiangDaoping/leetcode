package com.code.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("字符串：" + s +"，无重复字符的最长子串:" + lengthOfLongestSubstring(s));
        s = "";
        System.out.println("字符串：" + s +"，无重复字符的最长子串:" + lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println("字符串：" + s +"，无重复字符的最长子串:" + lengthOfLongestSubstring(s));
        s = "pwwkewxxxxxxxxabcdefg";
        System.out.println("字符串：" + s +"，无重复字符的最长子串:" + lengthOfLongestSubstring(s));
    }

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        Set set = new HashSet();
//        int maxSize = 0, i = 0, j = 0;
//        while (i < n && j < n) {
//            if (set.contains(s.charAt(j))) {
//                //存在重复的值，则left+1
//                set.remove(s.charAt(i++));
//            } else {
//                set.add(s.charAt(j++));//注意j++和j+1不是同一个意思
//                maxSize = Math.max(maxSize, j - i);//更新窗口最大值
//            }
//        }
//        return maxSize;
//    }

//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length(), ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (int j = 0, i = 0; j < n; j++) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);//i直接跳到最新重复元素的位置
//            }
//            ans = Math.max(ans, j - i + 1);//更新窗口最大值
//            map.put(s.charAt(j), j + 1);//更新map中记录的重复元素的索引位置
//        }
//        return ans;
//    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt) && map.get(charAt) + 1 > left) {
                left = map.get(charAt) + 1;
            }
            map.put(charAt, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }


}
