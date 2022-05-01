package com.code.leetcode.code3哈希表.code6四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_454四数相加II {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{-2,-1};
        int[] nums3 = new int[]{-1,2};
        int[] nums4 = new int[]{0,2};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));//2

        nums1 = new int[]{0};
        nums2 = new int[]{0};
        nums3 = new int[]{0};
        nums4 = new int[]{0};
        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));//1

    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countAB = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                countAB.put(i + j, countAB.getOrDefault(i + j, 0) + 1);
            }
        }
        int ans = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (countAB.containsKey(- i - j)) {
                    ans += countAB.get(- i - j);
                }
            }
        }
        return ans;
    }
}
