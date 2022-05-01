package com.code.leetcode.日志易;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/22
 */
public class LeetCode_96不同的二叉搜索树 {
    public static void main(String[] args) {
        // DP问题：
        // n = 0， res = 1
        // n = 1， res = 1
        // n = 2， f(0) * f(1) + f(1) * f(0) = 2
        // n = 3， f(0) * f(2) + f(1) * f(1) + f(2) * f(0)  = 2 + 1 + 2 = 5
        //...
        int n = 3;
        System.out.println(numTrees(n)); // 5

        n = 1;
        System.out.println(numTrees(n)); // 1
    }

    public static int numTrees(int n) {
        if (n <= 1) return 1;
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                int a = res[j];
                int b = res[i - j - 1];
                res[i] += a * b;
            }
        }
        return res[n];
    }
}
