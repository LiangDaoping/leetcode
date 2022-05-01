package com.code.leetcode.code4字符串.code5左旋转字符串;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_剑指Offer58_II左旋转字符串 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseLeftWords(s, k));//"cdefgab"

        s = "lrloseumgh";
        k = 6;
        System.out.println(reverseLeftWords(s, k));//"umghlrlose"
    }

    public static String reverseLeftWords1(String s, int n) {
        StringBuilder res = new StringBuilder();

        String substring = s.substring(0, n);
        String substring1 = s.substring(n);
        res.append(substring1);
        res.append(substring);

        return res.toString();
    }

    public static String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static String reverseLeftWords(String s, int n) {
        char[] charArray = s.toCharArray();
//    反转区间为前n的子串
        int begin = 0;
        int end = n - 1;
        while (begin < end) {
            char temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;
            end--;
        }
//    反转区间为n到末尾的子串
        begin = n;
        end = charArray.length - 1;
        while (begin < end) {
            char temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;
            end--;
        }
//    反转整个字符串
        begin = 0;
        end = charArray.length - 1;
        while (begin < end) {
            char temp = charArray[begin];
            charArray[begin] = charArray[end];
            charArray[end] = temp;
            begin++;
            end--;
        }
        return new String(charArray);
    }



}
