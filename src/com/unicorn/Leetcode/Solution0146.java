package com.unicorn.Leetcode;

import java.util.HashMap;

/**
 * <p>
 *     146. LRU 缓存机制
 * </p>
 * Created on 2021/04/01 13:24
 *
 * @author Unicorn
 */
public class Solution0146 {
    public static void main(String[] args) {
        // ,[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17]
        // ,[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
        LRUCache lruCache = new LRUCache(10);
        lruCache.put(10,13);
        lruCache.put(3,17);
        lruCache.put(6,11);
        lruCache.put(10,5);
        lruCache.put(9,10);
        System.out.println(lruCache.get(13));
        lruCache.put(2,19);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.put(5,25);
        System.out.println(lruCache.get(8));
        lruCache.put(9,22);
        lruCache.put(5,5);
        lruCache.put(1,30);
        System.out.println(lruCache.get(11));
        lruCache.put(9,12);
        System.out.println(lruCache.get(7));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(9));
        // ,[4,30],[9,3],[9],[10],[10],[6,14],[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],
        // [5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9]
        lruCache.put(4,30);
        lruCache.put(9,3);
        System.out.println(lruCache.get(9));
        System.out.println(lruCache.get(10));
        System.out.println(lruCache.get(10));
        lruCache.put(6,14);
        lruCache.put(3,1);
        System.out.println(lruCache.get(3));
        lruCache.put(10,11);
        System.out.println(lruCache.get(8));
        lruCache.put(2,14);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(4));
        lruCache.put(11,4);
        lruCache.put(12,24);
        lruCache.put(5,18);
        System.out.println(lruCache.get(13));
        lruCache.put(7,23);
        System.out.println(lruCache.get(8));
        System.out.println(lruCache.get(12));
        lruCache.put(3,27);
        lruCache.put(2,12);
        System.out.println(lruCache.get(5));
        lruCache.put(2,9);
        // [13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],
        // [9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9]
        lruCache.put(13,4);
        lruCache.put(8,18);
        lruCache.put(1,7);
        System.out.println(lruCache.get(6));
        lruCache.put(9,29);
        lruCache.put(8,21);
        System.out.println(lruCache.get(5));
        lruCache.put(6,30);
        lruCache.put(1,12);
        System.out.println(lruCache.get(10));
        System.out.println("===========");
        lruCache.put(4,15);
        lruCache.put(7,22);
        lruCache.put(11,26);
        lruCache.put(8,17);
        lruCache.put(9,29);
        System.out.println(lruCache.get(5));
        lruCache.put(3,4);
        lruCache.put(11,30);
        System.out.println(lruCache.get(12));
        System.out.println("===========");
        lruCache.put(4,29);
        System.out.println("===========");
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(9));



    }
}


class LRUCache {
    // 双向链表
    private class Node{
        public int[] kv;
        public Node pre;
        public Node next;

        public Node(int k, int v) {
            this.kv = new int[]{k, v};
        }
    }

    private HashMap<Integer, Node> map;
    private Node dummyHead;
    private Node dummyTail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        map = new HashMap<>(capacity);
        // 伪头结点 伪尾结点
        dummyHead = new Node(-1, -1);
        dummyTail = new Node(-1, -1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)){
            return -1;
        }else {
            // 缓存命中
            Node node = map.get(key);
            // 将该节点移动到头部
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = dummyHead;
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            dummyHead.next = node;

            return node.kv[1];
        }
    }

    public void put(int key, int value) {
        // 首先判断key是否存在。存在则只修改
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.kv[1] = value;
            // 还需将当前命中节点移动到头部
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = dummyHead;
            node.next = dummyHead.next;
            dummyHead.next.pre = node;
            dummyHead.next = node;
            return;
        }

        // 如果key不存在，需要添加节点， 则先判断容量是否已满
        if (size == capacity){
            // 已满, 移除尾结点, size--;
            int removeKey = dummyTail.pre.kv[0];
            // 空指针异常
            dummyTail.pre.pre.next = dummyTail;
            dummyTail.pre = dummyTail.pre.pre;
            size--;
            map.remove(removeKey);
        }
        // 添加节点
        Node node = new Node(key, value);
        map.put(key, node);
        node.pre = dummyHead;
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        dummyHead.next = node;
        size++;
    }
}