package com.code.leetcode.code6栈和队列.code8前K个高频元素;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_347前K个高频元素 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));// [1,2]

        nums = new int[]{1};
        k = 1;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));// [1]


    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        Comparator<Map.Entry<Integer, Integer>> objectComparator = Comparator.comparingInt(Map.Entry::getValue);
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(objectComparator);
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            priorityQueue.add(integerIntegerEntry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            if (priorityQueue.size() > 0) {
                result[i] = priorityQueue.poll().getKey();
            }
        }
        return result;
    }



}
