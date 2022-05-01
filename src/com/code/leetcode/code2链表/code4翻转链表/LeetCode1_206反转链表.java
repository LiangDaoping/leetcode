package com.code.leetcode.code2链表.code4翻转链表;

public class LeetCode1_206反转链表 {
    public static void main(String[] args) {
        // 双指针法
        // 递归法
        // 双指针法变成的递归法
        int[] nums = {1,2,3,4,5};
        ListNode node = init(nums);
        node = reverseList3(node);
        print(node);
        nums = new int[]{1,2};
        node = init(nums);
        node = reverseList3(node);
        print(node);
        nums = new int[]{};
        node = init(nums);
        node = reverseList3(node);
        print(node);
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


    public static ListNode reverseList3(ListNode head) {
        return reverseList3_reverse(null, head);
    }

    public static ListNode reverseList3_reverse(ListNode pre, ListNode cur) {
        if (cur == null) return pre;

        ListNode temp = cur.next;
        cur.next = pre;

        return reverseList3_reverse(cur, temp);
    }

    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode listNode = reverseList2(head.next);
        //每次此处的head都在上一层递归中存储，其为下一层的前面。
        head.next.next = head;
        head.next = null;
        //return listNode;是因为listNode会在反转后的头节点
        return listNode;
    }
    
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;

        // cur != null不用temp判断是因为最后的时候，cur才是最终节点
        while (cur != null) {
            // 由前面循环最后一行进行下一步，变成后面循环第一行进行下一步
            ListNode temp = cur.next;
            cur.next = pre;

            pre = cur;
            cur = temp;
        }
        // 最前面的那个，要归零
        head.next = null;
        // 最后一次cur != null 时，cur 已经进行下一步了
        return pre;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }

}
