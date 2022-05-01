package com.code.leetcode.code1数组.二分查找;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode1_704二分查找 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(search2(nums, target));

//        nums = new int[]{-1, 0, 3, 5, 9, 12};
        target = 2;
        System.out.println(search2(nums, target));
    }

    public static int search1(int[] nums, int target) {
        // 左闭右开
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int search2(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        // 左闭右闭
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
