package com.code.leetcode.周赛.第277场周赛;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_5989元素计数 {
    public static void main(String[] args) {
        int[] nums = new int[]{11,7,2,15};
        System.out.println(countElements(nums));//2

        nums = new int[]{-3,3,3,90};
        System.out.println(countElements(nums));//2
    }

    public static int countElements(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        if (length < 2) return 0;
        if (nums[0] == nums[length - 1]) return 0;
        int subLen = 2;
        for (int i = 1; i < length; i++) {
            if (nums[0] == nums[i]) subLen++;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (nums[length - 1] == nums[i]) subLen++;
        }
        return length - subLen;
    }

}
