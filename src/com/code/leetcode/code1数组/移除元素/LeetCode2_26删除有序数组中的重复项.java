package com.code.leetcode.code1数组.移除元素;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode2_26删除有序数组中的重复项 {
    public static void main(String[] args) {
        // removeDuplicates1： 双指针法
        // removeDuplicates2： 暴力
        int[] nums = {1,1,2};
        execute(nums); // 2 [1,2]

        nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        execute(nums); // 5 [0,1,2,3,4]

    }

    public static void execute(int[] nums) {
        int len = removeDuplicates2(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int removeDuplicates1(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i+1, nums, i, length - i - 1);
                length--;
                i--;
            }
        }
        return length;
    }






}
