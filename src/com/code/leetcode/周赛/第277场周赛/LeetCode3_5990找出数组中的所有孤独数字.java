package com.code.leetcode.周赛.第277场周赛;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode3_5990找出数组中的所有孤独数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,6,5,8};
        System.out.println(findLonely(nums));//10,8

        nums = new int[]{1,3,5,3};
        System.out.println(findLonely(nums));//1,5
    }

    public static List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 && nums[i] != nums[i + 1] && nums[i] + 1 != nums[i + 1]) {
                ans.add(nums[i]);
            }
            if (i == nums.length -1 &&  nums[i] != nums[i-1] && nums[i] - 1 != nums[i-1]) {
                ans.add(nums[i]);
            }
            if (i == 0 || i == nums.length - 1) {
                continue;
            }
            if (nums[i] != nums[i+1] && nums[i] != nums[i-1]
                    && nums[i] + 1 != nums[i+1] && nums[i] - 1 != nums[i-1]) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }

}
