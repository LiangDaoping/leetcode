package com.code.leetcode.code6栈和队列.code6逆波兰表达式求值;


import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_150逆波兰表达式求值 {

    public static void main(String[] args) {
        // 逆波兰表达式，即后缀表达式

        String[] tokens = new String[]{"2","1","+","3","*"};
        //该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
        System.out.println(evalRPN(tokens));// 9


        tokens = new String[]{"4","13","5","/","+"};
        //该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
        System.out.println(evalRPN(tokens));// 6

        tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        // 该算式转化为常见的中缀算术表达式为：
        //    ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
        //    = ((10 * (6 / (12 * -11))) + 17) + 5
        //    = ((10 * (6 / -132)) + 17) + 5
        //    = ((10 * 0) + 17) + 5
        //    = (0 + 17) + 5
        //    = 17 + 5
        //    = 22
        System.out.println(evalRPN(tokens));// 22
    }

    public static int evalRPN1(String[] tokens) {
        int length = tokens.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            String token = tokens[i];
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    // 错误
                    return -1;
                }
                String secondOperator = stack.pop();
                String firstOperator = stack.pop();
                stack.add(cal(firstOperator, secondOperator, token));
            } else {
                stack.add(token);
            }
        }
        if (stack.size() == 1) return Integer.parseInt(stack.pop());
        else return -1;
    }

    private static boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    private static String cal(String firstString, String secondString, String operator) {
        int first = Integer.parseInt(firstString);
        int second = Integer.parseInt(secondString);

        int res;
        switch (operator) {
            case "+" : res = first + second;break;
            case "-" : res = first - second;break;
            case "*" : res = first * second;break;
            case "/" : res = first / second;break;
            default:return "-1";
        }
        return String.valueOf(res);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.add(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.add(-stack.pop() + stack.pop());
            } else if ("*".equals(token)) {
                stack.add(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                Integer second = stack.pop();
                Integer first = stack.pop();
                stack.add(first / second);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
