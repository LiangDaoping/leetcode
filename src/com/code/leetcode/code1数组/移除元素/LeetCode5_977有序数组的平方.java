package com.code.leetcode.code1数组.移除元素;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode5_977有序数组的平方 {
    public static void main(String[] args) {
        // 解释：非递减->允许重复的递增

        // sortedSquares1：对绝对值的数字进行冒泡排序，然后循环平方
        // sortedSquares2：双指针法，low=0 fast=length 比较大小逆序放入结果res中

        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares2(nums))); // 0,1,9,16,100


        nums = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares2(nums))); // 4,9,9,49,121

        nums = new int[]{-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(sortedSquares2(nums))); // 4,9,9,49,121


    }

    public static int[] sortedSquares1(int[] nums) {
        bubbleSort1(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    public static void bubbleSort1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {

                if (abs(nums[j]) > abs(nums[j + 1])) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

    }

    public static int abs(int x) {
        return x > 0 ? x : -x;
    }

    public static int[] sortedSquares2(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;


        int[] res = new int[n];

        while (low <= high) {
            int i = nums[low] * nums[low];
            int j = nums[high] * nums[high];
            // 此处不能同时放入两个节点，存在情况：-9 -8 -7   xxxxxx  1 2 3，同时放入两个会xxxxxxxx 3*3 9*9
            if (i >= j) {
                res[--n] = i;
                low++;
            } else {
                res[--n] = j;
                high--;
            }
        }

        return res;
    }



}
