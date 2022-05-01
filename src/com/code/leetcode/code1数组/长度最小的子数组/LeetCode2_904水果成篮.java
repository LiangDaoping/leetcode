package com.code.leetcode.code1数组.长度最小的子数组;

import java.util.HashMap;

public class LeetCode2_904水果成篮 {
    public static void main(String[] args) {
        // totalFruit1：双指针，自己写
        // totalFruit2：双指针，看题解优化
        int[] fruits = {1, 2, 1};
        System.out.println(totalFruit2(fruits)); // 3

        fruits = new int[]{0,1,2,2};
        System.out.println(totalFruit2(fruits));// 3

        fruits = new int[]{1,2,3,2,2};
        System.out.println(totalFruit2(fruits));// 4

        fruits = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit2(fruits));// 5

    }

    public static int totalFruit1(int[] fruits) {
        if (fruits.length < 2) {
            return fruits.length;
        }
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int subIndex = 0;
        for (int fruit : fruits) {
            Integer integer = map.get(fruit);
            if (integer == null) {
                while (map.size() >= 2) {
                    Integer subRes = map.values().stream().reduce(0, Integer::sum);
                    if (res < subRes) {
                        res = subRes;
                    }
                    int subLen = map.get(fruits[subIndex]) - 1;
                    map.put(fruits[subIndex], subLen);
                    if (subLen == 0) {
                        map.remove(fruits[subIndex]);
                    }
                    subIndex++;
                }
                map.put(fruit, 1);
            } else {
                map.put(fruit, integer + 1);
            }
        }
        Integer subRes = map.values().stream().reduce(0, Integer::sum);
        if (res < subRes) {
            res = subRes;
        }
        return res == -1 ? 0 : res;
    }

    public static int totalFruit2(int[] fruits) {
        // 每次循环都在更新res，因此不需要判断小于2，或者最后的情况
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                // 大于2时，则需要减去之前的数量
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
