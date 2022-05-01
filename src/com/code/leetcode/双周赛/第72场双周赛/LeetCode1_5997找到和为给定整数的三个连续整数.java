package com.code.leetcode.双周赛.第72场双周赛;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode1_5997找到和为给定整数的三个连续整数 {
    public static void main(String[] args) {
        int nums = 33;
        System.out.println(Arrays.toString(sumOfThree(nums))); // [10,11,12]

        nums = 4;
        System.out.println(Arrays.toString(sumOfThree(nums))); // []
    }

    public static long[] sumOfThree(long num) {
        if (num % 3 == 0) {
            long[] ans = new long[3];
            ans[0] = num / 3 - 1;
            ans[1] = num / 3;
            ans[2] = num / 3 + 1;
            return ans;
        } else {
            return new long[0];
        }

    }

}
