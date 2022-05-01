package com.code.leetcode.LeetCode热题HOT100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode1_1两数之和 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer == null) {
                map.put(nums[i], i);
            } else {
                int[] result = new int[2];
                result[0] = integer;
                result[1] = i;
                return result;
            }
        }
        return new int[0];
    }
}
