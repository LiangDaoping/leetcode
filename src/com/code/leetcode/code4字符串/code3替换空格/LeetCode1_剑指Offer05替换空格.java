package com.code.leetcode.code4字符串.code3替换空格;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_剑指Offer05替换空格 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));//"We%20are%20happy."
    }

    public static String replaceSpace1(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' ') {
                res.append("%20");
            } else {
                res.append(aChar);
            }
        }
        return res.toString();
    }

    public static String replaceSpace(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int sOldSize = chars.length;
        for (char aChar : chars) {
            if (aChar == ' ') {
                count++;
            }
        }

        Arrays.copyOf(chars,10);



        return s;
    }
}
