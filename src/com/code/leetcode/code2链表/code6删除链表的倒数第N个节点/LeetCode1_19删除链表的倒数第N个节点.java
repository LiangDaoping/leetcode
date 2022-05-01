package com.code.leetcode.code2链表.code6删除链表的倒数第N个节点;

public class LeetCode1_19删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        //removeNthFromEnd1:翻转，删除，翻转
        //removeNthFromEnd2:双指针+虚拟节点


        int[] nums = {1,2,3,4,5};
        int n = 2;
        ListNode node = init(nums);
        node = removeNthFromEnd3(node, n);
        print(node);// 1,2,3,5

        nums = new int[]{1};
        n = 1;
        node = init(nums);
        node = removeNthFromEnd3(node, n);
        print(node); //

        nums = new int[]{1, 2};
        n = 1;
        node = init(nums);
        node = removeNthFromEnd3(node, n);
        print(node); // 1

        nums = new int[]{1, 2};
        n = 2;
        node = init(nums);
        node = removeNthFromEnd3(node, n);
        print(node); // 2


    }

    public static ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return slow.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode slow = dummyNode;
        ListNode fast = dummyNode;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummyNode.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = flip(head);

        ListNode cur = newHead;
        for (int i = 0; i < n - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return flip(newHead.next);
    }

    public static ListNode flip(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = flip(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode init(int[] nums) {
        if (nums.length < 1) return null;
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

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

}
