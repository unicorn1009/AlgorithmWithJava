package com.unicorn.大厂热题;

import com.unicorn.Leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021-7-18.
 *
 * @author Unicorn
 */
public class LRU缓存机制 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);

    }

    static class LRUCache {

        static class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
            public DLinkedNode() {}
            public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
        }

        DLinkedNode dummyHead;
        DLinkedNode dummyTail;
        Map<Integer, DLinkedNode> map;
        int size;
        int capacity;

        public LRUCache(int capacity) {
            // 初始化双向链表
            dummyHead = new DLinkedNode();
            dummyTail = new DLinkedNode();
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;

            size = 0;
            this.capacity = capacity;
            map = new HashMap<>(capacity);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                int ret = map.get(key).value;
                // 当前节点移到链首
                moveElementToFirst(map.get(key));
                return 1;
            }
            else
                return -1;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)){
                // 存在, 只修改值
                map.get(key).value = value;
            }else {
                // 不存在, 需新增
                if (size == capacity){    // 需要扩容
                    // 移除链尾元素
                    // 删除map中对应元素
                    map.remove(dummyTail.prev.key);
                    dummyTail.prev = dummyTail.prev.prev;
                    dummyTail.prev.next = dummyTail;
                    size--;
                }
                addElement(key, value);
            }
        }

        public void addElement(int key, int value){
            DLinkedNode node = new DLinkedNode(key, value);
            map.put(key, node);
            node.next = dummyHead.next;
            dummyHead.next.prev = node;
            node.prev = dummyHead;
            dummyHead.next = node;
            size++;
        }


        public void moveElementToFirst(DLinkedNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = dummyHead.next;
            dummyHead.next.prev = node;
            node.prev = dummyHead;
            dummyHead.next = node;
        }
    }
}
