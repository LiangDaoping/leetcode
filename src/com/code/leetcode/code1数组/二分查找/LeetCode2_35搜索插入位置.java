package com.code.leetcode.code1数组.二分查找;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode2_35搜索插入位置 {
    public static void main(String[] args) {

        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert1(nums, target));// 2

        target = 2;
        System.out.println(searchInsert1(nums, target));// 1

        target = 7;
        System.out.println(searchInsert1(nums, target));// 4

        target = 0;
        System.out.println(searchInsert1(nums, target));// 0

        nums = new int[]{1};
        target = 0;
        System.out.println(searchInsert1(nums, target));// 0
    }

    public static int searchInsert1(int[] nums, int target) {
        // 左闭右闭
        int len = nums.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int searchInsert2(int[] nums, int target) {
        // 左闭右开
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }


}
