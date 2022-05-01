package com.code.leetcode.code1数组.移除元素;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode4_844比较含退格的字符串 {
    public static void main(String[] args) {
        // backspaceCompare1：重构字符串
        // backspaceCompare2：双指针法，抄的题解
        // backspaceCompare3：双指针法，自行研究题解的思路
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare3(s, t)); // true

        s = "ab##";
        t = "c#d#";
        System.out.println(backspaceCompare3(s, t)); // true

        s = "a##c";
        t = "#a#c";
        System.out.println(backspaceCompare3(s, t)); // true

        s = "a#c";
        t = "b";
        System.out.println(backspaceCompare3(s, t)); // false

        s = "xywrrmp";
        t = "xywrrmu#p";
        System.out.println(backspaceCompare3(s, t)); // true

        s = "bxj##tw";
        t = "bxj###tw";
        System.out.println(backspaceCompare3(s, t)); // false

        s = "nzp#o#g";
        t = "b#nzp#o#g";
        System.out.println(backspaceCompare3(s, t)); // true

    }

    public static boolean backspaceCompare1(String s, String t) {
        return build(s).equals(build(t));
    }

    public static String build(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '#') {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            } else {
                res.append(charAt);
            }
        }
        return res.toString();
    }

    public static boolean backspaceCompare2(String s, String t) {
        int iLen = s.length() - 1;
        int jLen = t.length() - 1;
        int iDelete = 0;
        int jDelete = 0;
        // while (iLen >= 0 && jLen >= 0)：此处不能用||，因为可能s或t剩余的部分全是####
        while (iLen >= 0 || jLen >= 0) {
            while (iLen >= 0) {
                char iCharAt = s.charAt(iLen);
                if (iCharAt == '#') {
                    iLen--;
                    iDelete++;
                } else if (iDelete > 0) {
                    iDelete--;
                    iLen--;
                } else {
                    break;
                }
            }
            while (jLen >= 0) {
                char jCharAt = t.charAt(jLen);
                if (jCharAt == '#') {
                    jLen--;
                    jDelete++;
                } else if (jDelete > 0) {
                    jDelete--;
                    jLen--;
                } else {
                    break;
                }
            }
            if (iLen >= 0 && jLen >= 0) {
                if (s.charAt(iLen) != t.charAt(jLen)) {
                    return false;
                }
            }
            else {
//                 iLen >= 0     jLen < 0
//                 iLen < 0     jLen >= 0
//                 iLen < 0     jLen < 0
                if (iLen >= 0 || jLen >= 0) {
                    return false;
                }
                // 只有i < 0 && jLen < 0 为true
            }

            iLen--;
            jLen--;
        }
        return true;
    }

    public static boolean backspaceCompare3(String s, String t) {
        int iLen = s.length() - 1;
        int jLen = t.length() - 1;
        int iDelete = 0;
        int jDelete = 0;
        while (iLen >= 0 || jLen >= 0) {
            while (iLen >= 0) {
                char iCharAt = s.charAt(iLen);
                if (iCharAt == '#') {
                    iDelete++;
                    iLen--;
                } else if (iDelete > 0) {
                    iDelete--;
                    iLen--;
                } else {
                    break;
                }
            }

            while (jLen >= 0) {
                char jCharAt = t.charAt(jLen);
                if (jCharAt == '#') {
                    jDelete++;
                    jLen--;
                } else if (jDelete > 0) {
                    jDelete--;
                    jLen--;
                } else {
                    break;
                }
            }
            // iLen >= 0  jLen >= 0 s.charAt(iLen) != t.charAt(jLen) false
            // iLen >= 0  jLen >= 0 s.charAt(iLen) == t.charAt(jLen) continue;
            // iLen >= 0  jLen < 0 s.charAt(iLen) != t.charAt(jLen) 报错,false
            // iLen >= 0  jLen < 0 s.charAt(iLen) == t.charAt(jLen) 报错,false
            // iLen < 0  jLen >= 0 s.charAt(iLen) != t.charAt(jLen) 报错,false
            // iLen < 0  jLen >= 0 s.charAt(iLen) == t.charAt(jLen) 报错,false
            // iLen < 0  jLen < 0 true
            // iLen < 0  jLen < 0 true

            if (iLen >= 0 && jLen >= 0 && s.charAt(iLen) != t.charAt(jLen)) {
                return false;
            }
            // 仅仅一个大于0，则false
            if (!(iLen >= 0 && jLen >= 0) && (iLen >= 0 || jLen >= 0)) {
                return false;
            }

            iLen--;
            jLen--;
        }
        return true;
    }

}
