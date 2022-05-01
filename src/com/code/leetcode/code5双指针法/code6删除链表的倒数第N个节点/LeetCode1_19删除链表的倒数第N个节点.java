package com.code.leetcode.code5双指针法.code6删除链表的倒数第N个节点;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_19删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        int[] head = {1,2,3,4,5};
        int n = 2;
        ListNode h = initListNode(head);
        ListNode removeNthFromEnd = removeNthFromEnd(h, n);//[1,2,3,5]
        printListNode(removeNthFromEnd);

        head = new int[]{1};
        h = initListNode(head);
        n = 1;
        removeNthFromEnd = removeNthFromEnd(h, n);//[]
        printListNode(removeNthFromEnd);

        head = new int[]{1, 2};
        h = initListNode(head);
        n = 1;
        removeNthFromEnd = removeNthFromEnd(h, n);//[1]
        printListNode(removeNthFromEnd);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode empty = new ListNode();
        empty.next = head;


        ListNode slow = empty;
        ListNode fast = empty;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return empty.next;
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

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {this.val = val; }
        ListNode(int val, ListNode next) {this.val = val; this.next = next; }
    }

}
