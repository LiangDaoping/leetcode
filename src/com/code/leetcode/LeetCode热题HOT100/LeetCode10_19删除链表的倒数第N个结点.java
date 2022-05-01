package com.code.leetcode.LeetCode热题HOT100;


/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode10_19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        int[] head = new int[] {1,2,3,4,5};
        int n = 2;
        ListNode init = new ListNode().init(head);
        ListNode ans = removeNthFromEnd(init, n);
        // [1,2,3,5]

        head = new int[] {1};
        n = 1;
        init = new ListNode().init(head);
        ans = removeNthFromEnd(init, n);
        // []

        head = new int[] {1, 2};
        n = 1;
        init = new ListNode().init(head);
        ans = removeNthFromEnd(init, n);
        // [1]

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode();
        empty.next = head;

        ListNode left = empty;
        ListNode right = empty.next;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return empty.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        public ListNode init(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ListNode();
            }
            ListNode head = new ListNode(nums[0]);
            ListNode node = head;
            for (int i = 1; i < nums.length; i++) {
                node.next = new ListNode(nums[i]);
                node = node.next;
            }
            return head;
        }
    }
}
