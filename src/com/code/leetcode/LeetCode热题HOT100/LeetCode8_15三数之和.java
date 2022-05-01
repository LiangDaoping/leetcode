package com.code.leetcode.LeetCode热题HOT100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode8_15三数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums)); // [[-1,-1,2],[-1,0,1]]

        nums = new int[]{};
        System.out.println(threeSum(nums)); // []

        nums = new int[]{0};
        System.out.println(threeSum(nums)); // []

        nums = new int[]{0, 0, 0, 0};
        System.out.println(threeSum(nums)); // [[0,0,0]]

        nums = new int[]{-2,0,1,1,2};
        System.out.println(threeSum(nums)); // [[-2,0,2],[-2,1,1]]
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int left = 0; left < nums.length; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }
            while (mid < right) {
                int total = nums[left] + nums[mid] + nums[right];
                if (total == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[left]);
                    temp.add(nums[mid]);
                    temp.add(nums[right]);
                    ans.add(temp);

                    while (mid < right && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    while (mid < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    mid++;
                    right--;

                } else if (total > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        return ans;
    }

}
