package com.code.leetcode.code4字符串.code2反转字符串II;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_541反转字符串II {
    public static void main(String[] args) {
        //reverseStr1：自解，第一次
        //reverseStr2：自解，优化1
        //reverseStr3：其他解法
        //reverseStr4：其他解法
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr4(s, k));//"bacdfeg"

        s = "abcd";
        k = 2;
        System.out.println(reverseStr4(s, k));//"bacd"
    }

    public static String reverseStr1(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int left = 0;
        StringBuilder res = new StringBuilder();
        while (true) {
            if (length < k) {
                // left -> left + length
                char[] swap = swap(chars, left, left + length);
                res.append(swap);
                break;
            } else {
                // left -> left + k;
                char[] swap = swap(chars, left, left + k);
                res.append(swap);
                for (int i = left + k; i < left + k + k && i < chars.length; i++) {
                    res.append(chars[i]);
                }
            }
            left += 2 * k;
            length -= 2 * k;
        }
        return res.toString();
    }

    public static char[] swap(char[] s, int begin, int end) {
        if (begin > end) return new char[0];
        char[] res = new char[end - begin];
        for (int i = 0; i < res.length; i++) {
            res[i] = s[i + begin];
        }
        begin = 0;
        end = res.length - 1;
        while (begin < end) {
            char temp = res[begin];
            res[begin] = res[end];
            res[end] = temp;
            begin++;
            end--;
        }
        return res;

    }

    public static String reverseStr2(String s, int k) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int cycleCount = length / (2 * k);
        int elseCount = length - cycleCount * 2 * k;
        StringBuilder res = new StringBuilder();

        //处理2k的部分
        for (int i = 0; i < cycleCount; i++) {
            int doubleK = 2 * k;
            int begin = i * doubleK;
            int end = begin + k - 1;
            while (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
                begin++;
                end--;
            }
        }
        // 处理剩下的
        if (elseCount < k) {
            // length - elseCount -> length
            int begin = length - elseCount;
            int end = length - 1;
            while (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
                begin++;
                end--;
            }
        } else {
            // length - elseCount -> length - elseCount + k
            int begin = length - elseCount;
            int end = begin + k - 1;
            while (begin < end) {
                char temp = chars[begin];
                chars[begin] = chars[end];
                chars[end] = temp;
                begin++;
                end--;
            }
        }
        return String.valueOf(chars);
    }

    public static String reverseStr3(String s, int k) {
        StringBuilder res = new StringBuilder();
        int start = 0;
        int length = s.length();
        while (start < length) {
            StringBuilder temp = new StringBuilder();

            int firstK = start + k;
            // 如果现在剩下的在k-2k之间，还是翻转前面k
            // 如果现在剩下的是k之内，那么剩下的全部翻转
            if (firstK > length) {
                firstK = length;
            }

            temp.append(s, start, firstK);
            res.append(temp.reverse());


            int secondK = start +  2 * k;
            if (secondK > length) {
                secondK = length;
            }
            // 如果该区间是2k，则后面的k放入里面。
            if (firstK < secondK) {
                res.append(s, firstK, secondK);
            }

            start += (2 * k);
        }

        return res.toString();
    }

    public static String reverseStr4(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += (2 * k)) {
            int start = i;
            int end = Math.min(ch.length - 1, i + k - 1);
            while (start < end) {
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
