package com.code.leetcode.code3哈希表.code9四数之和;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_18四数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        int target = 0;
        System.out.println(fourSum(nums, target));//[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

        nums = new int[]{2,2,2,2,2};
        target = 8;
        System.out.println(fourSum(nums, target));//[[2,2,2,2]]

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

}
