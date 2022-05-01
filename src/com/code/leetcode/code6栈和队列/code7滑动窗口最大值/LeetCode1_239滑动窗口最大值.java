package com.code.leetcode.code6栈和队列.code7滑动窗口最大值;


import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_239滑动窗口最大值 {

    public static void main(String[] args) {
        // maxSlidingWindow1：错误暴力，超时
        // maxSlidingWindow2：找到最大值后，如果新进入的没有大于最大值，则一直是最大值。如果出去的等于最大值，更新最大值

        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [3,3,5,5,6,7]

        nums = new int[]{1};
        k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [1]

        nums = new int[]{1,-1};
        k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [1,-1]

        nums = new int[]{7,2,4};
        k = 2;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [7,4]

        nums = new int[]{1,3,1,2,0,5};
        k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [3,3,2,5]

        nums = new int[]{4,3,11};
        k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [11]

        nums = new int[]{-7,-8,7,5,7,1,6,0};
        k = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));// [7,7,7,7,7]

        nums = new int[]{-7,-8,7,5,7,1,6,0};
        k = 0;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));//
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        for (int i = 0; i < length - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int length = nums.length;
        int len = length - k + 1;
        int[] res = new int[len];

        int j = 0;
        int max = findMax(nums, k, 0);
        res[j++] = max;

        for (int i = k; i < length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i - k] == max) {
                max = findMax(nums, k, i - k + 1);
            }
            res[j++] = max;
        }
        return res;
    }

    private static int findMax(int[] nums, int k, int begin) {
        int max = Integer.MIN_VALUE;
        for (int i = begin; i < begin + k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static int[] maxSlidingWindow3(int[] nums, int k) {
        if (nums == null) return null;
        int length = nums.length;
        if (length < 2 || k > length) return nums;

        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int[] res = new int[length - k + 1];
        int index = 0;
        res[index++] = myQueue.front();

        for (int i = k; i < length; i++) {
            myQueue.pop(nums[i-k]);
            myQueue.push(nums[i]);
            res[index++] = myQueue.front();
        }

        return res;
    }

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();
        MyQueue() { }

        void pop(int element) {
            // 如果弹出的元素，等于出口，则出口的弹出
            if (deque.size() > 0 && deque.peek() == element) {
                deque.pop();
            }
        }

        void push(int element) {
            // 如果放入的元素大于入口的元素，则弹出入口元素，直到放入元素小于或等于入口元素
            while (deque.size() > 0 && deque.getLast() < element) {
                deque.removeLast();
            }
            // 添加在队列尾部
            deque.add(element);
        }

        int front() {
            if (deque.size() == 0) {
                return -1;
            }
            return deque.peek();
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return null;
        int length = nums.length;
        if (k < 1 || k > length) return nums;
        // 1 <= k <= nums.length
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
        }
        int[] res = new int[length - k + 1];
        int index = 0;
        // 会引起拆装箱错误
        res[index++] = deque.peekFirst() == null ? -1 : deque.peekFirst();


        for (int i = k; i < length; i++) {
            // 左侧移除，检查队列头是否和左侧相同
            if (deque.peekFirst() != null && nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }

            // 右侧添加，检查队列尾，如果尾巴小于当前元素，则移除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            // 会引起拆装箱错误
            res[index++] = deque.peekFirst() == null ? -1 : deque.peekFirst();
        }


        return res;
    }
}
