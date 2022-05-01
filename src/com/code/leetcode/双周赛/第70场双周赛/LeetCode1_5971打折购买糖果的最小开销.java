package com.code.leetcode.双周赛.第70场双周赛;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode1_5971打折购买糖果的最小开销 {
    public static void main(String[] args) {
        int[] cost = new int[]{1,2,3};
        System.out.println(minimumCost(cost));//5

        cost = new int[]{6,5,7,9,2,2};
        System.out.println(minimumCost(cost));//23

        cost = new int[]{5,5};
        System.out.println(minimumCost(cost));//10

        cost = new int[]{5};
        System.out.println(minimumCost(cost));//5
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int endLen = cost.length;
        int beginLen = endLen % 3;
        int total = 0;

        for (int i = endLen - 1; i > beginLen; i -= 3) {
            total += cost[i];
            total += cost[i-1];
        }
        for (int i = 0; i < beginLen; i++) {
            total += cost[i];
        }
        return total;
    }
}
