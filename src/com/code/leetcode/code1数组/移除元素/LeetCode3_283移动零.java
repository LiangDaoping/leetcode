package com.code.leetcode.code1数组.移除元素;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode3_283移动零 {
    public static void main(String[] args) {
        // moveZeroes1(int[] nums)：快慢指针法，先移动前面，最后补充最后的目标值
        // moveZeroes1(int[] nums, int target)：快慢指针法，moveZeroes1可扩充
        // moveZeroes2(int[] nums)：快慢指针法，边移动边变化


        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));

    }

    public static void moveZeroes1(int[] nums) {
        moveZeroes1(nums, 0);
    }

    public static void moveZeroes1(int[] nums, int target) {
        int length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] != target) {
                nums[slow++] = nums[fast];
            }
        }
        for (int i = slow; i < length; i++) {
            nums[i] = target;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }





}
