package com.code.leetcode.code6栈和队列.code9栈与队列总结;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_71简化路径 {

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));// "/home"

        path = "/../";
        System.out.println(simplifyPath(path));// "/"

        path = "/home//foo/";
        System.out.println(simplifyPath(path));// "/home/foo"

        path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));// "/c"


        path = "/...";
        System.out.println(simplifyPath(path));// "/..."

    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] split = path.split("/");
        for (String s : split) {
            if ("/".equals(s) || "".equals(s) || ".".equals(s)) {
                continue;
            }
            // 当stack.size == 1时，已经到了根目录，无法弹出
            if ("..".equals(s)) {
                if (stack.size() > 0) {
                    stack.pop();
                }
                continue;

            }
            stack.add(s);
        }
        if (stack.size() == 0) {
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        for (String s : stack) {
            ans.append("/").append(s);
        }

        return ans.toString();
    }


}
