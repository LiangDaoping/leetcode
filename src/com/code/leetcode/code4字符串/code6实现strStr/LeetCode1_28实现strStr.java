package com.code.leetcode.code4字符串.code6实现strStr;

import java.util.Arrays;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_28实现strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr2(haystack, needle));//2   [-1, 0]                     [0, 1]

        haystack = "aaaaa";
        needle = "bba";
        System.out.println(strStr2(haystack, needle));//-1  [-1, 0, -1]                 [0, 1, 0]

        haystack = "";
        needle = "";
        System.out.println(strStr2(haystack, needle));//0   [-1, 0, -1, 0, 1, -1]       [0, 1, 0, 1, 2, 0]

        haystack = "aabaabaaf";
        needle = "aabaaf";
        System.out.println(strStr2(haystack, needle));//3   [-1]                        [0]

        haystack = "";
        needle = "a";
        System.out.println(strStr2(haystack, needle));//-1  无                           无

    }

    public static int strStr1(String haystack, String needle) {
        int needLeLen = needle.length();
        if (needLeLen == 0) return 0;
        int[] next = getNext1(needle);
        System.out.println(Arrays.toString(next));
        char[] charArray = haystack.toCharArray();

        int j = next[0];
        for (int i = 0; i < charArray.length; i++) {
            while (j > 0 && charArray[i] != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (charArray[i] == needle.charAt(j)) {
                j++;
            }

            if (j == needLeLen) {
                return i - needLeLen + 1;
            }
        }
        return -1;
    }

    private static int[] getNext1(String needle) {
        int length = needle.length();
        int[] next = new int[length];
        if (length == 0) return next;

        int j = 0;
        next[0] = j;
        for (int i = 1; i < length; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        System.out.println(Arrays.toString(next));
        return next;
    }

    public static int strStr2(String haystack, String needle) {
        char[] charArray = haystack.toCharArray();
        if (needle.length() == 0) return 0;

        int[] next = getNext2(needle);
        System.out.println(Arrays.toString(next));
        int j = next[0];
        for (int i = 0; i < charArray.length; i++) {
            while (j >= 0 && charArray[i] != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (charArray[i] == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    private static int[] getNext2(String needle) {
        char[] charArray = needle.toCharArray();
        int length = charArray.length;
        int[] next = new int[length];
        int j = -1;
        next[0] = j;
        for (int i = 1; i < length; i++) {
            while (j >= 0 && charArray[i] != charArray[j + 1]) {
                j = next[j];
            }

            if (charArray[i] == charArray[j+1]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }



}
