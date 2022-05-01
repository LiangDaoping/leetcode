package com.code.leetcode.code3哈希表.code3两个数组的交集;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode2_350两个数组的交集II {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1}, nums2 = new int[]{2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));//[2,2]

        nums1 = new int[]{4,9,5}; nums2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));//[4,9]
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i : nums1) {
            Integer orDefault = set.getOrDefault(i, 0);
            set.put(i, orDefault + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int i : nums2) {
            Integer orDefault = set.getOrDefault(i, 0);
            if (orDefault > 0) {
                ans.add(i);
            }
            set.put(i, orDefault - 1);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();
    }
}
