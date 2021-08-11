package com.unicorn.大厂热题;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 * Created on 2021-8-11.
 *
 * @author Unicorn
 */
public class 手撕LFU {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(5);
        lfuCache.get(1);
        lfuCache.put(1, 2);
        lfuCache.put(1, 3);
        lfuCache.put(2, 2);
        lfuCache.put(4, 2);
    }
}

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node pre;
        Node next;

        public Node() { }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLList {
        // 头尾伪结点
        Node head;
        Node tail;

        public DLList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        void addHead(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }
    }

    Map<Integer, Node> map; // 存储缓存, Map的key为缓存的key
    Map<Integer, DLList> freqMap; // 每个频次维护一个双向链表
    int size;   // 当前元素个数
    int capacity;   // 允许存储的最大元素个数
    int minFreq; // 所有元素中的最小访问频次

    public LFUCache(int capacity) {
        map = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        // 如果存在, 则对应元素访问频次++
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node = map.get(key);
        // 如果key已存在, 则更新value, 并更新其访问频次
        if (node != null) {
            node.value = value;
            updateFreq(node);
        } else {    // key不存在, 则新增key到访问频次为1的链表中
            // 检查是否超出capacity, 超出则删除一个访问频次最低的
            if (size == capacity) {
                DLList minFreqLL = freqMap.get(minFreq);
                // 从缓存中删除
                map.remove(minFreqLL.tail.pre.key);
                // 从频次链表中删除
                minFreqLL.removeNode(minFreqLL.tail.pre); // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                size--;
            }

            // 将新节点插入访问频次为1的频次链表中
            node = new Node(key, value);
            map.put(key, node);
            DLList ll = freqMap.getOrDefault(1, new DLList());
            ll.addHead(node);
            freqMap.put(1, ll);
            size++;
            minFreq = 1;
        }
    }

    // node已存在，更新node的访问频次
    void updateFreq(Node node) {
        // 从原freq对应的链表里移除
        int preFreq = node.freq;
        DLList ll = freqMap.get(preFreq);
        ll.removeNode(node);
        // 如果当前频次链表为最低频次链表, 且从链表中删除node后链表为空时, 需要更新最小访问频次变量
        if (preFreq == minFreq && ll.head.next == ll.tail) {
            minFreq = preFreq + 1;
        }
        // 加入新freq对应的链表
        int curFreq = preFreq + 1;
        node.freq = curFreq;
        DLList curDLL = freqMap.getOrDefault(curFreq, new DLList());
        curDLL.addHead(node);
        freqMap.put(curFreq, curDLL);
    }
}

