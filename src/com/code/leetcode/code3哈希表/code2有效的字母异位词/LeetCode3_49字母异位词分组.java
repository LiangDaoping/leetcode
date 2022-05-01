package com.code.leetcode.code3哈希表.code2有效的字母异位词;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode3_49字母异位词分组 {
    public static void main(String[] args) {
        //groupAnagrams1:暴力
        //groupAnagrams2:利用map
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams3(strs));//[["bat"],["nat","tan"],["ate","eat","tea"]]

        strs = new String[]{""};
        System.out.println(groupAnagrams3(strs));//[[""]]

        strs = new String[]{"a"};
        System.out.println(groupAnagrams3(strs));//[["a"]]
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        List<int[]> list = new ArrayList<>();
        for (String str : strs) {
            int[] record = new int[26];
            for (char c : str.toCharArray()) {
                record[c - 'a'] ++;
            }
            list.add(record);
        }
        List<List<String>> res = new ArrayList<>();
        boolean[] flag = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (flag[i]) continue;
            List<String> temp = new ArrayList<>();
            temp.add(strs[i]);
            for (int j = i + 1; j < list.size(); j++) {
                if (compare(list.get(i), list.get(j))) {
                    temp.add(strs[j]);
                    flag[j] = true;
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static boolean compare(int[] a, int[] b) {
        int length = a.length;
        if (length != b.length) return false;
        for (int i = 0; i < length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;

    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] record = new int[26];
            for (char c : str.toCharArray()) {
                record[c - 'a']++;
            }
            List<String> orDefault = map.getOrDefault(Arrays.toString(record), new ArrayList<>());
            orDefault.add(str);
            map.put(Arrays.toString(record), orDefault);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            List<String> orDefault = map.getOrDefault(Arrays.toString(chars), new ArrayList<>());
            orDefault.add(str);
            map.put(Arrays.toString(chars), orDefault);
        }
        return new ArrayList<>(map.values());
    }
}
