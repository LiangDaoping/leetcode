package com.code.leetcode.双周赛.第72场双周赛;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode1_5996统计数组中相等且可以被整除的数对 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,2,2,1,3};
        int k = 2;
        System.out.println(countPairs(nums, k));// 4

        nums = new int[]{5,5,9,2,5,5,9,2,2,5,5,6,2,2,5,2,5,4,3};
        k = 7;
        System.out.println(countPairs(nums, k));// 18

        nums = new int[]{1,2,3,4};
        k = 1;
        System.out.println(countPairs(nums, k));// 0
    }

    public static int countPairs1(int[] nums, int k) {
        int length = nums.length;
        // 相同的数字，下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        int res = 0;
        for (Map.Entry<Integer, List<Integer>> integerListEntry : map.entrySet()) {
            List<Integer> value = integerListEntry.getValue();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (value.get(i) * value.get(j) % k == 0) {
                        res++;
                    }
                }
            }
        }

//        System.out.println(map);


        return res;
    }

    public static int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
