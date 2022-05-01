package com.code.leetcode.LeetCode热题HOT100;


import java.util.ArrayDeque;
import java.util.Queue;
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
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Queue<Character> queue = new ArrayDeque<>();
        Stack<Character> characters= new Stack<>();
        characters.add('1');
        queue.add(s.charAt(0));
        int index = 1;
        while (!queue.isEmpty() && index < s.length()) {
            Character poll = queue.peek();
            if (poll == '{' && s.charAt(index) == '}') {
                queue.poll();
                continue;
            }
            if (poll == '(' && s.charAt(index) == ')') {
                queue.poll();
                continue;
            }
            if (poll == '[' && s.charAt(index) == ']') {
                queue.poll();
                continue;
            }
            queue.add(s.charAt(index));
            index++;
        }
        return queue.isEmpty();
    }
}
