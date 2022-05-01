package com.code.leetcode.code6栈和队列.code3用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_225用队列实现栈 {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty());; // 返回 False
        System.out.println(myStack.pop()); // 返回 1
        System.out.println(myStack.empty());; // 返回 True

    }
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */

    static class MyStack1 {
        Queue<Integer> queue;
        Queue<Integer> backUpQueue;

        public MyStack1() {
            queue = new LinkedList<>();
            backUpQueue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {

            while (queue.size() > 1) {
                backUpQueue.add(queue.poll());
            }
            Integer poll = queue.poll();
            while (backUpQueue.size() > 0) {
                queue.add(backUpQueue.poll());
            }
            return poll;
        }

        public int top() {
            while (queue.size() > 1) {
                backUpQueue.add(queue.poll());
            }
            Integer poll = queue.poll();
            backUpQueue.add(poll);
            while (backUpQueue.size() > 0) {
                queue.add(backUpQueue.poll());
            }
            return poll;

        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    static class MyStack {
        Queue<Integer> queue;
        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            int size = queue.size();
            while (size-- > 1) {
                queue.add(queue.poll());
            }
            return queue.poll();
        }

        public int top() {
            int size = queue.size();
            while (size-- > 1) {
                queue.add(queue.poll());
            }
            Integer poll = queue.poll();
            queue.add(poll);
            return poll;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }



}
