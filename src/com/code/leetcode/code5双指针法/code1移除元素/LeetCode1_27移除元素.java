package com.code.leetcode.code5双指针法.code1移除元素;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_27移除元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));//2

        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        System.out.println(removeElement(nums, val)); //5
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int slow = 0;
        for (int fast = 0; fast < length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

}
