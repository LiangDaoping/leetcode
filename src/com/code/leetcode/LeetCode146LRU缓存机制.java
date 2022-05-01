package com.code.leetcode;


import java.util.HashMap;
import java.util.Map;


public class LeetCode146LRU缓存机制 {
    private class LinkedListNode {
        private int key;
        private int value;
        private LinkedListNode pre;
        private LinkedListNode next;
        private LinkedListNode() { }

        private LinkedListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

//        private void print() {
//            LinkedListNode node = this;
//            while (node != null) {
//                System.out.print(node.key + " ");
//                node = node.next;
//            }
//            System.out.println("");
//        }
    }
//    LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//    void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

    private Map<Integer, LinkedListNode> cache = new HashMap<>();
    private int capacity;
    private int size;
    private LinkedListNode head;
    private LinkedListNode tail;


    public LeetCode146LRU缓存机制(int capacity) {
        this.capacity = capacity;
        head = new LinkedListNode();
        tail = new LinkedListNode();
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            //新建节点newNode(key, value)
            LinkedListNode newNode = new LinkedListNode(key, value);
            cache.put(key, newNode);
            ++size;
            //cache中放入newNode
            //查看是否超过容量，超过则删除尾节点
            if (size > capacity) {
                //cache中删除key
                cache.remove(tail.pre.key);
                removeNode(tail.pre);
                --size;
            }
            //newNode放入表头
            addToHead(newNode);
        } else {
            //更新node的value
            node.value = value;
            //将node移到表头
            moveToHead(node);
        }
//        head.print();
    }

    public int get(int key) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
//            head.print();
            return -1;
        } else {
            //将node移动到表头
            moveToHead(node);
//            head.print();
            return node.value;
        }
    }

    public void addToHead(LinkedListNode node) {
        head.next.pre = node;
        node.next = head.next;

        head.next = node;
        node.pre = head;
    }

    public void moveToHead(LinkedListNode node) {
        //将自己摘出去
        removeNode(node);
        //添加到头
        addToHead(node);
    }

    public void removeNode(LinkedListNode node) {
        //链表中断开连接
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public static void main(String[] args) {
        LeetCode146LRU缓存机制 lRUCache = new LeetCode146LRU缓存机制(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

}
