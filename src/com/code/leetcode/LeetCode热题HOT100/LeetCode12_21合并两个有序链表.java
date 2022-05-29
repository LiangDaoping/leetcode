package com.code.leetcode.LeetCode热题HOT100;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode12_21合并两个有序链表 {
    public static void main(String[] args) {
        int[] l1 = new int[]{1, 2, 4};
        int[] l2 = new int[]{1, 3, 4};
        initAndMergeTwoListsAndPrint(l1, l2); // [1,1,2,3,4,4]

        l1 = new int[]{};
        l2 = new int[]{};
        initAndMergeTwoListsAndPrint(l1, l2); // []

        l1 = new int[]{};
        l2 = new int[]{0};
        initAndMergeTwoListsAndPrint(l1, l2); // [0]
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode emptyHead = new ListNode();
        ListNode node = emptyHead;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                node.next = node2;
                node2 = node2.next;
            } else {
                node.next = node1;
                node1 = node1.next;
            }
            node = node.next;
        }
        if (node1 != null) {
            node.next = node1;
        }
        if (node2 != null) {
            node.next = node2;
        }
        return emptyHead.next;
    }

    public static void initAndMergeTwoListsAndPrint(int[] l1, int[] l2) {
        ListNode list1 = initListNode(l1);
        ListNode list2 = initListNode(l2);
        ListNode mergeTwoLists = mergeTwoLists(list1, list2);
        printListNode(mergeTwoLists);
    }

    private static void printListNode(ListNode mergeTwoLists) {
        ListNode node = mergeTwoLists;
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    private static ListNode initListNode(int[] l1) {
        if (l1 == null || l1.length == 0) {
            return new ListNode();
        }
        ListNode head = new ListNode(l1[0]);
        ListNode node = head;
        for (int i = 1; i < l1.length; i++) {
            node.next = new ListNode(l1[i]);
            node = node.next;
        }
        return head;
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
