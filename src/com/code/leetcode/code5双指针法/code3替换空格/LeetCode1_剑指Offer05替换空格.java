package com.code.leetcode.code5双指针法.code3替换空格;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_剑指Offer05替换空格 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("  ");
            }
        }
        if (sb.length() == 0)
            return s;

        int left = s.length() - 1;
        s += sb.toString();
        char[] chars = s.toCharArray();
        for (int right = chars.length - 1; right >= 0 && left >= 0; right--) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
        }

        return new String(chars);
    }

}
