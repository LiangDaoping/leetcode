package com.code.leetcode;

import java.util.Arrays;

/**
 * @description: 数组中的第K个最大元素
 * @author: gz
 * @date: 2021/09/22
 */
public class LeetCode215数组中的第K个最大元素 {
//    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//    示例 1:
//    输入: [3,2,1,5,6,4] 和 k = 2
//    输出: 5
//    示例 2:
//    输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//    输出: 4
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums, 2));
        nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums, 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public void buildMaxHeap(int[] a, int heapSize) {

    }
    public void maxHeapify(int[] a, int i, int heapSize) {

    }
    public void swap(int[] a, int i, int j) {

    }
}
