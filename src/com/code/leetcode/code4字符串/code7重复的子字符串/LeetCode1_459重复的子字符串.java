package com.code.leetcode.code4字符串.code7重复的子字符串;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_459重复的子字符串 {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));// true

        s = "aba";
        System.out.println(repeatedSubstringPattern(s));// false

        s = "abc abc abc abc";
        System.out.println(repeatedSubstringPattern(s));// true

        s = "ababba";
        System.out.println(repeatedSubstringPattern(s));// false

        s = "aabaaba";
        System.out.println(repeatedSubstringPattern(s));// false

        s = "abaababaab";
        System.out.println(repeatedSubstringPattern(s));// true
    }

    public static boolean repeatedSubstringPattern(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        if (length == 0) {
            return false;
        }
        int[] next = getNext(charArray);

        int maxSubLen = next[length - 1];
        if (maxSubLen == 0) {
            return false;
        }
        return maxSubLen % (length - maxSubLen) == 0;
//        return length % (length - maxSubLen) == 0;
    }

    public static int[] getNext(char[] charArray) {
        int length = charArray.length;
        int[] res = new int[length];
        if (length == 0) return res;
        int j = 0;
        res[0] = j;
        for (int i = 1; i < length; i++) {
            while (j > 0 && charArray[i] != charArray[j]) {
                j = res[j - 1];
            }
            if (charArray[i] == charArray[j]) {
                j++;
            }
            res[i] = j;
        }
        return res;
    }


}
