package com.code.leetcode.code4字符串.code4翻转字符串里的单词;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_151翻转字符串里的单词 {
    public static void main(String[] args) {
        //reverseWords1：java内置函数
        //reverseWords2：看题解，半抄半写
        String s = "the sky is blue";
        System.out.println(reverseWords2(s));//"blue is sky the"

        s = "  hello world  ";
        System.out.println(reverseWords2(s));//"world hello"

        s = " Folo  lC       M3brAFIMt  orQg   hzZ6ZXr4V    HLFPhuKrd   iIlUp465  HsKO       qF     agg      3DTRBSW    W5nI8f   jf8  ipv7nU     W6aRWh  tkTC       D      9cU1SNY     mt5       j      iFMWXsTV   kOgX   2N2p4Lw      RCk6S       d   HTrAP    7      DO       Zej     388Yrfbco  4Qp3   C9E y4LP9Q1t    YD3ZB QZLY    jPLDf      J     YRv   yKrGiI0R    AradFAIg       S44tFijlz iUWOgZlUv       SJ0YwuqU3l     n  9uwSAJFZ kIu    gUsc794d3X   ye Z1pBFk  45LbISTd1T  c riVy     g    J     E37    k0AT     rs   ysgvyG9Cw  wbXLC    EewjgQONX7   z4x7yJ7p      a5P       d       m    6eb8ivfj   L wjZ8km     L6AJFY     utNC  AkcL    2FfQ2k   pt11f  FZXp8mR5X  oe  l0  B wSF Uc";
        System.out.println(reverseWords2(s));

        System.out.println("Uc wSF B l0 oe FZXp8mR5X pt11f 2FfQ2k AkcL utNC L6AJFY wjZ8km L 6eb8ivfj m d a5P z4x7yJ7p EewjgQONX7 wbXLC ysgvyG9Cw rs k0AT E37 J g riVy c 45LbISTd1T Z1pBFk ye gUsc794d3X kIu 9uwSAJFZ n SJ0YwuqU3l iUWOgZlUv S44tFijlz AradFAIg yKrGiI0R YRv J jPLDf QZLY YD3ZB y4LP9Q1t C9E 4Qp3 388Yrfbco Zej DO 7 HTrAP d RCk6S 2N2p4Lw kOgX iFMWXsTV j mt5 9cU1SNY D tkTC W6aRWh ipv7nU jf8 W5nI8f 3DTRBSW agg qF HsKO iIlUp465 HLFPhuKrd hzZ6ZXr4V orQg M3brAFIMt lC Folo".equals(reverseWords2(s)));
    }

    public static String reverseWords1(String s) {
        String[] s1 = s.split(" ");
        List<String> list = new ArrayList<>();
        for (String s2 : s1) {
            if (!"".equals(s2)) {
                list.add(s2);
            }
        }

        Collections.reverse(list);
        return String.join(" ", list);
    }

    public static String reverseWords2(String s) {
        char[] chars = s.toCharArray();
//        移除多余空格
        StringBuilder stringBuilder = removeExtraSpaces(chars);
//        将整个字符串反转
        StringBuilder reverse = stringBuilder.reverse();
//        将每个单词反转
        StringBuilder reverseEachWord = reverseEachWord(reverse);

        return reverseEachWord.toString();
    }

    public static StringBuilder removeExtraSpaces(char[] chars) {
        StringBuilder res = new StringBuilder();
        int length = chars.length;
        if (length == 0) return res;
        int fast = 0;
        while (fast < length && chars[fast] == ' ') {
            fast++;
        }
        int end = length;
        while (end > 1 && chars[end - 1] == ' ') {
            end--;
        }

        for (; fast < end; fast++) {
            if (fast > 1 && chars[fast - 1] == chars[fast] && chars[fast] == ' ') {
            } else {
                res.append(chars[fast]);
            }
        }
        return res;
    }

    public static StringBuilder reverseEachWord(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        int length = sb.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) != ' ') {
                temp.append(sb.charAt(i));
            } else {
                temp.reverse();
                res.append(temp);
                res.append(" ");
                temp = new StringBuilder();
            }
        }
        if (temp.length() > 0) {
            temp.reverse();
            res.append(temp);
        }

        return res;
    }

}
