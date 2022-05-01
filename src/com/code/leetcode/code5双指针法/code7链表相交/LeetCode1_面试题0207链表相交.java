package com.code.leetcode.code5双指针法.code7链表相交;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/28
 */
public class LeetCode1_面试题0207链表相交 {
    public static void main(String[] args) {
        int intersectVal = 8;
        int[] listA = new int[]{4,1,8,4,5};
        int[] listB = new int[]{5,0,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        initListNode(listA, listB, intersectVal, skipA, skipB);//8


        intersectVal = 2;
        listA = new int[]{0,9,1,2,4};
        listB = new int[]{3,2,4};
        skipA = 3;
        skipB = 1;
        initListNode(listA, listB, intersectVal, skipA, skipB);//2


        intersectVal = 0;
        listA = new int[]{2,6,4};
        listB = new int[]{1,5};
        skipA = 3;
        skipB = 2;
        initListNode(listA, listB, intersectVal, skipA, skipB);//null


    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headB;
            nodeB = nodeB != null ? nodeB.next : headA;

        }
        return headA;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 求a长度
        int lenA = 0;
        ListNode nodeA = headA;
        while (nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }

        // 求b长度
        int lenB = 0;
        ListNode nodeB = headB;
        while (nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        // 将两者头放一起
        nodeA = headA;
        nodeB = headB;
        if (lenA > lenB) {
            int abs = lenA - lenB;
            while (abs > 0) {
                abs--;
                if (nodeA == null) {
                    return new ListNode();
                }
                nodeA = nodeA.next;
            }
        } else {
            int abs = lenB - lenA;
            while (abs > 0) {
                abs--;
                if (nodeB == null) {
                    return new ListNode();
                }
                nodeB = nodeB.next;
            }
        }
        // 一起下移动，检查是否相同
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public static void initListNode(int[] listA, int[] listB, int intersectVal, int skipA, int skipB) {
        ListNode intersectionA = new ListNode(intersectVal);
        ListNode headA = getListNodeA(listA, intersectionA, skipA);
        ListNode headB = getListNodeA(listB, intersectionA, skipB);
//        printListNode(headA);
//        printListNode(headB);
        ListNode res = getIntersectionNode(headA, headB);
        printListNode(res);
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
