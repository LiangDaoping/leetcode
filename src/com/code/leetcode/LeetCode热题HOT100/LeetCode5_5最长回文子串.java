package com.code.leetcode.LeetCode热题HOT100;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode5_5最长回文子串 {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s)); //"bab"或"aba"

        s = "cbbd";
        System.out.println(longestPalindrome(s)); // "bb"

        s = "ac";
        System.out.println(longestPalindrome(s)); // "a"

        s = "aaaa";
        System.out.println(longestPalindrome(s)); // "aaaa"
    }

    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        boolean[][] flag = new boolean[len][len];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            // 对于任意的i->i，都是true
            flag[i][i] = true;
        }
        int maxValue = 1;
        int left = 0;
        int right = 1;
        // 从下往上进行赋值
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (charArray[i] != charArray[j]) {
                    flag[i][j] = false;
                } else {
                    // 两个字符相等一定是true，三个字符中前后相等也一定是true
                    if (j - i < 3) {
                        flag[i][j] = true;
                    } else {
                        // 如果当前结果相等，他的结果是
                        flag[i][j] = flag[i + 1][j - 1];
                    }
                }
                if (flag[i][j] && j - i + 1 > maxValue) {
                    maxValue = j - i + 1;
                    left = i;
                    right = j + 1;
                }
            }
        }
        return s.substring(left, right);
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int begin = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int palindrome1 = findPalindrome(s, i, i);
            int palindrome2 = findPalindrome(s, i, i + 1);
            int max = Math.max(palindrome1, palindrome2);
            if (max > end - begin) {
                // 当i->i+1开始时，假设max=4，当前位置下标为3，则应该是2、3、4、5，因此max需要-1
                begin = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    public static int findPalindrome(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        // end - begin = len + 1
        return end - begin - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append("#");
        }
        s = sb.toString();

        List<Integer> armLen = new ArrayList<>();
        // 某节点arm和某节点的右边界
        int j = -1;
        int right = -1;
        // 最长节点的前后坐标
        int start = 0, end = -1;
        for (int i = 0; i < s.length(); i++) {
            int curArmLen;
            // 如果新节点的下标在上面arm中，则有些地方可以跳过
            if (right >= i) {
                // 比较对称点的臂长，和当前区间内的臂长。则可以对应的跳过检查
                int min = Math.min(armLen.get(2 * j - i), right - i);
                // armLen.get(2 * j - i)一定有值，原因是2 * j - i = j - (i - j)
                curArmLen = expand(s, i - min, i + min);
            } else {
                curArmLen = expand(s, i, i);
            }
            armLen.add(curArmLen);
            // 更新某节点arm和某节点的右边界
            if (i + curArmLen > right) {
                j = i;
                right = i + curArmLen;
            }
            // 记录当前回文是否最长的长度
            if (curArmLen * 2 >= end - start) {
                start = i - curArmLen;
                end = i + curArmLen;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
}
