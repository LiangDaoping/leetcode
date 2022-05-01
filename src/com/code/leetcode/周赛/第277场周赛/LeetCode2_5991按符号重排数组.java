package com.code.leetcode.周赛.第277场周赛;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode2_5991按符号重排数组 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));//[3,-2,1,-5,2,-4]

        nums = new int[]{-1,1};
        System.out.println(Arrays.toString(rearrangeArray(nums)));//[1,-1]

        nums = new int[]{28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31};
        System.out.println(Arrays.toString(rearrangeArray(nums)));//[28,-41,22,-8,46,-37,35,-9,18,-6,19,-26,15,-37,14,-10,31,-9]
    }

    public static int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] positive = new int[length/2];
        int[] negative = new int[length/2];
        int i = 0;
        int j = 0;
        for (int num : nums) {
            if (num > 0) {
                positive[i] = num;
                i++;
            } else {
                negative[j] = num;
                j++;
            }
        }
        for (int k = 0; k < length; k++) {
            nums[k] = k % 2 == 0 ? positive[k / 2] : negative[k/2];
        }
        return nums;
    }




}
