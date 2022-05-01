package com.code.leetcode.code3哈希表.code5两数之和;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_1两数之和 {
    public static void main(String[] args) {
        //twoSum1：暴力，两层循环
        //twoSum2:题解，map
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum2(nums, target)));//[0,1]

        nums = new int[]{3,2,4};
        target = 6;
        System.out.println(Arrays.toString(twoSum2(nums, target)));//[1,2]

        nums = new int[]{3,3};
        target = 6;
        System.out.println(Arrays.toString(twoSum2(nums, target)));//[0,1]
    }

    public static int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer value = map.get(target - nums[i]);
            if (value != null) {
                int[] ans = new int[2];
                ans[0] = value;
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return nums;
    }

}
