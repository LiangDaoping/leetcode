package com.code.leetcode.code6栈和队列.code5删除字符串中的所有相邻重复项;


import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_1047删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));// "ca"
    }

    public static String removeDuplicates1(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            Character peek = stack.size() == 0 ? ' ' : stack.peek();
            if (peek == charAt) {
                stack.pop();
                continue;
            }
            stack.push(charAt);
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }

    public static String removeDuplicates2(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            char peek = stack.size() == 0 ? ' ' : stack.peek();
            if (peek == charAt) {
                stack.pop();
                continue;
            }
            stack.push(charAt);
        }
        char[] ans = new char[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return new String(ans);
    }

    public static String removeDuplicates(String s) {
        char[] charArray = s.toCharArray();


        int left = 0;
        for (int right = 0; right < charArray.length; right++) {
            charArray[left] = charArray[right];

            if (left > 0 && charArray[left] == charArray[left-1]) {
                left--;
            } else {
                left++;
            }

        }

        return new String(charArray, 0, left);
    }

}
