package com.code.leetcode.code1数组.二分查找;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode3_34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        // 左边界：右侧逼近
        // 右边界：左侧逼近

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange3(nums, target)));// [3, 4]

        target = 6;
        System.out.println(Arrays.toString(searchRange3(nums, target)));// [-1, -1]


        nums = new int[]{};
        target = 0;
        System.out.println(Arrays.toString(searchRange3(nums, target)));// [-1, -1]

        nums = new int[]{1};
        target = 1;
        System.out.println(Arrays.toString(searchRange3(nums, target)));// [0, 0]
    }

    public static int[] searchRange1(int[] nums, int target) {
        int count = 0;
        int high = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                high = i;
                count++;
            }
        }
        return count == 0 ? new int[] {high, high} : new int[]{high - count + 1, high};
    }

    public static int[] searchRange2(int[] nums, int target) {
        int leftSearch2 = getLeftSearch2(nums, target);
        int rightSearch2 = getRightSearch2(nums, target);
        if (leftSearch2 == -2 || rightSearch2 == -2) return new int[]{-1, -1};
        if (leftSearch2 > rightSearch2) return new int[]{-1, -1};
        return new int[]{leftSearch2, rightSearch2};
    }

    public static int getLeftSearch2(int[] nums, int target) {
        // 左闭右闭
        int low = 0;
        int high = nums.length - 1;
        int leftBorder = -2;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                high = mid - 1;
                leftBorder = mid;
            } else {
                low = mid + 1;
            }
        }
        return leftBorder;
    }

    public static int getRightSearch2(int[] nums, int target) {
        // 左闭右闭
        int low = 0;
        int high = nums.length - 1;
        int rightBorder = -2;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] <= target) {
                low = mid + 1;
                rightBorder = mid;
            } else {
                high = mid - 1;
            }
        }
        return rightBorder;
    }





    public static int[] searchRange3(int[] nums, int target) {
        int leftSearch3 = getLeftSearch3(nums, target);
        int rightSearch3 = getRightSearch3(nums, target);
        if (leftSearch3 == -2 || rightSearch3 == -2 || leftSearch3 > rightSearch3) return new int[]{-1, -1};
        return new int[]{leftSearch3, rightSearch3};
    }

    public static int getLeftSearch3(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int leftBorder = -2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
                leftBorder = mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
                leftBorder = mid;
            }
        }
        return leftBorder;
    }

    public static int getRightSearch3(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int rightBorder = -2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else if (nums[mid] < target) {
                rightBorder = mid;
                low = mid + 1;
            } else {
                low = mid + 1;
                rightBorder = mid;
            }
        }
        return rightBorder;
    }



}
