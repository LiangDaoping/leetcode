package com.code.leetcode.code1数组.长度最小的子数组;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3_76最小覆盖子串 {
    public static void main(String[] args) {
        // 注意里面有一些注意事项，详情看下面注释
        // minWindow1:题解
        // minWindow2:优化版题解
         String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow2(s, t)); // "BANC"

        s = "a"; t = "a";
        System.out.println(minWindow2(s, t)); // "a"

        s = "a"; t = "aa";
        System.out.println(minWindow2(s, t)); // ""

        s = "ab";
        t = "A";
        System.out.println(minWindow2(s, t)); // ""

        s = "abc";
        t = "cba";
        System.out.println(minWindow2(s, t)); // "abc"

        s = "cwirwjbfntstplnenpabdttnbiagcnrglbyhnbnavhvmtlqgaqkdmdtnltvpipwuquddvseqabctmsbmllsxrlmegjupyqlpmqsjlyalaegozjbkxtjogxsmgodhgqwsjqeureftknhlwixvdgjjfeyoudvburvdjzxafetqtbdplblrjwcpccdxgyyarvfaxcbciwubzysnzfekeizgledredrvzyyyazakxvlxvfkwlqgpyixjmbargtohrmftngfldskyywwlmccmkzwzayshugontwhicovfhffhbdsphucutatwalfutviorrxvhscoyhvbmntujvofxjbxwispdcexvdscvvtveozresnnpbsmmvjifdxlhdicgchexazcqavusikhlevxaffhkessicwqffuchugyudspncwahuxjzeslll";
        t = "ftpejujeztahrwljlao";


        System.out.println(minWindow2(s, t));

    }

    public static String minWindow1(String s, String t) {
        if (t.length() > s.length()) return "";
        if (s.length() == t.length() && s.equals(t)) {
            return t;
        }
        // 这样写就时间超时了
        // 2<<12 = 8192，没问题
        // 2<<13 = 16384，超时
        // 2<<16 = 131072，超时
        // HashMap<Character, Integer> sMap = new HashMap<>(2 << 13);
        // HashMap<Character, Integer> tMap = new HashMap<>(2 << 13);
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            tMap.put(charAt, tMap.getOrDefault(charAt, 0) + 1);
        }

        int sLen = s.length();
        int len = sLen + 1;
        int begin = 0;
        int left = 0;
        for (int right = 0; right < sLen; right++) {
            char charAt = s.charAt(right);
            if (!tMap.containsKey(charAt)) {
                left++;
            } else {
                break;
            }
        }
        for (int right = 0; right < sLen; right++) {
            char charAt = s.charAt(right);
            if (tMap.containsKey(charAt)) {
                sMap.put(charAt, sMap.getOrDefault(charAt, 0) + 1);
            }
            while (sMap.size() >= tMap.size() && left <= right && contain1(sMap, tMap)) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    begin = left;
                }
                char leftCharAt = s.charAt(left);
                if (tMap.containsKey(leftCharAt)) {
                    sMap.put(leftCharAt, sMap.get(leftCharAt) - 1);
                }
                left++;
                if (sMap.getOrDefault(leftCharAt, 0) < tMap.getOrDefault(leftCharAt, 0)) {
                    break;
                }
            }
        }

        if (len == s.length() + 1) {
            len = 0;
        }
        return s.substring(begin, begin + len);
    }

    public static boolean contain1(Map<Character, Integer> sMap, Map<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (sMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }


    public static String minWindow2(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int n = chars.length;
        int m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) {
            hash[ch]--;
        }
        // 结果记录
        String res = "";
        // 记录符合子串的元素数量
        int cnt = 0;
        // 左指针
        int left = 0;
        for (int right = 0; right < n; right++) {
            // 右指针对应的元素数量 + 1
            hash[chars[right]]++;
            // 符合子串的值，因此cnt++。假如不是子串的值hash[chars[right]]最开始的初始值为0，经过上面这行++，变成了1
            if (hash[chars[right]] <= 0) {
                cnt++;
            }
            // 当第一次子串的所有元素都找到后，hash[chars[left]] > 0 去清理那些无用元素，更新最正确的left，此时left在第一次碰到子串元素的位置
            // 当再次发现和第一次子串元素相同时，寻找最佳的left
            while (cnt == m && hash[chars[left]] > 0) {
                hash[chars[left++]]--;
            }
            if (cnt == m) {
                // "".equals(res)用于第一次赋值时res为空，此时覆盖
                if ("".equals(res) || res.length() > right - left + 1) {
                    res = s.substring(left, right + 1);
                }
            }
        }
        return res;
    }



}
