package com.code.leetcode.code2链表.code5两两交换链表中的节点;

public class LeetCode1_24两两交换链表中的节点 {
    public static void main(String[] args) {
        //swapPairs1:加头节点
        //swapPairs2:加头节点,看着图重写
        //swapPairs3:递归

        int[] nums = {1,2,3,4};
        ListNode node = init(nums); // [2,1,4,3]
        node = swapPairs3(node);
        print(node);

        nums = new int[]{};
        node = init(nums);
        node = swapPairs3(node);
        print(node);

        nums = new int[]{1};
        node = init(nums);
        node = swapPairs3(node);
        print(node); // 1



    }


    public static ListNode swapPairs3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;

        ListNode nextHead = swapPairs3(head.next.next);
        head.next.next = head;
        head.next = nextHead;

        return newHead;
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode emptyHead = new ListNode(0);
        emptyHead.next = head;


        ListNode cur = emptyHead;
        while (cur.next != null && cur.next.next != null) {
            // 记录下一次调节的点
            ListNode temp = cur.next.next.next;

            cur.next.next.next = cur.next;
            cur.next = cur.next.next;
            cur.next.next.next = temp;

            cur = cur.next.next;
        }
        return emptyHead.next;
    }

    public static ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode emptyHead = new ListNode(0);
        emptyHead.next = head;


        ListNode cur = emptyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode one = cur.next;
            ListNode two = cur.next.next;
            ListNode three = cur.next.next.next;

            cur.next = two;
            two.next = one;
            one.next = three;

            cur = one;
        }
        return emptyHead.next;
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
