package com.code.leetcode.code5双指针法.code9三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_15三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));//[[-1,-1,2],[-1,0,1]]

        nums = new int[]{};
        System.out.println(threeSum(nums));//[]

        nums = new int[]{0};
        System.out.println(threeSum(nums));//[]

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total > 0) {
                    right--;
                } else if (total < 0) {
                    left++;
                } else {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    while (right > left && nums[left] == nums[left + 1])
                        left++;
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                }
            }

        }
        return ans;
    }
}
