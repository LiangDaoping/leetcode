package com.code.leetcode.LeetCode热题HOT100;


/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode6_10正则表达式匹配 {
    public static void main(String[] args) {
        // 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
        // '.' 匹配任意单个字符
        // '*' 匹配零个或多个前面的那一个元素
        String s = "aa", p = "a";
        System.out.println(isMatch(s, p)); // false

        s = "aa";
        p = "a*";
        System.out.println(isMatch(s, p)); // true

        s = "ab";
        p = ".*";
        System.out.println(isMatch(s, p)); // true

        s = "aaab";
        p = ".*ac";
        System.out.println(isMatch(s, p)); // false

        s = "aaab";
        p = ".*ab";
        System.out.println(isMatch(s, p)); // true


        s = "aab";
        p = "c*a*b";
        System.out.println(isMatch(s, p)); // true

        s = "mississippi";
        p = "mis*is*p*.";
        System.out.println(isMatch(s, p)); // false
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            // j = 0 时，一定是false
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    // 由于数据就限制了一定是正确的，因此此处的j-2不会数组越界
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }
        }
        return dp[m][n];
    }

    public static boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
