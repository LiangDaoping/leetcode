package com.code.leetcode.code5双指针法.code8环形链表II;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_142环形链表II {
    public static void main(String[] args) {
        int[] head = new int[]{3,2,0,-4};
        int pos = 1;
        ListNode listNode = initListNode(head, pos);
        System.out.println(detectCycle(listNode));

        head = new int[]{1,2};
        pos = 0;
        listNode = initListNode(head, pos);
        System.out.println(detectCycle(listNode));

        head = new int[]{1};
        pos = -1;
        listNode = initListNode(head, pos);
        System.out.println(detectCycle(listNode));

        head = new int[]{1,2};
        pos = -1;
        listNode = initListNode(head, pos);
        System.out.println(detectCycle(listNode));

    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                // 当两者相遇时，慢指针距离入点的距离，和head到入点的距离相同
                // 原因如下：
                // 首先假设：
                    // 设从head到交点的长度为a
                    // 设当slow在交点位置时，fast的位置为a+a
                    // 设环的长度为c
                // 推断：
                    // 在slow在交点位置时：因为每次fast会比slow快一步，fast再次走2*(c-a)的长度则可以相交
                    // 当slow和fast相交时：
                        // 其中当前处于环的位置为：
                        // a+2*(c-a)    -> 前面是仅加一个a是因为，最开始的a是非环的位置
                        // = a+2c-2a
                        // = 2c-a
                        // = c-a        -> 每一个c是一次循环，因此c+c-b=c- b的位置
                        // 距离交点位置为：
                        // c-(c-a) = a
                    // slow到交点位置为a，head到交点位置为a
                fast = head;
                while (slow != fast) {
                   slow = slow.next;
                   fast = fast.next;
                }
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static ListNode initListNode(int[] node, int pos) {
        ListNode head = new ListNode();
        if (node.length == 0) return head;
        head = new ListNode(node[0]);


        ListNode n = head;
        ListNode posListNode = pos == 0 ? head : null;
        for (int i = 1; i < node.length; i++) {
            n.next = new ListNode(node[i]);
            if (pos == i) {
                posListNode = n.next;
            }
            n = n.next;
        }
        n.next = posListNode;
        return head;
    }

    private static ListNode getListNodeA(int[] listA, ListNode intersectionA, int skipA) {
        ListNode headA = new ListNode();
        if (listA.length != 0) {
            headA = new ListNode(listA[0]);
        }
        if (skipA == 0) {
            headA = intersectionA;
        }
        ListNode node = headA;
        for (int i = 1; i < listA.length; i++) {
            if (i == skipA) {
                node.next = intersectionA;
            } else {
                node.next = new ListNode(listA[i]);
            }
            node = node.next;
        }
        return headA;
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
