package com.code.leetcode.国企民航;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/24
 */
public class a字符串是否包含b字符串 {
    public static void main(String[] args) {
//        I. 求一个字符串"BBC ABCDAB ABCDABCDABDE"，里面是否包含另一个字符串"ABCDABD"（尽量减小时间复杂度，禁止截取字符串）
        String fatherString = "BBC ABCDAB ABCDABCDABDE";
        String sonString = "ABCDABD";
        System.out.println(isContains(fatherString, sonString));
    }

    public static boolean isContains(String fatherString, String sonString) {
        if (sonString == null || sonString.length() == 0) return true;
        if (fatherString == null || fatherString.length() == 0) return false;

        int[] next = getNext(sonString);
        int j = next[0];
        for (int i = 0; i < fatherString.length(); i++) {
            while (j > 0 && fatherString.charAt(i) != sonString.charAt(j)) {
                j = next[j - 1];
            }
            if (fatherString.charAt(i) == sonString.charAt(j)) {
                j++;
            }
            if (j == sonString.length()) {
                return true;
            }
        }

        return false;
    }

    public static int[] getNext(String sonString) {
        if (sonString == null || sonString.length() == 0) return new int[0];
        int[] next = new int[sonString.length()];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < sonString.length(); i++) {
            while (j > 0 && sonString.charAt(i) != sonString.charAt(j)) {
                // 不等则寻找上次相等的地方
                j = next[j - 1];
            }
            if (sonString.charAt(i) == sonString.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        return next;
    }
}
