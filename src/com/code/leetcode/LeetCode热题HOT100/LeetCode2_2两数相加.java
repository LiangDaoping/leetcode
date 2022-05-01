package com.code.leetcode.LeetCode热题HOT100;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode2_2两数相加 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {2,4,3};
        int[] nums2 = new int[] {5,6,4};
        ListNode l1 = initListNode(nums1);
        ListNode l2 = initListNode(nums2);
        ListNode res = addTwoNumbers(l1, l2);
        print(res); // [7,0,8]

        nums1 = new int[] {0};
        nums2 = new int[] {0};
        l1 = initListNode(nums1);
        l2 = initListNode(nums2);
        res = addTwoNumbers(l1, l2);
        print(res); // 0

        nums1 = new int[] {9,9,9,9,9,9,9};
        nums2 = new int[] {9,9,9,9};
        l1 = initListNode(nums1);
        l2 = initListNode(nums2);
        res = addTwoNumbers(l1, l2);
        print(res); // 8,9,9,9,0,0,0,1
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public static ListNode initListNode(int[] nums) {
        if (nums == null || nums.length == 0) return new ListNode();
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        for (int i = 1; i < nums.length; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return new ListNode();
        int carry = 0;
        ListNode resEmptyHead = new ListNode();
        ListNode nodeRes = resEmptyHead;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;

            int resVal = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;

            nodeRes.next = new ListNode(resVal);

            nodeRes = nodeRes.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            nodeRes.next = new ListNode(carry);
        }

        return resEmptyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
