package com.code.leetcode.code2链表.code2移除链表元素;


public class LeetCode1_203移除链表元素 {
    public static void main(String[] args) {
        // 1：删除头结点时另做考虑（由于头结点没有前一个结点）
        // 2：添加一个虚拟头结点，删除头结点就不用另做考虑
        // 3：递归
        // 4：优化1
        int[] num = {1,2,6,3,4,5,6};
        int val = 6;
        initAndRemoveListNode(num, val); // [1,2,3,4,5]

        num = new int[]{};
        val = 1;
        initAndRemoveListNode(num, val); // []

        num = new int[]{7,7,7,7};
        val = 7;
        initAndRemoveListNode(num, val); // []

        num = new int[]{1};
        val = 2;
        initAndRemoveListNode(num, val); // [1]
    }

    public static void initAndRemoveListNode(int[] num, int val) {
        ListNode head = num.length == 0 ? null : new ListNode(num[0]);
        ListNode node = head;
        for (int i = 1; i < num.length; i++) {
            node.next = new ListNode(num[i]);
            node = node.next;
        }
        System.out.println("前");
        print(head);
        head = removeElements5(head, val);
        System.out.println("后");
        print(head);
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) {this.val = val;}
    }


    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = pre.next.next;
                node = node.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode emptyNode = new ListNode();
        emptyNode.next = head;

        ListNode pre = emptyNode;
        ListNode node = emptyNode.next;
        while (node != null) {
            if (node.val == val) {
                pre.next = pre.next.next;
                node = node.next;
            } else {
                pre = pre.next;
                node = node.next;
            }
        }
        return emptyNode.next;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements3(head.next,  val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static ListNode removeElements4(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements5(ListNode head, int val) {
        ListNode emptyNode = new ListNode();
        emptyNode.next = head;

        ListNode pre = emptyNode;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return emptyNode.next;
    }


}
