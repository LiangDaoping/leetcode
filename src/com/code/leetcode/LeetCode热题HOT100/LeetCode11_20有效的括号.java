package com.code.leetcode.LeetCode热题HOT100;

import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode11_20有效的括号 {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s)); // true

        s = "()[]{}";
        System.out.println(isValid(s)); // true

        s = "(]";
        System.out.println(isValid(s)); // false

        s = "([)]";
        System.out.println(isValid(s)); // false

        s = "{[]}";
        System.out.println(isValid(s)); // true

        s = "(){}}{";
        System.out.println(isValid(s)); // false
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int index = 0;
        while (index < charArray.length) {
            char c = charArray[index++];
            if (c == '(') {
                stack.add(')');
            } else if (c == '{') {
                stack.add('}');
            } else if (c == '[') {
                stack.add(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid3(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int index = 0;
        while (index < charArray.length) {
            char c = charArray[index++];
            if (c == '(') {
                stack.add(')');
            } else if (c == '{') {
                stack.add('}');
            } else if (c == '[') {
                stack.add(']');
            } else if (stack.isEmpty() || stack.peek() != c) {
                return false;
            } else if (stack.peek() == c) {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int index = 0;
        while (index < charArray.length) {
            if (stack.isEmpty() || charArray[index] == '(' || charArray[index] == '{' || charArray[index] == '[') {
                stack.add(charArray[index++]);
                continue;
            }
            Character peek = stack.peek();
            if (peek == '(' && charArray[index] == ')') {
                stack.pop();
                index++;
            } else if (peek == '[' && charArray[index] == ']') {
                stack.pop();
                index++;
            } else if (peek == '{' && charArray[index] == '}') {
                stack.pop();
                index++;
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        stack.add(charArray[0]);
        int index = 1;
        while (index < charArray.length) {
            if (stack.isEmpty() || !isMatch(stack.peek(), charArray[index])) {
                stack.add(charArray[index++]);
            } else {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatch(char a, char b) {
        if ((a == '(' && b == ')')) {
            return true;
        }
        if ((a == '{' && b == '}')) {
            return true;
        }
        if ((a == '[' && b == ']')) {
            return true;
        }
        return false;
    }
}
