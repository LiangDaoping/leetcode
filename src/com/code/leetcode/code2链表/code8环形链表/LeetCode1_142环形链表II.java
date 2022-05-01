package com.code.leetcode.code2链表.code8环形链表;

import java.util.HashSet;
import java.util.Set;

public class LeetCode1_142环形链表II {
    public static void main(String[] args) {
        //detectCycle1: 自解，哈希表
        //detectCycle1: 自解，哈希表


        int[] node = new int[]{3,2,0,-4};
        int pos = 1;
        ListNode init = init(node, pos);
        System.out.println(detectCycle2(init));

        node = new int[]{1,2};
        pos = 0;
        init = init(node, pos);
        System.out.println(detectCycle2(init));

        node = new int[]{1};
        pos = -1;
        init = init(node, pos);
        System.out.println(detectCycle2(init));



    }

    public static ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // 如果快指针为null后，则说明无环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                //有环
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }

    public static ListNode init(int[] nums, int pos) {
        if (nums.length < 1) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;

        ListNode specialNode = null;
        if (pos == 0) {
            specialNode = head;
        }
        for (int i = 1; i < nums.length; i++) {
            ListNode listNode = new ListNode(nums[i]);
            if (pos == i) {
                specialNode = listNode;
            }
            node.next = listNode;
            node = node.next;
        }
        node.next = specialNode;
        return head;
    }

    public static void print(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
