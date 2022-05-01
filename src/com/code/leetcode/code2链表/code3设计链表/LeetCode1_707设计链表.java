package com.code.leetcode.code2链表.code3设计链表;

public class LeetCode1_707设计链表 {
    public static void main(String[] args) {
        MyLinkedList2 linkedList = new MyLinkedList2();
        print(" ", linkedList);
        linkedList.addAtHead(1);
        print("addAtHead(1) ", linkedList);
        linkedList.addAtTail(3);
        print("addAtTail(3)", linkedList);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        print("addAtIndex(1,2)", linkedList);
        System.out.println("get1->" + linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        print("deleteAtIndex(0)", linkedList);
        System.out.println("get1->" + linkedList.get(1));            //返回3
    }

    public static void print(String msg, MyLinkedList2 list) {
        if (list == null) {
            System.out.println(msg);
            return;
        }
        System.out.print(msg + "->");
        MyLinkedList2.ListNode node = list.head;
        while (node.next != null) {
            node = node.next;
            if (node.next != null)
                System.out.print(node.val);
        }
        System.out.println();
    }

    static class MyLinkedList1 {

        static class ListNode {
            int val;
            ListNode next;
            ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;

        public MyLinkedList1() {
            size = 0;
            head = new ListNode(0);
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.next.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) return;
            if (index < 0) index = 0;
            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = node.next;
            node.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            size--;
            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.next = node.next.next;
        }
    }

    static class MyLinkedList2 {

        static class ListNode {
            int val;
            ListNode next;
            ListNode prev;
            ListNode(int val) {
                this.val = val;
            }
        }

        int size;
        ListNode head;
        ListNode tail;

        public MyLinkedList2() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            ListNode node = this.head;
            for (int i = 0; i <= index; i++) {
                node = node.next;
            }
            return node.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            ListNode node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            ListNode newNode = new ListNode(val);


            newNode.next = node.next;
            newNode.prev = node;


            node.next.prev = newNode;
            node.next = newNode;


        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            size--;
            ListNode prev = this.head;
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            prev.next = prev.next.next;
            prev.next.next.prev = prev;
        }
    }
}
