package com.code.leetcode.code6栈和队列.code4有效的括号;

import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_20有效的括号 {

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));// true

        s = "()[]{}";
        System.out.println(isValid(s));// true

        s = "(]";
        System.out.println(isValid(s));// false

        s = "([)]";
        System.out.println(isValid(s));// false

        s = "{[]}";
        System.out.println(isValid(s));// true
    }

    public static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character peek = stack.size() == 0 ? ' ' : stack.peek();
            char charAt = s.charAt(i);
            if (isPair(peek, charAt)) {
                stack.pop();
                continue;
            }
            stack.push(charAt);
        }
        return stack.size() == 0;
    }

    private static boolean isPair(Character left, Character right) {
        boolean true1 = left == '(' && right == ')';
        boolean true2 = left == '{' && right == '}';
        boolean true3 = left == '[' && right == ']';
        return true1 || true2 || true3;
    }

    public static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char charAt = s.charAt(i);
            if (charAt == '(') {
                stack.push(')');
            } else if (charAt == '{') {
                stack.push('}');
            } else if (charAt == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != charAt) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
