package com.code.leetcode.code6栈和队列.code2用栈实现队列;

import java.util.Stack;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_232用栈实现队列 {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false

    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    static class MyQueue {
        Stack<Integer> inStack;
        Stack<Integer> outStack;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                // 如果出栈为空，则将所有的入栈放入出栈中
                while (!inStack.isEmpty()) {
                    Integer pop = inStack.pop();
                    outStack.push(pop);
                }
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                // 如果出栈为空，则将所有的入栈放入出栈中
                while (!inStack.isEmpty()) {
                    Integer pop = inStack.pop();
                    outStack.push(pop);
                }
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }
    }


}
