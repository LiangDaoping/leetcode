package com.code.leetcode.国企民航;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/24
 */
public class 大数组寻找最小数字 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,4,5,6,7,1,23,3};
        System.out.println(Arrays.toString(findTenMin(nums)));
    }

    public static int[] findTenMin(int[] nums) {
//        II. 10 亿个数字里里面找最小的 10 个（应尽可能提升执行速度，减少时间复杂度）
//        快排：内存无法容纳10亿数组
//        所以应该用堆排序
        int[] ans = new int[10];
        int[] sortNums = buckSort(nums, 5);
        // 取出最小的10个数字
        for (int i = 0; i < ans.length; i++) {
            ans[i] = sortNums[i];
        }
        return ans;
    }

    public static int[] buckSort(int[] nums, int bucketSize) {
        if (nums == null || nums.length == 0) return nums;
        int maxValue = nums[0];
        int minValue = nums[0];
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(maxValue, num);
        }

        // 向上取桶的个数
        int bucketCount = (int) (Math.floor((maxValue - minValue) / bucketSize) + 1);
        int[][] buckets = new int[bucketCount][0];
        for (int num : nums) {
            // 该数字应该在几号桶
            int index = (int) Math.floor((num - minValue) / bucketSize);
            // 该桶进行扩容+1
            buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
            // 对该桶赋值
            buckets[index][buckets[index].length - 1] = num;
        }

        int index = 0;
        for (int[] bucket : buckets) {
            if (bucket == null || bucket.length == 0) {
                continue;
            }
            Arrays.sort(bucket);
            for (int i : bucket) {
                nums[index++] = i;
            }
        }
        return nums;
    }




}
