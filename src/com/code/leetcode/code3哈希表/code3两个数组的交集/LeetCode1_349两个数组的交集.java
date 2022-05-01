package com.code.leetcode.code3哈希表.code3两个数组的交集;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_349两个数组的交集 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));//[2]

        nums1 = new int[]{4,9,5}; nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));//[9,4]
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> ans = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) ans.add(i);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
