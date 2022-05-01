package com.code.leetcode.code5双指针法.code10四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_18四数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));//[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        nums = new int[]{2,2,2,2,2};
        target = 8;
        System.out.println(fourSum(nums, target));//[[2,2,2,2]]

        nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        target = 0;
        System.out.println(fourSum(nums, target));//[[2,2,2,2]]

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                int left = j + 1;
                int right = length - 1;
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                while (left < right) {
                    int total = nums[left] + nums[right];
                    int newTarget = target - nums[i] - nums[j];
                    if (total > newTarget) {
                        right--;
                    } else if (total < newTarget) {
                        left++;
                    } else {
                        List<Integer> res = new ArrayList<>();
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[left]);
                        res.add(nums[right]);
                        ans.add(res);
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
