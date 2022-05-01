package com.code.leetcode.code5双指针法.code4翻转字符串里的单词;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_151翻转字符串里的单词 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));//"blue is sky the"

        s = "  hello world  ";
        System.out.println(reverseWords(s));//"world hello"

        s = "a good   example";
        System.out.println(reverseWords(s));//"example good a"

        s = "  Bob    Loves  Alice   ";
        System.out.println(reverseWords(s));//"Alice Loves Bob"

        s = "Alice does not even like bob";
        System.out.println(reverseWords(s));//"bob like even not does Alice"
    }

    public static String reverseWords(String s) {
        if (s.length() == 0) return s;
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    public static StringBuilder removeSpace(String s) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || res.charAt(res.length() - 1) != ' ') {
                res.append(c);
            }
            start++;
        }
        return res;
    }

    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int length = sb.length();
        while (start < length) {
            while (end < length && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }

    }



}
