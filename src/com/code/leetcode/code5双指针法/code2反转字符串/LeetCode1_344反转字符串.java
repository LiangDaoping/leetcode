package com.code.leetcode.code5双指针法.code2反转字符串;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_344反转字符串 {
    public static void main(String[] args) {
        String str = "hello";
        char[] s = str.toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));

        str = "Hannah";
        s = str.toCharArray();
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString1(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        if (fast <= 0) return;
        while (slow < fast) {
            char temp = s[slow];
            s[slow] = s[fast];
            s[fast] = temp;
            slow++;
            fast--;
        }
    }

    public static void reverseString(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        if (fast <= 0) return;
        while (slow < fast) {
            s[slow] ^= s[fast];
            s[fast] ^= s[slow];
            s[slow] ^= s[fast];

            slow++;
            fast--;
        }
    }

}
