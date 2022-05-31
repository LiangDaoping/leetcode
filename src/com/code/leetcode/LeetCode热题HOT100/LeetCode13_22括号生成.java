package com.code.leetcode.LeetCode热题HOT100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode13_22括号生成 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n)); // ["((()))","(()())","(())()","()(())","()()()"]

        n = 1;
        System.out.println(generateParenthesis(n)); // ["()"]
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, 0, 0, n, "");
        return list;
    }

    public static void dfs(List<String> list, int left, int right, int n, String str) {
        if (left < right) {
            return;
        }
        if (left == n && right == n) {
            list.add(str);
            return;
        }
        if (right < n) {
            dfs(list, left, right + 1, n, str + ")");
        }
        if (left < n) {
            dfs(list, left + 1, right, n, str + "(");
        }
    }
}
