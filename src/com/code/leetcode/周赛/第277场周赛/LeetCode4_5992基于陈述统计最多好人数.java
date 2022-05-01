package com.code.leetcode.周赛.第277场周赛;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode4_5992基于陈述统计最多好人数 {
    public static void main(String[] args) {
        int[][] statements = new int[][]{{2,1,2},{1,2,2},{2,0,2}};
        System.out.println(maximumGood(statements));//2

        statements = new int[][]{{2,0},{0,2}};
        System.out.println(maximumGood(statements));//1
    }

    public static int maximumGood(int[][] statements) {
        int ans = 0;
        int n = statements.length;
        next:
        for (int i = 1; i < (1 << n); i++) {
            int cnt = 0; // i 中好人个数，假设i是001->010->011...
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) { // 枚举 i 中的好人 j，假如在情况i中，j是好人则继续验证j的猜测是否正确
                    for (int k = 0; k < n; k++) { // 枚举 j 的所有陈述
                        if (statements[j][k] < 2 && statements[j][k] != ((i >> k) & 1)) { // 该陈述与实际情况矛盾，如果猜测情况不是未评价同时评价与实际不符，则本情况失败
                            continue next;
                        }
                    }
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }


}
