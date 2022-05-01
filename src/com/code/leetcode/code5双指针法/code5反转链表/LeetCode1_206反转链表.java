package com.code.leetcode.code5双指针法.code5反转链表;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_206反转链表 {
    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        ListNode h = initListNode(head);
        ListNode reverseH = reverseList(h);
        System.out.println(h);
    }

    public static ListNode reverseList1(ListNode head) {
        if (head == null||head.next ==null) return head;
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;

        while (true) {
            mid.next = left;

            left = mid;
            mid = right;
            if (right == null) {
                break;
            }
            right = right.next;
        }
        return left;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null||head.next ==null) return head;
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head;

        while (right != null) {
            right = right.next;

            mid.next = left;
            left = mid;
            mid = right;
        }
        return left;
    }

    public static ListNode initListNode(int[] head) {
        int length = head.length;
        if (length == 0) return new ListNode();
        ListNode h = new ListNode(head[0]);

        ListNode node = h;
        for (int i = 1; i < length; i++) {
            node.next = new ListNode(head[i]);
            node = node.next;
        }
        return h;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }

}
