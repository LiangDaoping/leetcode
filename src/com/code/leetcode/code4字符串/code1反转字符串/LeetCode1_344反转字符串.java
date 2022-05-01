package com.code.leetcode.code4字符串.code1反转字符串;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_344反转字符串 {
    public static void main(String[] args) {
        //reverseString1:正常翻转
        //reverseString2：没用中间变量temp翻转
        String s = "hello";
        char[] charArray = s.toCharArray();
        reverseString2(charArray);
        System.out.println(charArray);//["o","l","l","e","h"]

        s = "Hannah";
        charArray = s.toCharArray();
        reverseString2(charArray);
        System.out.println(charArray);//["h","a","n","n","a","H"]

        s = "Habch";
        charArray = s.toCharArray();
        reverseString2(charArray);
        System.out.println(charArray);//["h","c","b","a","H"]
    }

    public static void reverseString1(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        while (slow < fast) {
            char temp = s[slow];
            s[slow] = s[fast];
            s[fast] = temp;
            slow++;
            fast--;
        }
    }

    public static void reverseString2(char[] s) {
        int slow = 0;
        int fast = s.length - 1;
        while (slow < fast) {
            // 基本原理a^a=0,a^0=a
            // 推出a=a^a^b;b=b^b^a;
            s[slow] ^= s[fast];
            s[fast] ^= s[slow];
            s[slow] ^= s[fast];
            slow++;
            fast--;

        }
    }
}
