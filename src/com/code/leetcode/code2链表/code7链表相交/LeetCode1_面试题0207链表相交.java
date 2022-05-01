package com.code.leetcode.code2链表.code7链表相交;

public class LeetCode1_面试题0207链表相交 {
    public static void main(String[] args) {
        //getIntersectionNode1: 题解
        //removeNthFromEnd2:暴力，双层循环
        //removeNthFromEnd3:先分别计算a和b的长度，然后移动相差的长度。然后依次进行比较。


        int intersectVal = 8;
        int[] numsA = new int[]{4, 1, 8, 4, 5};
        int[] numsB = new int[]{5,0,1,8,4,5};
        int skipA = 2;
        int skipB = 3;
        ListNode intersection = new ListNode(intersectVal);
        ListNode listA = init(numsA, skipA, intersection);
        ListNode listB = init(numsB, skipB, intersection);
        ListNode node = getIntersectionNode3(listA, listB);
        System.out.println(node);//8



        intersectVal = 2;
        numsA = new int[]{0,9,1,2,4};
        numsB = new int[]{3,2,4};
        skipA = 3;
        skipB = 1;
        intersection = new ListNode(intersectVal);
        listA = init(numsA, skipA, intersection);
        listB = init(numsB, skipB, intersection);
        node = getIntersectionNode3(listA, listB);
        System.out.println(node);//8


        intersectVal = 0;
        numsA = new int[]{2,6,4};
        numsB = new int[]{1,5};
        skipA = 3;
        skipB = 2;
        intersection = new ListNode(intersectVal);
        listA = init(numsA, skipA, intersection);
        listB = init(numsB, skipB, intersection);
        node = getIntersectionNode3(listA, listB);
        System.out.println(node);//null

        intersectVal = 0;
        numsA = new int[]{2};
        numsB = new int[]{1};
        skipA = 3;
        skipB = 2;
        intersection = new ListNode(intersectVal);
        listA = init(numsA, skipA, intersection);
        listB = init(numsB, skipB, intersection);
        node = getIntersectionNode3(listA, listB);
        System.out.println(node);//null


    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        while (a != null) {
            ListNode temp = headB;
            while (temp != null) {
                if (a==temp) {
                    return a;
                }
                temp = temp.next;
            }
            a = a.next;
        }
        return null;
    }

    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aLen = 0;
        int bLen = 0;
        while (a != null) {
            aLen++;
            a = a.next;
        }
        while (b != null) {
            bLen++;
            b = b.next;
        }

        a = headA;
        b = headB;
        if (aLen > bLen) {
            int len = aLen - bLen;
            while (len > 0) {
                len--;
                a = a.next;
            }
        } else {
            int len = bLen - aLen;
            while (len > 0) {
                len--;
                b = b.next;
            }
        }
        while (a != null) {
            if (a == b) return a;
            a = a.next;
            b = b.next;
        }
        return a;
    }

    public static ListNode init(int[] nums, int skip, ListNode intersection) {
        if (nums.length < 1) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        if (intersection.val == 0) {
            skip = 0;
        }
        for (int i = 1; i < skip; i++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
        if (intersection.val != 0) {
            node.next = intersection;
            node = node.next;
        }
        for (int i = skip + 1; i < nums.length; i++) {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

}
